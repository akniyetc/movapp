package com.inc.silence.movapp.di.modules;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import com.f2prateek.rx.preferences2.RxSharedPreferences;
import com.inc.silence.movapp.data.settings.MoviesFilter;
import com.inc.silence.movapp.di.qualifier.ActivityContext;
import com.inc.silence.movapp.di.scopes.ActivityScope;
import com.inc.silence.movapp.di.scopes.ApplicationScope;
import com.inc.silence.movapp.presentation.movies.movieDetail.DetailMoviePresenter;
import com.inc.silence.movapp.presentation.movies.movieDetail.DetailMoviePresenterImpl;
import com.inc.silence.movapp.presentation.movies.popularMovies.PopularMoviesPresenter;
import com.inc.silence.movapp.presentation.movies.popularMovies.PopularMoviesPresenterImpl;
import com.inc.silence.movapp.utils.CommonUtils;

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
    DetailMoviePresenter provideDetailMoviePresenter(DetailMoviePresenterImpl detailMoviePresenter) {
        return detailMoviePresenter;
    }
}
