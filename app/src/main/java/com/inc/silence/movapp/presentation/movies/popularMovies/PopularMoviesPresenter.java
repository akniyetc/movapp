package com.inc.silence.movapp.presentation.movies.popularMovies;

import android.content.Context;

import com.arellomobile.mvp.InjectViewState;
import com.inc.silence.movapp.R;
import com.inc.silence.movapp.app.App;
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

public abstract class PopularMoviesPresenter extends BasePresenter<PopularMoviesView> {

    public abstract void getPopularMovies (boolean cached);

    public abstract void loadMore();
}
