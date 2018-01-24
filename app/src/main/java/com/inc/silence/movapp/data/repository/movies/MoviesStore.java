package com.inc.silence.movapp.data.repository.movies;

import com.inc.silence.movapp.domain.entity.main.MovieDetail;
import com.inc.silence.movapp.domain.entity.main.Movies;
import com.inc.silence.movapp.domain.entity.movies.Movie;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;

/**
 * Created by silence on 11.12.2017.
 */

public interface MoviesStore {
    
    Observable<List<Movie>> getMovies(Map<String, String> queries, String id);
    
    void saveMovies(List<Movie> movieList, boolean clear, String id);
    
    Observable<MovieDetail> getDetailMovie(String movieId, Map<String, String> queries);
    
    void saveMovieDetail(MovieDetail movieDetail);
}
