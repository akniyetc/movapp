package com.inc.silence.movapp.data.api;


import com.inc.silence.movapp.domain.entity.main.MovieDetail;
import com.inc.silence.movapp.domain.entity.main.Movies;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

/**
 * Created by silence on 07.12.2017.
 */

public interface MainService {

    @GET("tv/popular")
    Observable<Movies> getPopular(@QueryMap Map<String, String> queries);

    @GET("tv/top_rated")
    Observable<Movies> getTopRated(@QueryMap Map<String, String> queries);

    @GET("tv/{tv_id}")
    Observable<MovieDetail> getDetailMovie(@Path("tv_id") String id, @QueryMap Map<String, String> queries);
}
