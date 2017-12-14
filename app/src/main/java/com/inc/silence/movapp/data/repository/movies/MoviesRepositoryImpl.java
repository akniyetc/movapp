package com.inc.silence.movapp.data.repository.movies;

import com.inc.silence.movapp.data.exception.ExceptionFactory;
import com.inc.silence.movapp.data.settings.MovieQuery;
import com.inc.silence.movapp.data.settings.MoviesFilter;
import com.inc.silence.movapp.di.scopes.ApplicationScope;
import com.inc.silence.movapp.domain.entity.main.MovieDetail;
import com.inc.silence.movapp.domain.entity.main.Movies;
import com.inc.silence.movapp.domain.repository.movies.MoviesRepository;

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
    private MovieQuery mMovieQuery;

    @Inject
    public MoviesRepositoryImpl(MoviesCloudStorage moviesCloudStorage, MoviesLocalStorage moviesLocalStorage) {
        mMoviesCloudStorage = moviesCloudStorage;
        mMoviesLocalStorage = moviesLocalStorage;
    }

    @Override
    public Observable<Movies> getPopular(MoviesFilter moviesFilter, String id) {
        mMoviesFilter = moviesFilter;
        return Observable.create((ObservableOnSubscribe<Movies>) e -> {
            if (mMoviesFilter.isCached()) {
                mMoviesLocalStorage
                        .getPopular(mMoviesFilter.getQueries(), id)
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
                        .getPopular(mMoviesFilter.getQueries(), id)
                        .doOnNext(movies -> mMoviesLocalStorage.savePopularMovies(movies, !mMoviesFilter.isLoadMore()))
                        .subscribe(movies -> {
                            if (!e.isDisposed()) {
                                mMoviesFilter.setPage(movies.getPage() + 1);
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

    private void getPopularMoviesFromLocalStore(ObservableEmitter<Movies> e, Throwable t, String id) {
        mMoviesLocalStorage
                .getPopular(mMoviesFilter.getQueries(), id)
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
    public Observable<Movies> getTopRated(MoviesFilter moviesFilter, String id) {
        mMoviesFilter = moviesFilter;
        return Observable.create((ObservableOnSubscribe<Movies>) e -> {
            if (mMoviesFilter.isCached()) {
                mMoviesLocalStorage
                        .getTopRated(mMoviesFilter.getQueries(), id)
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
                        .getTopRated(mMoviesFilter.getQueries(), id)
                        .doOnNext(movies -> mMoviesLocalStorage.savePopularMovies(movies, !mMoviesFilter.isLoadMore()))
                        .subscribe(movies -> {
                            if (!e.isDisposed()) {
                                mMoviesFilter.setPage(movies.getPage() + 1);
                                e.onNext(movies);
                            }
                        }, throwable -> {
                            if (!e.isDisposed()) {
                                getTopRatedMoviesFromLocalStore(e, throwable, id);
                            }
                        });
            }
        })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread(), true);
    }

    private void getTopRatedMoviesFromLocalStore(ObservableEmitter<Movies> e, Throwable t, String id) {
        mMoviesLocalStorage
                .getTopRated(mMoviesFilter.getQueries(), id)
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
    public Observable<MovieDetail> getMovieDetail(String id, MovieQuery query) {
        mMovieQuery = query;
        return Observable.create((ObservableOnSubscribe<MovieDetail>) e -> mMoviesCloudStorage
                .getDetailMovie(id, mMovieQuery.getQueries())
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
                .getDetailMovie(id, mMovieQuery.getQueries())
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
