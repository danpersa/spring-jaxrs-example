package com.danix.example.spring.jaxrs.api.domain;

/**
 *
 * @author dpersa
 */
public class FortuneCookie {

    private String name;
    private String content;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
