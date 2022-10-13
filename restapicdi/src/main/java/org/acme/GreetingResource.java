package org.acme;

import org.acme.services.GreeterService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/greet")
public class GreetingResource {

    @Inject
    GreeterService greeterService;

    @GET
    public String sayGreet() {
        return greeterService.sayGreet();
    }

}