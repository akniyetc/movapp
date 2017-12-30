package com.inc.silence.movapp.di.modules;

import com.inc.silence.movapp.data.repository.movies.MoviesRepositoryImpl;
import com.inc.silence.movapp.di.scopes.ApplicationScope;
import com.inc.silence.movapp.domain.repository.movies.MoviesRepository;

import dagger.Module;
import dagger.Provides;
import io.realm.annotations.PrimaryKey;

/**
 * Created by silence on 07.12.2017.
 */
@Module
public class RepositoryModule {

    @Provides
    @ApplicationScope
    MoviesRepository provideMoviesRepository(MoviesRepositoryImpl moviesRepository) {
        return moviesRepository;
    }
}
