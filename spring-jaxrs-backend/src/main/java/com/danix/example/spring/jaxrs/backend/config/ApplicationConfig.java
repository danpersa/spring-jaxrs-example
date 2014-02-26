package com.danix.example.spring.jaxrs.backend.config;

import org.jboss.resteasy.spi.ResteasyDeployment;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;

import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

import com.google.common.collect.ImmutableMap;

/**
 * @author  dpersa
 */
@Configuration
@ComponentScan(basePackages = {"com.danix.example.spring.jaxrs.backend"})
@EnableAspectJAutoProxy
@ImportResource("classpath:springmvc-resteasy.xml")
public class ApplicationConfig {

    @Bean(initMethod = "start", destroyMethod = "stop")
    public ResteasyDeployment resteasyDeployment() {
        ResteasyDeployment resteasyDeployment = new ResteasyDeployment();
        resteasyDeployment.setAsyncJobServiceEnabled(true);
        resteasyDeployment.setMediaTypeMappings(ImmutableMap.of("json", "application/json"));
        return resteasyDeployment;
    }

    @Bean
    public LocalValidatorFactoryBean localValidatorFactoryBean() {
        return new LocalValidatorFactoryBean();
    }

    @Bean
    public MethodValidationPostProcessor methodValidationPostProcessor() {
        return new MethodValidationPostProcessor();
    }
}
