package com.danix.example.spring.jaxrs.backend.exception.handler;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.springframework.stereotype.Component;

/**
 * @author  dpersa
 */
@Provider
@Component
public class MethodConstraintViolationExceptionHandler implements ExceptionMapper<ConstraintViolationException> {

    @Override
    public Response toResponse(final ConstraintViolationException validationException) {
        StringBuilder response = new StringBuilder("{ 'error': 'Validation error!!'");
        for (ConstraintViolation violation : validationException.getConstraintViolations()) {
            response.append(",");
            response.append("'" + violation.getInvalidValue() + "':");
            response.append("'" + violation.getMessage() + "'");
        }

        response.append("}");

        return Response.serverError().entity(response.toString()).build();
    }
}
