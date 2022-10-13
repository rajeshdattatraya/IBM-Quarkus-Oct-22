package org.acme.resource;

import org.acme.services.BookService;
import org.acme.services.interceptors.LogEvent;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/api/books")
public class BookResource {

    @Inject
    BookService bookService;


    @GET
    @LogEvent
    public Response createBook() {
        return Response.ok().entity(bookService.createBook()).build();
    }

    @GET
    @LogEvent
    @Path("/details")
    public Response getBook() {
        return Response.ok().entity("Books Details").build();
    }

}
