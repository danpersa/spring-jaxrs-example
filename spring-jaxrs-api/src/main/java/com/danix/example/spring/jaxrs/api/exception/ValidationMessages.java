package com.danix.example.spring.jaxrs.api.exception;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Nonnull;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonUnwrapped;

import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;

/**
 * @author  dpersa
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ValidationMessages implements Iterable<ValidationMessage> {

    private final List<ValidationMessage> validationMessages;

    public static ValidationMessages EMPTY = new ValidationMessages();

    public static Builder builder() {
        return new Builder();
    }

    public Builder asBuilder() {
        return new Builder(this.validationMessages);
    }

    public static ValidationMessages empty() {
        return EMPTY;
    }

    @Override
    public Iterator<ValidationMessage> iterator() {
        return validationMessages.iterator();
    }

    public static class Builder {
        private final List<ValidationMessage> validationMessages;

        private Builder() {
            this.validationMessages = new ArrayList<>();
        }

        private Builder(final List<ValidationMessage> validationMessages) {
            this.validationMessages = new ArrayList<>(validationMessages);
        }

        @Nonnull
        public Builder withMessage(@Nonnull final ValidationMessage validationMessage) {
            validationMessages.add(checkNotNull(validationMessage));
            return this;
        }

        @Nonnull
        public Builder withMessages(@Nonnull final ValidationMessages validationMessages) {
            this.validationMessages.addAll(checkNotNull(validationMessages.getValidationMessages()));
            return this;
        }

        public boolean isEmpty() {
            return validationMessages.isEmpty();
        }

        @Nonnull
        public ValidationMessages build() {
            return new ValidationMessages(this);
        }
    }

    private ValidationMessages() {
        validationMessages = ImmutableList.of();
    }

    private ValidationMessages(@Nonnull final Builder builder) {
        checkNotNull(builder, "Builder (p1) must not be null");
        validationMessages = ImmutableList.copyOf(builder.validationMessages);
    }

    @JsonIgnore
    public boolean isEmpty() {
        return validationMessages.isEmpty();
    }

    @JsonProperty
    @JsonUnwrapped
    public List<ValidationMessage> getValidationMessages() {
        return validationMessages;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this).add("validationMessages", validationMessages).toString();
    }
}
