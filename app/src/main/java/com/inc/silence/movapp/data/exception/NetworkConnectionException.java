package com.inc.silence.movapp.data.exception;

/**
 * Created by neox on 12/9/17.
 */

public class NetworkConnectionException extends Exception {

    public NetworkConnectionException() {
    }

    public NetworkConnectionException(String message) {
        super(message);
    }

    public NetworkConnectionException(String message, Throwable cause) {
        super(message, cause);
    }

    public NetworkConnectionException(Throwable cause) {
        super(cause);
    }
}
