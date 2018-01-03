package com.inc.silence.movapp.ui.detail;

import android.os.Bundle;

import com.inc.silence.movapp.app.App;
import com.inc.silence.movapp.di.components.AppComponent;
import com.inc.silence.movapp.domain.entity.main.MovieDetail;
import com.inc.silence.movapp.presentation.movies.movieDetail.DetailMoviePresenter;
import com.inc.silence.movapp.presentation.movies.movieDetail.DetailMovieView;
import com.inc.silence.movapp.ui.base.BaseFragment;

import javax.inject.Inject;

/**
 * Created by silence on 01.01.2018.
 */

public class MovieDetailFragment extends BaseFragment implements DetailMovieView {

    private String mMovieID;

    @Inject
    DetailMoviePresenter mDetailMoviePresenter;

    @Override
    public void setupComponent(AppComponent appComponent) {
        App.getAppComponent().inject(this);
    }

    public static MovieDetailFragment newInstance(String id) {

        Bundle args = new Bundle();
        args.putString(MovieDetailActivity.EXTRA_ID, id);
        MovieDetailFragment fragment = new MovieDetailFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public void loadData(String id) {
        mMovieID = id;
        mDetailMoviePresenter.getMovieDetail(mMovieID);
    }

    @Override
    public void showLoadingProgress() {

    }

    @Override
    public void hideLoadingProgress() {

    }

    @Override
    public void showErrorMessage(String error) {

    }

    @Override
    public void getDetailMovieDone(MovieDetail movieDetail) {

    }
}
