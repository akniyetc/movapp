package com.inc.silence.movapp.ui.detail;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.inc.silence.movapp.R;
import com.inc.silence.movapp.app.App;
import com.inc.silence.movapp.ui.base.BaseActivity;
import com.inc.silence.movapp.utils.CommonUtils;

import javax.inject.Inject;

/**
 * Created by silence on 01.01.2018.
 */

public class MovieDetailActivity extends BaseActivity {

    public static final String EXTRA_ID = "extra_id";

    @Inject
    CommonUtils mCommonUtils;

    public static void startActivity(Context context, String id) {
        Intent intent = new Intent(context, MovieDetailActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra(EXTRA_ID, id);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        App.getAppComponent().inject(this);
        String id = getIntent().getStringExtra(EXTRA_ID);
        setCustomContentView(R.layout.activity_base);
        initToolbar(mToolbar);
        setTitle(getString(R.string.detailing));
        setBackEnabled();
        if (mCommonUtils.isLarge()) {
            finish();
            return;
        }
        Fragment fragment = getCurrentFragment(R.id.container);
        if (fragment == null) {
            fragment = MovieDetailFragment.newInstance(id);
        }
        changeFragment(fragment, R.id.container);
    }
}
