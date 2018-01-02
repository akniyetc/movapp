package com.inc.silence.movapp.presentation.movies.movieDetail;

import com.inc.silence.movapp.data.settings.MoviesFilter;
import com.inc.silence.movapp.domain.entity.main.MovieDetail;
import com.inc.silence.movapp.domain.interactor.base.InteractorObserver;
import com.inc.silence.movapp.domain.interactor.movies.MovieDetailInteractor;
import com.inc.silence.movapp.presentation.exception.ErrorMessageFactory;

import javax.inject.Inject;

/**
 * Created by silence on 02.01.2018.
 */

public class DetailMoviePresenterImpl extends DetailMoviePresenter {

    private MovieDetailInteractor mMovieDetailInteractor;
    private MoviesFilter mMoviesFilter;

    @Inject
    public DetailMoviePresenterImpl(MovieDetailInteractor movieDetailInteractor, MoviesFilter moviesFilter) {
        mMovieDetailInteractor = movieDetailInteractor;
        mMoviesFilter = moviesFilter;
    }

    private void showErrorMessage(Throwable throwable) {
        getView().hideLoadingProgress();
        getView().showErrorMessage(ErrorMessageFactory.create(getView().getContext(), throwable));
    }

    @Override
    public void getMovieDetail(String id) {
        getView().showLoadingProgress();
        mMovieDetailInteractor.execute(new MovieDetailObserver(), MovieDetailInteractor.Params.create(mMoviesFilter, id));
    }

    @Override
    public void detachView() {
        if (mMovieDetailInteractor != null) {
            mMovieDetailInteractor.dispose();
        }
    }

    @Override
    public void onViewAttached() {

    }

    public final class MovieDetailObserver extends InteractorObserver<MovieDetail> {
        @Override
        public void onNext(MovieDetail movieDetail) {
            getView().getDetailMovieDone(movieDetail);
            getView().hideLoadingProgress();
        }

        @Override
        public void onError(Throwable e) {
            showErrorMessage(e);
        }
    }
}
