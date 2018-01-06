package com.inc.silence.movapp.di.components;


import com.inc.silence.movapp.di.modules.AppModule;
import com.inc.silence.movapp.di.scopes.ApplicationScope;
import com.inc.silence.movapp.ui.detail.MovieDetailActivity;
import com.inc.silence.movapp.ui.detail.MovieDetailFragment;
import com.inc.silence.movapp.ui.main.MoviesActivity;
import com.inc.silence.movapp.ui.main.MoviesListViewHolder;
import com.inc.silence.movapp.ui.main.popular.PopularMoviesFragment;
import com.inc.silence.movapp.ui.main.topRated.TopRatedMoviesFragment;

import dagger.Component;

/**
 * Created by silence on 07.12.2017.
 */
@ApplicationScope
@Component(modules = {AppModule.class})
public interface AppComponent {

    void inject(MoviesActivity moviesActivity);

    void inject(PopularMoviesFragment popularMoviesFragment);

    void inject(TopRatedMoviesFragment topRatedMoviesFragment);

    void inject(MoviesListViewHolder moviesListViewHolder);

    void inject(MovieDetailActivity movieDetailActivity);

    void inject(MovieDetailFragment movieDetailFragment);

}
