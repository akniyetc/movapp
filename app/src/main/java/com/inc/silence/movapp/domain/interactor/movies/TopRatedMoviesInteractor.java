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

public class TopRatedMoviesInteractor extends Interactor<Movies, TopRatedMoviesInteractor.Params> {

    private MoviesRepository mMoviesRepository;

    @Inject
    public TopRatedMoviesInteractor(MoviesRepository moviesRepository) {
        mMoviesRepository = moviesRepository;
    }

    @Override
    protected Observable<Movies> createObservableInteractor(Params params) {
        return mMoviesRepository.getTopRated(params.mMoviesFilter, params.topRatedMoviesID);
    }

    public static final class Params {

        private final MoviesFilter mMoviesFilter;
        private final String topRatedMoviesID;

        public Params(MoviesFilter moviesFilter, String id) {
            mMoviesFilter = moviesFilter;
            this.topRatedMoviesID = id;
        }

        public static Params create(MoviesFilter moviesFilter, String topRatedMoviesID) {
            return new Params(moviesFilter, topRatedMoviesID);
        }
    }
}
