package com.danix.example.spring.jaxrs.backend.exception.handler;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.springframework.stereotype.Component;

import com.danix.example.spring.jaxrs.api.exception.FortuneCookieNotFoundException;

/**
 * @author  dpersa
 */
@Provider
@Component
public class FortuneCookieNotFoundExceptionHandler implements ExceptionMapper<FortuneCookieNotFoundException> {

    @Override
    public Response toResponse(final FortuneCookieNotFoundException e) {
        StringBuilder response = new StringBuilder("{ 'error': 'Fortune cookie not found' }");
        return Response.serverError().entity(response.toString()).build();
    }
}
