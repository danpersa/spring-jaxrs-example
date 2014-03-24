package com.danix.example.spring.jaxrs.backend.exception.handler;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.jboss.resteasy.spi.BadRequestException;

import org.springframework.stereotype.Component;

/**
 * @author  dpersa
 */
@Provider
@Component
public class BadRequestExceptionHandler implements ExceptionMapper<BadRequestException> {
    @Override
    public Response toResponse(final BadRequestException e) {
        StringBuilder response = new StringBuilder("{ 'error': 'Bad request!!' }");
        return Response.serverError().type(MediaType.APPLICATION_JSON_TYPE).entity(response.toString()).build();
    }
}
