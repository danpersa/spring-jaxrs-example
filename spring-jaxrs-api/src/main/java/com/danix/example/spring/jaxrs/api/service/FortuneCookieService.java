package com.danix.example.spring.jaxrs.api.service;

import com.danix.example.spring.jaxrs.api.domain.FortuneCookie;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author dpersa
 */
@Path("fortune-cookie")
@Produces(MediaType.APPLICATION_JSON)
public interface FortuneCookieService {
  
    @GET
    @Path("/{id}")
    FortuneCookie getFortuneCookiebyId(final @PathParam("id")Integer id);
    
    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    Integer create(final FortuneCookie fortuneCookie);
}
