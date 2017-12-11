package com.inc.silence.movapp.utils;

import android.content.Context;
import android.content.res.Configuration;


public class CommonUtils {

    private Context mContext;

    public CommonUtils(Context context) {
        this.mContext = context;
    }

    public boolean isLarge() {
        return (mContext.getResources().getConfiguration().screenLayout
                & Configuration.SCREENLAYOUT_SIZE_MASK) >= Configuration.SCREENLAYOUT_SIZE_LARGE
                && mContext.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE;
    }
}
