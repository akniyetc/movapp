package com.inc.silence.movapp.ui.detail;

import android.content.Context;
import android.content.Intent;

import com.inc.silence.movapp.ui.base.BaseActivity;

/**
 * Created by silence on 01.01.2018.
 */

public class MovieDetailActivity extends BaseActivity {

    public static final String EXTRA_ID = "extra_id";

    public static void startActivity(Context context, String id) {
        Intent intent = new Intent(context, MovieDetailActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra(EXTRA_ID, id);
        context.startActivity(intent);
    }
}
