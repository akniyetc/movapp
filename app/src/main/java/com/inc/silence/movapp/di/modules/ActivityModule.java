package com.inc.silence.movapp.di.modules;

import com.inc.silence.movapp.di.scopes.ApplicationScope;
import com.inc.silence.movapp.presentation.movies.detail.DetailMoviePresenter;
import com.inc.silence.movapp.presentation.movies.detail.DetailMoviePresenterImpl;
import com.inc.silence.movapp.presentation.movies.popular.PopularMoviesPresenter;
import com.inc.silence.movapp.presentation.movies.popular.PopularMoviesPresenterImpl;
import com.inc.silence.movapp.presentation.movies.rated.TopRatedMoviesPresenter;
import com.inc.silence.movapp.presentation.movies.rated.TopRatedMoviesPresenterImpl;

import dagger.Module;
import dagger.Provides;

/**
 * Created by silence on 01.01.2018.
 */
@Module
public class ActivityModule {

    @ApplicationScope
    @Provides
    PopularMoviesPresenter providePopularMoviesPresenter(PopularMoviesPresenterImpl popularMoviesPresenter) {
        return popularMoviesPresenter;
    }

    @ApplicationScope
    @Provides
    TopRatedMoviesPresenter provideTopRatedMoviesPresenter(TopRatedMoviesPresenterImpl topRatedMoviesPresenter) {
        return topRatedMoviesPresenter;
    }

    @ApplicationScope
    @Provides
    DetailMoviePresenter provideDetailMoviePresenter(DetailMoviePresenterImpl detailMoviePresenter) {
        return detailMoviePresenter;
    }
}
