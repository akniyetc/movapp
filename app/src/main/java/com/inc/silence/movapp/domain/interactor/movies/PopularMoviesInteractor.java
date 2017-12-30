package com.inc.silence.movapp.domain.interactor.movies;

import com.inc.silence.movapp.data.settings.MoviesFilter;
import com.inc.silence.movapp.domain.entity.main.Movies;
import com.inc.silence.movapp.domain.interactor.base.Interactor;
import com.inc.silence.movapp.domain.repository.movies.MoviesRepository;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by silence on 15.12.2017.
 */

public class PopularMoviesInteractor extends Interactor<Movies, PopularMoviesInteractor.Params> {

    private MoviesRepository mMoviesRepository;

    @Inject
    public PopularMoviesInteractor(MoviesRepository moviesRepository) {
        mMoviesRepository = moviesRepository;
    }

    @Override
    protected Observable<Movies> createObservableInteractor(Params params) {
        return mMoviesRepository.getPopular(params.mMoviesFilter, params.popularMoviesID);
    }


    public static final class Params {

        private final MoviesFilter mMoviesFilter;
        private final String popularMoviesID;

        public Params(MoviesFilter moviesFilter, String id) {
            this.mMoviesFilter = moviesFilter;
            this.popularMoviesID = id;
        }

        public static Params create(MoviesFilter moviesFilter, String id) {
            return new Params(moviesFilter, id);
        }
    }
}
