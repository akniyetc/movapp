package com.inc.silence.movapp.domain.repository.movies;

import com.inc.silence.movapp.data.settings.MoviesFilter;
import com.inc.silence.movapp.domain.entity.main.MovieDetail;
import com.inc.silence.movapp.domain.entity.main.Movies;

import io.reactivex.Observable;

/**
 * Created by silence on 14.12.2017.
 */

public interface MoviesRepository {

    Observable<Movies> getPopular(MoviesFilter moviesFilter, String id);
    Observable<Movies> getTopRated(MoviesFilter moviesFilter, String id);
    Observable<MovieDetail> getMovieDetail(String id, MoviesFilter moviesFilter);
}
