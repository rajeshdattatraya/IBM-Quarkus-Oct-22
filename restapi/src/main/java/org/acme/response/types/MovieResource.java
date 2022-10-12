package org.acme.response.types;

import io.quarkus.arc.lookup.LookupIfProperty;
import org.acme.response.types.entity.Movie;

import javax.ws.rs.*;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.List;

@Path("/api/movies")
public class MovieResource {
    //String
    @GET
    @Path("/list")
    @Produces(MediaType.TEXT_PLAIN) // the type of data format
    public String getMovies() {
        return "Movies";
    }

    //void
    @GET
    @Path("/show")
    //No Content is returned -204- HTTP
    public void showBook() {
        System.out.println("show Movie");
    }

    //Object
    @GET
    @Path("/mymovie")
    @Produces(MediaType.APPLICATION_JSON)
    public Movie myMovie() {
        //return Movie
        return new Movie("894343434", "Matrix", "John");
    }

    @GET
    @Path("/mymovielist")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Movie> myMovieList() {
        //return Movie
        return List.of(new Movie("894343434", "Matrix", "John"), new Movie("894343434", "Matrix", "John"));
    }
    //How to send Response Object

    @GET
    @Path("/mymovieresponse")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response myMovieResponse() {
        Movie movie = new Movie("894343434", "Matrix", "John");
        return Response
                .status(200)
                .entity(movie)
                .header("studio", "Marvels")
                .build();
    }

    //Get payload from the client
    @POST
    @Path("/save")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response save(Movie movie) {
        //persist this data into database
        System.out.println(movie);


        //UriBuilder.fromResource(BookResource.class).build() this code will inject Location header
        //Location : http://localhost:8080/api/books
        //created - 201 /save
        return Response
                .created(UriBuilder.fromResource(MovieResource.class)
                        .build())
                .build();
    }

    @GET
    @Path("/hero/{name}")
    public Response getHero(@PathParam("name") String name) {
        if (name.equals("myhero")) {
            //throw new WebApplicationException(Response.Status.NOT_FOUND);
            return Response.ok().entity("Hero").build();
        }
        throw new WebApplicationException();
    }


}
