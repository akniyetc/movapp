package com.inc.silence.movapp.domain.interactor.base;

import io.reactivex.observers.DisposableObserver;

/**
 * Created by silence on 14.12.2017.
 */

public class InteractorObserver<T> extends DisposableObserver<T> {
    @Override
    public void onNext(T t) {

    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onComplete() {

    }
}
