package com.springboot.web.app.api.common.glue;

public class BadResponseException extends RuntimeException {
    public BadResponseException(final Throwable t) {
        super(t);
    }
}
