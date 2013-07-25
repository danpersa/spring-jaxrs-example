package com.danix.example.spring.jaxrs.api.domain;

import org.hibernate.validator.constraints.NotBlank;

/**
 * @author  dpersa
 */
public class FortuneCookie {

    @NotBlank
    private String name;
    @NotBlank
    private String content;

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(final String content) {
        this.content = content;
    }
}
