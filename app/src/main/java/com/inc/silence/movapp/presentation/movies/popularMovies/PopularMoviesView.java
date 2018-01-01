package com.inc.silence.movapp.presentation.movies.popularMovies;


import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.inc.silence.movapp.domain.entity.movies.Movie;
import com.inc.silence.movapp.presentation.base.BaseView;

import java.util.List;

/**
 * Created by silence on 30.12.2017.
 */
@StateStrategyType(AddToEndSingleStrategy.class)
public interface PopularMoviesView extends BaseView {

    void getPopularMoviesDone(List<Movie> movies);

    void setSubtitle(String title);
}
