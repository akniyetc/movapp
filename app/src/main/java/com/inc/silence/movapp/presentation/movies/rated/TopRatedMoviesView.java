package com.inc.silence.movapp.presentation.movies.rated;

import com.inc.silence.movapp.domain.entity.movies.Movie;
import com.inc.silence.movapp.presentation.base.BaseView;

import java.util.List;

/**
 * Created by silence on 05.01.2018.
 */

public interface TopRatedMoviesView extends BaseView {

    void getTopRatedMoviesDone(List<Movie> movies);

    void setSubtitle(String title);
}
