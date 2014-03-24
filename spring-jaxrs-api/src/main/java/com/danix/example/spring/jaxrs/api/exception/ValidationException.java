package com.danix.example.spring.jaxrs.api.exception;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.List;

import javax.annotation.Nonnull;

import javax.ws.rs.core.Response;

import com.google.common.collect.ImmutableList;

/**
 * @author  dpersa
 */
public class ValidationException extends ApiException {

    final List<ValidationMessage> validationMessages;

    private ValidationException() {
        super(Response.Status.BAD_REQUEST);
        this.validationMessages = ImmutableList.of();
    }

    protected ValidationException(@Nonnull final ValidationMessages validationMessages) {
        super(Response.Status.BAD_REQUEST);
        this.validationMessages = checkNotNull(validationMessages.getValidationMessages());
    }

    public static ValidationException from(@Nonnull final ValidationMessages validationMessages) {
        return new ValidationException(validationMessages);
    }

    @Nonnull
    public List<ValidationMessage> getValidationMessages() {
        return validationMessages;
    }
}
