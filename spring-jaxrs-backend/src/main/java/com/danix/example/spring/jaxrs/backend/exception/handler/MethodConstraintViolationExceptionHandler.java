package com.danix.example.spring.jaxrs.backend.exception.handler;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.hibernate.validator.method.MethodConstraintViolation;
import org.hibernate.validator.method.MethodConstraintViolationException;

import org.springframework.stereotype.Component;

/**
 * @author  dpersa
 */
@Provider
@Component
public class MethodConstraintViolationExceptionHandler implements ExceptionMapper<MethodConstraintViolationException> {
    @Override
    public Response toResponse(final MethodConstraintViolationException validationException) {
        StringBuilder response = new StringBuilder("{ 'error': 'Validation error!!'");
        for (MethodConstraintViolation violation : validationException.getConstraintViolations()) {
            response.append(",");
            response.append("'" + violation.getInvalidValue() + "':");
            response.append("'" + violation.getMessage() + "'");
        }

        response.append("}");

        return Response.serverError().entity(response.toString()).build();
    }
}
