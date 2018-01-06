package com.inc.silence.movapp.presentation.movies.rated;

import com.inc.silence.movapp.R;
import com.inc.silence.movapp.data.settings.MoviesFilter;
import com.inc.silence.movapp.domain.entity.main.Movies;
import com.inc.silence.movapp.domain.entity.movies.Movie;
import com.inc.silence.movapp.domain.interactor.base.InteractorObserver;
import com.inc.silence.movapp.domain.interactor.movies.PopularMoviesInteractor;
import com.inc.silence.movapp.domain.interactor.movies.TopRatedMoviesInteractor;
import com.inc.silence.movapp.presentation.exception.ErrorMessageFactory;
import com.inc.silence.movapp.presentation.movies.popular.PopularMoviesPresenterImpl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by silence on 05.01.2018.
 */

public class TopRatedMoviesPresenterImpl extends TopRatedMoviesPresenter {

    private TopRatedMoviesInteractor mTopRatedMoviesInteractor;
    private MoviesFilter mMoviesFilter;
    private List<Movie> mMovieList;
    private int mAllItemsCount;

    @Inject
    public TopRatedMoviesPresenterImpl(TopRatedMoviesInteractor topRatedMoviesInteractor, MoviesFilter moviesFilter) {
        mTopRatedMoviesInteractor = topRatedMoviesInteractor;
        mMoviesFilter = moviesFilter;
        mMovieList = new ArrayList<>();
    }

    @Override
    public void getTopRatedMovies(boolean cached) {
        mMoviesFilter.setCached(cached);
        mMoviesFilter.setPage(1);
        mMoviesFilter.setLoadMore(false);
        getTopRatedMoviesList();
    }

    @Override
    public void loadMore() {
        if (mAllItemsCount > mMovieList.size()) {
            mMoviesFilter.setLoadMore(true);
            mMoviesFilter.setCached(false);
            getTopRatedMoviesList();
        }
    }

    @Override
    public void detachView() {
        if (mTopRatedMoviesInteractor != null) {
            mTopRatedMoviesInteractor.dispose();
        }
    }

    @Override
    public void onViewAttached() {

    }

    private void getTopRatedMoviesList() {
        getView().showLoadingProgress();
        mTopRatedMoviesInteractor.execute(new TopRatedMoviesListObserver(),
                TopRatedMoviesInteractor.Params.create(mMoviesFilter, "2"));
    }

    public void showErrorMessage(Throwable throwable) {
        getView().hideLoadingProgress();
        getView().showErrorMessage(ErrorMessageFactory.create(getView().getContext(), throwable));
    }

    private final class TopRatedMoviesListObserver extends InteractorObserver<Movies> {

        @Override
        public void onNext(Movies movies) {
            super.onNext(movies);
            if (mMoviesFilter.isLoadMore()) {
                mMovieList.addAll(movies.getResults());
            } else {
                mMovieList = movies.getResults();
            }
            mAllItemsCount = movies.getTotal_pages();
            //mMoviesFilter.setPage(mMoviesList.size() / movies.getPage());
            getView().setSubtitle(String.format(getView().getContext().getString(R.string.movies_count), movies.getTotal_results()));
            getView().getTopRatedMoviesDone(mMovieList);
            getView().hideLoadingProgress();
        }

        @Override
        public void onError(Throwable e) {
            showErrorMessage(e);
        }
    }
}
