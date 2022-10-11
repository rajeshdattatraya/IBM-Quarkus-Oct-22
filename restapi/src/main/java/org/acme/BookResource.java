package org.acme;

import javax.ws.rs.*;

@Path("/library")
public class BookResource {
    //http://localhost:8080/library/books;name=QuarkusInACtion;author=Bill
    @GET
    @Path("/books")
    public String getBookDetails(@MatrixParam("name") String name, @MatrixParam("author") String title) {
        return name + " " + title;
    }

    //http://localhost:8080/library/books?copies=30&price=1200
    //no
    @Path("/query")
    @GET
    public String getBooks(@QueryParam("copies") int copies, @QueryParam("price") double price) {
        return copies + "Books " + " " + price;
    }

    //localhost:8080/library/filter => output Quarkus
   //localhost:8080/api/myproducts/filter?category=vertx => output vertx
    @GET
    @Path("/filter")
    public String filterProductByCategoriees(@QueryParam("category") @DefaultValue("Quarkus") String category) {
        return category;
    }
}
