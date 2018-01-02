package com.inc.silence.movapp.presentation.movies.movieDetail;

import android.content.Context;

import com.arellomobile.mvp.InjectViewState;
import com.inc.silence.movapp.data.settings.MoviesFilter;
import com.inc.silence.movapp.domain.entity.main.MovieDetail;
import com.inc.silence.movapp.domain.interactor.base.InteractorObserver;
import com.inc.silence.movapp.domain.interactor.movies.MovieDetailInteractor;
import com.inc.silence.movapp.presentation.base.BasePresenter;
import com.inc.silence.movapp.presentation.exception.ErrorMessageFactory;

import javax.inject.Inject;

/**
 * Created by silence on 02.01.2018.
 */

public abstract class DetailMoviePresenter extends BasePresenter<DetailMovieView> {

    public abstract void getMovieDetail(String id);
}
