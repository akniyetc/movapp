package com.inc.silence.movapp.data.repository.movies;

import com.inc.silence.movapp.data.exception.ExceptionFactory;
import com.inc.silence.movapp.data.settings.MoviesFilter;
import com.inc.silence.movapp.di.scopes.ApplicationScope;
import com.inc.silence.movapp.domain.entity.main.MovieDetail;
import com.inc.silence.movapp.domain.entity.main.Movies;
import com.inc.silence.movapp.domain.entity.movies.Movie;
import com.inc.silence.movapp.domain.repository.movies.MoviesRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by silence on 11.12.2017.
 */
@ApplicationScope
public class MoviesRepositoryImpl implements MoviesRepository {
	
	private MoviesCloudStorage mMoviesCloudStorage;
	private MoviesLocalStorage mMoviesLocalStorage;
	private MoviesFilter mMoviesFilter;
	
	@Inject
	public MoviesRepositoryImpl(MoviesCloudStorage moviesCloudStorage, MoviesLocalStorage moviesLocalStorage) {
		mMoviesCloudStorage = moviesCloudStorage;
		mMoviesLocalStorage = moviesLocalStorage;
	}
	
	@Override
	public Observable<List<Movie>> getMoviesList(MoviesFilter moviesFilter, String id) {
		mMoviesFilter = moviesFilter;
		return Observable.create((ObservableOnSubscribe<List<Movie>>) e -> {
			if (mMoviesFilter.isCached()) {
				mMoviesLocalStorage
					.getMovies(mMoviesFilter.getQueriesMovies(), id)
					.subscribe(movies -> {
						if (!e.isDisposed()) {
							e.onNext(movies);
						}
					}, throwable -> {
						if (!e.isDisposed()) {
							e.onError(ExceptionFactory.getException(throwable));
						}
					});
			} else {
				mMoviesCloudStorage
					.getMovies(mMoviesFilter.getQueriesMovies(), id)
					.doOnNext(movies -> mMoviesLocalStorage.saveMovies(movies, !mMoviesFilter.isLoadMore(), id))
					.subscribe(movies -> {
						if (!e.isDisposed()) {
							e.onNext(movies);
						}
					}, throwable -> {
						if (!e.isDisposed()) {
							getPopularMoviesFromLocalStore(e, throwable, id);
						}
					});
			}
		})
			.subscribeOn(Schedulers.io())
			.observeOn(AndroidSchedulers.mainThread(), true);
	}
	
	private void getPopularMoviesFromLocalStore(ObservableEmitter<List<Movie>> e, Throwable t, String id) {
		mMoviesLocalStorage
			.getMovies(mMoviesFilter.getQueriesMovies(), id)
			.subscribe(movies -> {
				if (!e.isDisposed()) {
					if (!mMoviesFilter.isLoadMore()) {
						e.onNext(movies);
					}
					e.onError(ExceptionFactory.getException(t));
				}
			}, throwable -> {
				if (!e.isDisposed()) {
					e.onError(ExceptionFactory.getException(throwable));
				}
			});
	}
	
	@Override
	public Observable<MovieDetail> getMovieDetail(String id, MoviesFilter moviesFilter) {
		mMoviesFilter = moviesFilter;
		return Observable.create((ObservableOnSubscribe<MovieDetail>) e -> mMoviesCloudStorage
			.getDetailMovie(id, mMoviesFilter.getQueriesMovieDetail())
			.doOnNext(movieDetail -> mMoviesLocalStorage.saveMovieDetail(movieDetail))
			.subscribe(movieFull -> {
				if (!e.isDisposed()) {
					e.onNext(movieFull);
				}
			}, throwable -> {
				if (!e.isDisposed()) {
					getMovieDetailFromLocalStore(e, throwable, id);
				}
			}))
			.subscribeOn(Schedulers.io())
			.observeOn(AndroidSchedulers.mainThread(), true);
	}
	
	private void getMovieDetailFromLocalStore(ObservableEmitter<MovieDetail> e, Throwable t, String id) {
		mMoviesLocalStorage
			.getDetailMovie(id, mMoviesFilter.getQueriesMovieDetail())
			.subscribe(movieDetail -> {
				if (!e.isDisposed()) {
					e.onNext(movieDetail);
					e.onError(ExceptionFactory.getException(t));
				}
			}, throwable -> {
				if (!e.isDisposed()) {
					e.onError(ExceptionFactory.getException(throwable));
				}
			});
	}
}
