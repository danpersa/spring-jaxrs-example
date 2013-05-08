package com.danix.example.spring.jaxrs.backend.service;

import com.danix.example.spring.jaxrs.api.domain.FortuneCookie;
import com.danix.example.spring.jaxrs.api.service.FortuneCookieService;
import javax.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author dpersa
 */
@Service
public class FortuneCookieServiceImpl implements FortuneCookieService {

    @Autowired
    private Validator validator;

    @Override
    public FortuneCookie getFortuneCookiebyId(Integer id) {
        FortuneCookie fortuneCookie = new FortuneCookie();
        fortuneCookie.setName("You are lucky! " + System.currentTimeMillis());
        fortuneCookie.setContent("Sooooo luuukyyyy!!!");
        return fortuneCookie;
    }

    @Override
    public Integer create(FortuneCookie fortuneCookie) {
        return Math.abs(new Long(System.currentTimeMillis()).intValue());
    }
}
