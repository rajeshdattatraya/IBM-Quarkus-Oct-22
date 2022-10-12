package org.acme.resource;

import org.acme.services.HeroService;
import org.acme.services.HeroineService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/api/movies")
public class MovieResource {
    @Inject
    HeroService heroService;
    @Inject
    HeroineService heroineService;

    @GET
    @Path("/actors")
    public Response getActorDetails() {
        String actors = heroService.getHero() + heroineService.getHeroine();
        return Response.ok().entity(actors).build();
    }

}
