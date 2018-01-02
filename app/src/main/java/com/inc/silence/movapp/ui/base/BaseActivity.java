package com.inc.silence.movapp.ui.base;

import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.ViewGroup;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.inc.silence.movapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by silence on 30.12.2017.
 */

public class BaseActivity extends MvpAppCompatActivity {

    @BindView(R.id.toolbar)
    protected Toolbar mToolbar;

    private Unbinder mUnbinder;


    protected void setCustomContentView(@LayoutRes int resId) {
        ViewGroup container = findViewById(android.R.id.content);
        getLayoutInflater().inflate(resId, container);
        mUnbinder = ButterKnife.bind(this, container);
    }

    public void initToolbar(Toolbar toolbar) {
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            final ActionBar supportActionBar = getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.setHomeButtonEnabled(false);
                supportActionBar.setDisplayHomeAsUpEnabled(false);
            }
        }
    }

    public void hideToolbar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
    }

    public void setBackEnabled() {
        final ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setHomeButtonEnabled(true);
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    public void changeFragment(Fragment fragment, @IdRes int containerId) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(containerId, fragment)
                .commitNow();
    }

    public void removeFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .remove(fragment)
                .commitNow();
    }

    public Fragment getCurrentFragment(int id) {
        return getSupportFragmentManager()
                .findFragmentById(id);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mUnbinder != null) {
            mUnbinder.unbind();
        }
    }
}
