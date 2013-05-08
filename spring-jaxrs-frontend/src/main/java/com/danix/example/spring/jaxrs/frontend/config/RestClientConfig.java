package com.danix.example.spring.jaxrs.frontend.config;

import com.danix.example.spring.jaxrs.api.service.FortuneCookieService;
import org.jboss.resteasy.client.ProxyFactory;
import org.jboss.resteasy.plugins.providers.RegisterBuiltin;
import org.jboss.resteasy.spi.ResteasyProviderFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author dpersa
 */
@Configuration
public class RestClientConfig {

    /**
     * we create a rest service client
     */
    @Bean
    public FortuneCookieService fortuneCookieService() {
        RegisterBuiltin.register(ResteasyProviderFactory.getInstance());
        FortuneCookieService client = ProxyFactory.create(FortuneCookieService.class,
                "http://localhost:8080/api");
        return client;
    }
}
