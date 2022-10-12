package org.acme.resource;

import org.acme.services.WelcomeService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/api/welcome")
public class WelcomeResource {
    //  private WelcomeService welcomeService = new WelcomeService();
    //Dependency injection
    //Field Injection
//    @Inject
//    private WelcomeService welcomeService;
    //Setter Injection
//    private  WelcomeService welcomeService;
//    @Inject
//    public void setWelcomeService(WelcomeService welcomeService) {
//        this.welcomeService = welcomeService;
//    }
    //private WelcomeService welcomeService;
    WelcomeService welcomeService;

    public WelcomeResource() {
    }

    @Inject
    public WelcomeResource(WelcomeService welcomeService) {
        this.welcomeService = welcomeService;
    }

    @GET
    public Response sayWelcome() {
        return Response.ok().entity(welcomeService.sayWelcome()).build();
    }
}
