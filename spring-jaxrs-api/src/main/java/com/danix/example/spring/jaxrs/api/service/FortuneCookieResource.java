package com.danix.example.spring.jaxrs.api.service;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.danix.example.spring.jaxrs.api.domain.FortuneCookie;

/**
 * @author  dpersa
 */
@Path("fortune-cookie")
@Produces(MediaType.APPLICATION_JSON)
public interface FortuneCookieResource {

    @GET
    @Path("/{id}")
    FortuneCookie getFortuneCookiebyId(@NotNull
            @Max(100)
            @PathParam("id")
            final Integer id);

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    Integer create(@Valid final FortuneCookie fortuneCookie);
}
