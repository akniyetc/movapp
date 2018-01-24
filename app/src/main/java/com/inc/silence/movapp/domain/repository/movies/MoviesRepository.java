package com.inc.silence.movapp.domain.repository.movies;

import com.inc.silence.movapp.data.settings.MoviesFilter;
import com.inc.silence.movapp.domain.entity.main.MovieDetail;
import com.inc.silence.movapp.domain.entity.main.Movies;
import com.inc.silence.movapp.domain.entity.movies.Movie;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by silence on 14.12.2017.
 */

public interface MoviesRepository {

    Observable<List<Movie>> getMoviesList(MoviesFilter moviesFilter, String id);
    
    Observable<MovieDetail> getMovieDetail(String id, MoviesFilter moviesFilter);
}
