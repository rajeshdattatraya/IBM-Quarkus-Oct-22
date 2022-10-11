package org.acme.response.types;

import io.quarkus.arc.lookup.LookupIfProperty;
import org.acme.response.types.entity.Movie;

import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
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
}
