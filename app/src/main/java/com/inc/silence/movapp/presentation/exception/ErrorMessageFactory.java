package com.inc.silence.movapp.presentation.exception;

import android.content.Context;

import com.inc.silence.movapp.data.exception.JsonParseException;
import com.inc.silence.movapp.data.exception.TimeoutException;
import com.inc.silence.movapp.R;
import com.inc.silence.movapp.data.exception.NetworkConnectionException;


public class ErrorMessageFactory {

    public static String create(Context context, Throwable exception) {
        if (exception instanceof NetworkConnectionException) {
            return context.getString(R.string.no_connection_exception_error);
        } else if (exception instanceof JsonParseException) {
            return context.getString(R.string.json_parse_exception_error);
        } else if (exception instanceof TimeoutException) {
            return context.getString(R.string.timeout_error_exception_error);
        }
        return context.getString(R.string.default_exception_error);
    }

}
