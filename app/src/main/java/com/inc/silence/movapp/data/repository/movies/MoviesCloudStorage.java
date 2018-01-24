package com.inc.silence.movapp.data.repository.movies;

import com.inc.silence.movapp.data.api.MainService;
import com.inc.silence.movapp.di.scopes.ApplicationScope;
import com.inc.silence.movapp.domain.entity.main.MovieDetail;
import com.inc.silence.movapp.domain.entity.main.Movies;
import com.inc.silence.movapp.domain.entity.movies.Movie;
import com.inc.silence.movapp.ui.main.MoviesActivity;
import com.inc.silence.movapp.ui.main.MoviesListFragment;
import com.inc.silence.movapp.utils.Constants;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

/**
 * Created by silence on 11.12.2017.
 */
@ApplicationScope
public class MoviesCloudStorage implements MoviesStore {

    private MainService mMainService;

    @Inject
    public MoviesCloudStorage(MainService mainService) {
        mMainService = mainService;
    }
    
    @Override
    public Observable<List<Movie>> getMovies(final Map<String, String> queries, final String id) {
        if (id.equals(MoviesActivity.POPULAR)) {
            return mMainService
                .getPopular(queries)
                .map(Movies::getResults);
        } else if (id.equals(MoviesActivity.TOPRATED)) {
            return mMainService
                .getTopRated(queries)
                .map(Movies::getResults);
        }
        throw new UnsupportedOperationException();
    }
    
    @Override
    public void saveMovies(final List<Movie> movieList, final boolean clear, final String id) {
    
    }
    
    @Override
    public Observable<MovieDetail> getDetailMovie(String movieId, Map<String, String> queries) {
        return mMainService.getDetailMovie(movieId, queries);
    }
    

    @Override
    public void saveMovieDetail(MovieDetail movieDetail) {
        throw new UnsupportedOperationException("You can not save or remove data on cloud");
    }
}
