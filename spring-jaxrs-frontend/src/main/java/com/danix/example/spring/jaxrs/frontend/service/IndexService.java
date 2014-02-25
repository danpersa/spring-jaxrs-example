package com.danix.example.spring.jaxrs.frontend.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.danix.example.spring.jaxrs.api.domain.FortuneCookie;
import com.danix.example.spring.jaxrs.api.service.FortuneCookieService;

/**
 * @author  dpersa
 */
@Service("indexService")
public class IndexService {

    /**
     * We inject the rest service into a regular service.
     */
    @Autowired
    FortuneCookieService fortuneCookieService;

    /**
     * This will make a GET to the backend service.
     */
    public FortuneCookie getRandomFortuneCookie() {
        return fortuneCookieService.getFortuneCookiebyId(11);
    }

    /**
     * This will make a POST to the backend service.
     */
    public Integer createFortuneCookie() {
        FortuneCookie fc = new FortuneCookie();
        fc.setName("name");
        fc.setContent("content");
        return fortuneCookieService.create(fc);
    }

}
