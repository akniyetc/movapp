package com.inc.silence.movapp.presentation.base;

import android.content.Context;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

/**
 * Created by silence on 29.12.2017.
 */

public interface BaseView {

    Context getContext();

    void showLoadingProgress();

    void hideLoadingProgress();

    void showErrorMessage(String error);
}
