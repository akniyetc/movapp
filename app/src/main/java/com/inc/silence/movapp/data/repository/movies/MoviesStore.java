package com.inc.silence.movapp.data.repository.movies;

import com.inc.silence.movapp.domain.entity.main.MovieDetail;
import com.inc.silence.movapp.domain.entity.main.Movies;

import java.util.Map;

import io.reactivex.Observable;

/**
 * Created by silence on 11.12.2017.
 */

public interface MoviesStore {
    Observable<Movies> getPopular(Map<String, String> queries, String id);

    Observable<Movies> getTopRated(Map<String, String> queries, String id);

    Observable<MovieDetail> getDetailMovie(String movieId, Map<String, String> queries);

    void savePopularMovies(Movies movies, boolean clear);
    void saveTopRated(Movies movies, boolean clear);
    void saveMovieDetail(MovieDetail movieDetail);
}
