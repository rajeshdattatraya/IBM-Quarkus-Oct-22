package org.acme.resource;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/producers")
public class ProducerResource {

    @Inject
    double price;

    @Inject
    List<String> topics;

    @GET
    @Path("/price")
    public Response getPrice() {
        return Response.ok().entity(price).build();
    }

    @GET
    @Path("/topics")
    public Response getTopics() {
        return Response.ok().entity(topics).build();
    }


}
