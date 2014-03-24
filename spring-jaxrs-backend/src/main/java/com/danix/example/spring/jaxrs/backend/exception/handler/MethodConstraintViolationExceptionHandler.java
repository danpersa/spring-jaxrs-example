package com.danix.example.spring.jaxrs.backend.exception.handler;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.springframework.stereotype.Component;

import com.danix.example.spring.jaxrs.api.exception.ValidationException;
import com.danix.example.spring.jaxrs.api.exception.ValidationMessage;
import com.danix.example.spring.jaxrs.api.exception.ValidationMessages;

/**
 * @author  dpersa
 */
@Provider
@Component
public class MethodConstraintViolationExceptionHandler implements ExceptionMapper<ConstraintViolationException> {

    @Override
    public Response toResponse(final ConstraintViolationException validationException) {
        ValidationMessages.Builder builder = ValidationMessages.builder();
        for (ConstraintViolation violation : validationException.getConstraintViolations()) {
            builder.withMessage(ValidationMessage.create(violation.getPropertyPath().toString(),
                    violation.getMessage()));
        }

        ValidationMessages validationMessages = builder.build();

        return Response.status(Response.Status.BAD_REQUEST).type(MediaType.APPLICATION_JSON_TYPE)
                       .entity(ValidationException.from(validationMessages)).build();
    }
}
