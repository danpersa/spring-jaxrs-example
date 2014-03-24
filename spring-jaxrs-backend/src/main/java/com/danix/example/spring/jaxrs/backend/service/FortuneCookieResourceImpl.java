package com.danix.example.spring.jaxrs.backend.service;

import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.validation.annotation.Validated;

import com.danix.example.spring.jaxrs.api.domain.FortuneCookie;
import com.danix.example.spring.jaxrs.api.exception.FortuneCookieNotFoundException;
import com.danix.example.spring.jaxrs.api.service.FortuneCookieResource;

/**
 * @author  dpersa
 */
@Controller
@Validated
public class FortuneCookieResourceImpl implements FortuneCookieResource {

    private static final int MISSING_FORTUNE_COOKIE = 12;

    @Autowired
    private Validator validator;

    @Override
    public FortuneCookie getFortuneCookiebyId(final Integer id) {
        if (id.equals(MISSING_FORTUNE_COOKIE)) {
            throw FortuneCookieNotFoundException.from(12);
        }

        FortuneCookie fortuneCookie = new FortuneCookie();
        fortuneCookie.setName("You are lucky! " + id);
        fortuneCookie.setContent("Sooooo luuukyyyy!!!");
        return fortuneCookie;
    }

    @Override
    public Integer create(final FortuneCookie fortuneCookie) {
        return Math.abs(new Long(System.currentTimeMillis()).intValue());
    }
}
