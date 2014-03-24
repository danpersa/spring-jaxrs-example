package com.danix.example.spring.jaxrs.api.exception;

import static com.google.common.base.Preconditions.checkNotNull;

import javax.annotation.Nonnull;

import javax.ws.rs.core.Response;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * @author  dpersa
 */
@JsonIgnoreProperties(ignoreUnknown = true, value = {"suppressed"})
public class ApiException extends RuntimeException {
    public static final String CLASS_NAME = "className";

    private final Response.Status status;

    private ApiException() {
        status = Response.Status.BAD_REQUEST;
    }

    protected ApiException(@Nonnull final Response.Status status) {
        this.status = checkNotNull(status);
    }

    public static ApiException from(@Nonnull final Response.Status status) {
        return new ApiException(status);
    }

    @Nonnull
    public Response.Status getStatus() {
        return status;
    }

    @JsonIgnore
    @Nonnull
    public String getMessage() {
        return super.getMessage();
    }

    @JsonIgnore
    @Override
    public String getLocalizedMessage() {
        return super.getLocalizedMessage();
    }

    @JsonIgnore
    @Override
    public synchronized Throwable getCause() {
        return super.getCause();
    }

    @JsonIgnore
    @Override
    public StackTraceElement[] getStackTrace() {
        return super.getStackTrace();
    }
}
