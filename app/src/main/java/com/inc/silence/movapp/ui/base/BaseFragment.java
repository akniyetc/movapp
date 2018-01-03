package com.inc.silence.movapp.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.inc.silence.movapp.app.App;
import com.inc.silence.movapp.di.components.AppComponent;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by silence on 30.12.2017.
 */

public abstract class BaseFragment extends Fragment {

    private Unbinder mUnbinder;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupComponent(App.getAppComponent());
        FirebaseAnalytics analytics = FirebaseAnalytics.getInstance(getContext());
        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, getClass().getName());
        analytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setHasOptionsMenu(true);
        mUnbinder = ButterKnife.bind(this, view);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mUnbinder != null) {
            mUnbinder.unbind();
        }
    }

    public void setSubtitle(String text) {
        BaseActivity baseActivity = (BaseActivity) getActivity();
        if (baseActivity.getSupportActionBar() != null) {
            baseActivity.getSupportActionBar().setSubtitle(text);
        }
    }

    public abstract void setupComponent(AppComponent appComponent);
}
