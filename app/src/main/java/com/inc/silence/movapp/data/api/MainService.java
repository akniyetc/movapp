package com.inc.silence.movapp.data.api;


import com.inc.silence.movapp.domain.entity.detail.MovieDetail;
import com.inc.silence.movapp.domain.entity.movies.Movies;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

/**
 * Created by silence on 07.12.2017.
 */

public interface MainService {

    @GET("tv/popular")
    Observable<Response<Movies>> getpopular(@QueryMap Map<String, String> queries);

    @GET("tv/top_rated")
    Observable<Response<Movies>> getTopRated(@QueryMap Map<String, String> queries);

    @GET("tv/{tv_id}")
    Observable<Response<MovieDetail>> getShowData(@Path("tv_id") int tv_id, @QueryMap Map<String, String> queries);
}
