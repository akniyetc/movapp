package com.inc.silence.movapp.presentation.movies.popularMovies;

import com.inc.silence.movapp.R;
import com.inc.silence.movapp.data.settings.MoviesFilter;
import com.inc.silence.movapp.domain.entity.main.Movies;
import com.inc.silence.movapp.domain.entity.movies.Movie;
import com.inc.silence.movapp.domain.interactor.base.InteractorObserver;
import com.inc.silence.movapp.domain.interactor.movies.PopularMoviesInteractor;
import com.inc.silence.movapp.presentation.exception.ErrorMessageFactory;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by silence on 02.01.2018.
 */

public class PopularMoviesPresenterImpl extends PopularMoviesPresenter {

    private PopularMoviesInteractor mPopularMoviesInteractor;
    private MoviesFilter mMoviesFilter;
    private List<Movie> mMoviesList;
    private int mAllItemsCount;

    @Inject
    public PopularMoviesPresenterImpl(PopularMoviesInteractor popularMoviesInteractor, MoviesFilter moviesFilter) {
        mPopularMoviesInteractor = popularMoviesInteractor;
        mMoviesFilter = moviesFilter;
        mMoviesList = new ArrayList<>();
    }

    @Override
    public void getPopularMovies(boolean cached) {
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

    private void getPopularMoviesList() {
        getView().showLoadingProgress();
        mPopularMoviesInteractor.execute(new PopularMoviesListObserver(),
                PopularMoviesInteractor.Params.create(mMoviesFilter, "1"));
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

    private final class PopularMoviesListObserver extends InteractorObserver<Movies> {

        @Override
        public void onNext(Movies movies) {
            super.onNext(movies);
            if (mMoviesFilter.isLoadMore()) {
                mMoviesList.addAll(movies.getResults());
            } else {
                mMoviesList = movies.getResults();
            }
            mAllItemsCount = movies.getTotal_pages();
            //mMoviesFilter.setPage(mMoviesList.size() / movies.getPage());
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
