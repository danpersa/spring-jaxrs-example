package com.danix.example.spring.jaxrs.backend.exception.handler;

import static com.google.common.base.Preconditions.checkNotNull;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.springframework.stereotype.Component;

import com.danix.example.spring.jaxrs.api.exception.ApiException;

/**
 * @author  dpersa
 */
@Provider
@Component
public class ApiExceptionHandler implements ExceptionMapper<ApiException> {

    @Override
    public Response toResponse(final ApiException e) {
        return Response.status(e.getStatus()).header(ApiException.CLASS_NAME, e.getClass().getName())
                       .entity(checkNotNull(e)).build();
    }
}
