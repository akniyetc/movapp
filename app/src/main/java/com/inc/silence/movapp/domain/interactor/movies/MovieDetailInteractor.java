package com.inc.silence.movapp.domain.interactor.movies;

import com.inc.silence.movapp.data.settings.MoviesFilter;
import com.inc.silence.movapp.domain.entity.main.MovieDetail;
import com.inc.silence.movapp.domain.interactor.base.Interactor;
import com.inc.silence.movapp.domain.repository.movies.MoviesRepository;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by silence on 15.12.2017.
 */

public class MovieDetailInteractor extends Interactor<MovieDetail, MovieDetailInteractor.Params> {

    private MoviesRepository mMoviesRepository;

    @Inject
    public MovieDetailInteractor(MoviesRepository moviesRepository) {
        mMoviesRepository = moviesRepository;
    }

    @Override
    protected Observable<MovieDetail> createObservableInteractor(Params params) {
        return mMoviesRepository.getMovieDetail(params.movieDetailID, params.mMoviesFilter);
    }

    public static final class Params {
        private final MoviesFilter mMoviesFilter;
        private final String movieDetailID;

        public Params(MoviesFilter moviesFilter, String movieDetailID) {
            mMoviesFilter = moviesFilter;
            this.movieDetailID = movieDetailID;
        }

        public static Params create(MoviesFilter moviesFilter, String movieDetailID) {
            return new Params(moviesFilter, movieDetailID);
        }
    }
}
