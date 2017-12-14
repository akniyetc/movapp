package com.inc.silence.movapp.data.repository.movies;

import com.inc.silence.movapp.data.api.MainService;
import com.inc.silence.movapp.di.scopes.ApplicationScope;
import com.inc.silence.movapp.domain.entity.main.MovieDetail;
import com.inc.silence.movapp.domain.entity.main.Movies;
import com.inc.silence.movapp.utils.Constants;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import io.reactivex.Observable;

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
    public Observable<Movies> getPopular(Map<String, String> queries, String id) {
        return mMainService.getPopular(queries);
    }

    @Override
    public Observable<Movies> getTopRated(Map<String, String> queries, String id) {
        return mMainService.getTopRated(queries);
    }

    @Override
    public Observable<MovieDetail> getDetailMovie(String movieId, Map<String, String> queries) {
        return mMainService.getDetailMovie(movieId, queries);
    }

    @Override
    public void savePopularMovies(Movies movies, boolean clear) {
        throw new UnsupportedOperationException("You can not save or remove data on cloud");
    }

    @Override
    public void saveTopRated(Movies movies, boolean clear) {
        throw new UnsupportedOperationException("You can not save or remove data on cloud");
    }

    @Override
    public void saveMovieDetail(MovieDetail movieDetail) {
        throw new UnsupportedOperationException("You can not save or remove data on cloud");
    }
}
