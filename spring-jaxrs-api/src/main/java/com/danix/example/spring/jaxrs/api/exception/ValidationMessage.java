package com.danix.example.spring.jaxrs.api.exception;

import static com.google.common.base.Preconditions.checkNotNull;

import javax.annotation.Nonnull;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import com.google.common.base.Objects;

/**
 * @author  dpersa
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ValidationMessage {

    private final String path;

    private final String message;

    private ValidationMessage(@Nonnull final String field, @Nonnull final String message) {
        this.path = checkNotNull(field);
        this.message = checkNotNull(message);
    }

    public static ValidationMessage create(@Nonnull final String field, @Nonnull final String message) {
        return new ValidationMessage(field, message);
    }

    @Nonnull
    public String getPath() {
        return path;
    }

    @Nonnull
    public String getMessage() {
        return message;
    }

    @Override
    public boolean equals(final Object obj) {
        if (!(obj instanceof ValidationMessage)) {
            return false;
        }

        @Nonnull
        ValidationMessage other = (ValidationMessage) obj;
        return Objects.equal(this.path, other.path) && Objects.equal(this.message, other.message);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.path, this.message);
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this).add("path", path).add("message", message).toString();
    }
}
