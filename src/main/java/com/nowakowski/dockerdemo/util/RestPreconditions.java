package com.nowakowski.dockerdemo.util;

import com.nowakowski.dockerdemo.exceptions.ScreeningNotFoundException;

public class RestPreconditions {

    private RestPreconditions() {
        throw new UnsupportedOperationException();
    }

    public static <T> T checkFound(T resource) {
        if (resource == null) {
            throw new ScreeningNotFoundException();
        }
        return resource;
    }
}
