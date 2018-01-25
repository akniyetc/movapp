package com.inc.silence.movapp.di.modules;

import com.inc.silence.movapp.di.scopes.ApplicationScope;
import com.inc.silence.movapp.presentation.movies.detail.DetailMoviePresenter;
import com.inc.silence.movapp.presentation.movies.detail.DetailMoviePresenterImpl;
import com.inc.silence.movapp.presentation.movies.movies.MoviesListPresenter;
import com.inc.silence.movapp.presentation.movies.movies.MoviesListPresenterImpl;

import dagger.Module;
import dagger.Provides;

/**
 * Created by silence on 01.01.2018.
 */
@Module
public class ActivityModule {

    @ApplicationScope
    @Provides
    MoviesListPresenter providePopularMoviesPresenter(MoviesListPresenterImpl popularMoviesPresenter) {
        return popularMoviesPresenter;
    }

    @ApplicationScope
    @Provides
    DetailMoviePresenter provideDetailMoviePresenter(DetailMoviePresenterImpl detailMoviePresenter) {
        return detailMoviePresenter;
    }
}
