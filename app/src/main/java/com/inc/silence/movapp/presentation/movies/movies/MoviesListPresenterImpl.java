package com.inc.silence.movapp.presentation.movies.movies;

import com.inc.silence.movapp.R;
import com.inc.silence.movapp.data.settings.MoviesFilter;
import com.inc.silence.movapp.domain.entity.main.Movies;
import com.inc.silence.movapp.domain.entity.movies.Movie;
import com.inc.silence.movapp.domain.interactor.base.InteractorObserver;
import com.inc.silence.movapp.domain.interactor.movies.MoviesListInteractor;
import com.inc.silence.movapp.presentation.exception.ErrorMessageFactory;
import com.inc.silence.movapp.presentation.navigator.Navigator;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by silence on 02.01.2018.
 */

public class MoviesListPresenterImpl extends MoviesListPresenter {

    private MoviesListInteractor mPopularMoviesInteractor;
    private MoviesFilter mMoviesFilter;
    private List<Movie> mMoviesList;
    private int mAllItemsCount;
    private String mType;

    @Inject
    public MoviesListPresenterImpl(MoviesListInteractor popularMoviesInteractor, MoviesFilter moviesFilter) {
        mPopularMoviesInteractor = popularMoviesInteractor;
        mMoviesFilter = moviesFilter;
        mMoviesList = new ArrayList<>();
    }

    @Override
    public void getMovies(boolean cached) {
        mMoviesFilter.setCached(cached);
        mMoviesFilter.setPage(1);
        mMoviesFilter.setLoadMore(false);
        getPopularMoviesList();
    }
    
    @Override
    public void loadMore() {
        if (mAllItemsCount > mMoviesList.size()) {
            mMoviesFilter.setLoadMore(true);
            mMoviesFilter.setCached(false);
            getPopularMoviesList();
        }
    }
    
    @Override
    public void setType(final String type) {
        mType = type;
    }
    
    private void getPopularMoviesList() {
        getView().showLoadingProgress();
        mPopularMoviesInteractor.execute(new MoviesListObserver(),
                MoviesListInteractor.Params.create(mMoviesFilter, mType));
    }

    public void showErrorMessage(Throwable throwable) {
        getView().hideLoadingProgress();
        getView().showErrorMessage(ErrorMessageFactory.create(getView().getContext(), throwable));
    }


    @Override
    public void detachView() {
        if (mPopularMoviesInteractor != null) {
            mPopularMoviesInteractor.dispose();
        }
    }

    @Override
    public void onViewAttached() {

    }

    private final class MoviesListObserver extends InteractorObserver<Movies> {

        @Override
        public void onNext(Movies movies) {
            super.onNext(movies);
            if (mMoviesFilter.isLoadMore()) {
                mMoviesList.addAll(movies.getResults());
            } else {
                mMoviesList = movies.getResults();
            }
            mAllItemsCount = movies.getTotal_pages();
            
            getView().setSubtitle(String.format(getView().getContext().getString(R.string.movies_count), movies.getTotal_results()));
            getView().getPopularMoviesDone(mMoviesList);
            getView().hideLoadingProgress();
        }

        @Override
        public void onError(Throwable e) {
            showErrorMessage(e);
        }
    }

}
