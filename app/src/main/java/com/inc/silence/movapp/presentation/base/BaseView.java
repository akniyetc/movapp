package com.inc.silence.movapp.presentation.base;

import android.content.Context;

import com.arellomobile.mvp.MvpView;

/**
 * Created by silence on 29.12.2017.
 */

public interface BaseView extends MvpView{

    Context getContext();

    void showLoadingProgress();

    void hideLoadingProgress();

    void showErrorMessage(String error);
}
