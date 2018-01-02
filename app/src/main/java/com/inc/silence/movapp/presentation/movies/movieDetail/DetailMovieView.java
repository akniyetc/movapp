package com.inc.silence.movapp.presentation.movies.movieDetail;

import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.inc.silence.movapp.domain.entity.main.MovieDetail;
import com.inc.silence.movapp.presentation.base.BaseView;

/**
 * Created by silence on 02.01.2018.
 */

public interface DetailMovieView extends BaseView {

    void getDetailMovieDone(MovieDetail movieDetail);
}
