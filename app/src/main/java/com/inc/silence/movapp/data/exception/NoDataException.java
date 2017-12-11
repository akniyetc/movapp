package com.inc.silence.movapp.data.exception;



public class NoDataException extends Exception {

    public NoDataException() {
    }

    public NoDataException(String message) {
        super(message);
    }

    public NoDataException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoDataException(Throwable cause) {
        super(cause);
    }
}
