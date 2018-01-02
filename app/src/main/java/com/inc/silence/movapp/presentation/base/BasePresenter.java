package com.inc.silence.movapp.presentation.base;

import com.arellomobile.mvp.MvpPresenter;

/**
 * Created by silence on 29.12.2017.
 */

public abstract class BasePresenter<V extends BaseView> {

    private V mView;

    public void attachView(V view) {
        mView = view;
        onViewAttached();
    }

    protected V getView() {
        return mView;
    }

    public void detachView() {
    }

    public abstract void onViewAttached();
}
