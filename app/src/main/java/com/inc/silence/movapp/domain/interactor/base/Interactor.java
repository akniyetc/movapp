package com.inc.silence.movapp.domain.interactor.base;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by silence on 14.12.2017.
 */

public abstract class Interactor<T, Params> {

    private CompositeDisposable mCompositeDisposable;

    public void execute(InteractorObserver<T> interactorObserver, Params params) {
        if(interactorObserver == null) {
            throw new IllegalArgumentException("disposableObserver must not be null");
        }
        if (mCompositeDisposable == null || mCompositeDisposable.isDisposed()) {
            mCompositeDisposable = new CompositeDisposable();
        }
        final Observable<T> observable = this
                .createObservableInteractor(params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread(), true);
        DisposableObserver observer = observable.subscribeWith(interactorObserver);
        mCompositeDisposable.add(observer);
    }

    public void dispose() {
        if (mCompositeDisposable != null && !mCompositeDisposable.isDisposed()) {
            mCompositeDisposable.dispose();
        }
    }

    protected abstract Observable<T> createObservableInteractor(Params params);
}
