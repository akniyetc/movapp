package com.inc.silence.movapp.presentation.movies.popular;


import com.inc.silence.movapp.domain.entity.movies.Movie;
import com.inc.silence.movapp.presentation.base.BaseView;

import java.util.List;

/**
 * Created by silence on 30.12.2017.
 */

public interface MoviesListView extends BaseView {

    void getPopularMoviesDone(List<Movie> movies);

    void getTopRatedMoviesDone(List<Movie> movies);

    void setSubtitle(String title);

    void showDetail(String movieId);
}
