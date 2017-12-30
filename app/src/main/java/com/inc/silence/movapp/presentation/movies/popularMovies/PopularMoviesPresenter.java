package com.inc.silence.movapp.presentation.movies.popularMovies;

import com.arellomobile.mvp.InjectViewState;
import com.inc.silence.movapp.R;
import com.inc.silence.movapp.data.settings.MoviesFilter;
import com.inc.silence.movapp.domain.entity.main.Movies;
import com.inc.silence.movapp.domain.entity.movies.Movie;
import com.inc.silence.movapp.domain.interactor.base.InteractorObserver;
import com.inc.silence.movapp.domain.interactor.movies.PopularMoviesInteractor;
import com.inc.silence.movapp.presentation.base.BasePresenter;
import com.inc.silence.movapp.presentation.exception.ErrorMessageFactory;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by silence on 30.12.2017.
 */
@InjectViewState
public class PopularMoviesPresenter extends BasePresenter<PopularMoviesView> {

    private PopularMoviesInteractor mPopularMoviesInteractor;
    private MoviesFilter mMoviesFilter;
    private List<Movie> mMoviesList;
    private int mAllItemsCount;

    @Inject
    public PopularMoviesPresenter(PopularMoviesInteractor popularMoviesInteractor, MoviesFilter moviesFilter) {
        mPopularMoviesInteractor = popularMoviesInteractor;
        mMoviesFilter = moviesFilter;
        mMoviesList = new ArrayList<>();
    }

    public void getPopularMovies(boolean cached) {
        mMoviesFilter.setCached(cached);
        mMoviesFilter.setPage(0);
        mMoviesFilter.setLoadMore(false);
        getPopularMoviesList();
    }

    private void loadMore() {
        if (mAllItemsCount > mMoviesList.size()) {
            mMoviesFilter.setLoadMore(true);
            mMoviesFilter.setCached(false);
            getPopularMoviesList();
        }
    }

    private void getPopularMoviesList() {
        getViewState().showLoadingProgress();
        mPopularMoviesInteractor.execute(new PopularMoviesListObserver(),
                PopularMoviesInteractor.Params.create(mMoviesFilter, "1"));
    }

    private void showErrorMessage(Throwable throwable) {
        getViewState().hideLoadingProgress();
        getViewState().showErrorMessage(ErrorMessageFactory.create(getViewState().getContext(), throwable));
    }

    @Override
    public void detachView(PopularMoviesView view) {
        super.detachView(view);
        if (mPopularMoviesInteractor != null) {
            mPopularMoviesInteractor.dispose();
        }
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
            getViewState().setSubtitle(String.format(getViewState().getContext().getString(R.string.movies_count), movies.getTotal_results()));
            getViewState().getPopularMoviesDone(mMoviesList);
            getViewState().hideLoadingProgress();
        }

        @Override
        public void onError(Throwable e) {
            showErrorMessage(e);
        }
    }
}
