package com.nowakowski.dockerdemo.exceptions;

@SuppressWarnings("unused")
public class ScreeningNotFoundException extends RuntimeException {
    public ScreeningNotFoundException() {
        super();
    }

    public ScreeningNotFoundException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public ScreeningNotFoundException(final String message) {
        super(message);
    }

    public ScreeningNotFoundException(final Throwable cause) {
        super(cause);
    }
}
