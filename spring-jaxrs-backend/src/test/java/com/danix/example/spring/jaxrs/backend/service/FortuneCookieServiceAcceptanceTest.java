package com.danix.example.spring.jaxrs.backend.service;

import static org.hamcrest.CoreMatchers.is;

import static org.junit.Assert.assertThat;

import org.jboss.resteasy.client.ProxyFactory;
import org.jboss.resteasy.plugins.providers.RegisterBuiltin;
import org.jboss.resteasy.spi.ResteasyProviderFactory;

import org.junit.BeforeClass;
import org.junit.Test;

import com.danix.example.spring.jaxrs.api.domain.FortuneCookie;
import com.danix.example.spring.jaxrs.api.service.FortuneCookieResource;

/**
 * @author  dpersa
 */
public class FortuneCookieServiceAcceptanceTest {

    @BeforeClass
    public static void setupClass() {
        RegisterBuiltin.register(ResteasyProviderFactory.getInstance());
    }

    @Test
    public void testGetFortuneCookiebyId() throws Exception {
        FortuneCookieResource client = ProxyFactory.create(FortuneCookieResource.class,
                "http://localhost:8081/backend/");
        FortuneCookie fortuneCookie = client.getFortuneCookiebyId(14);
        assertThat(fortuneCookie.getName(), is("You are lucky! " + 14));
    }

    @Test
    public void testCreate() throws Exception { }
}
