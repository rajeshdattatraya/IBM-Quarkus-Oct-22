package org.acme;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/api/products")
public class ProductResource {

    @GET
    public String list() {
        return "products";
    }
    /**
     * //How to read Id inside Api -  @PathParam
     * Generally clients sends strings , RESTeasy converts automatically into Integer
     * Even we can map other objects
     */
    @GET
    @Path("/{id}")
    public String listById(@PathParam("id") Integer id) {
        return "Products By Id" + id;
    }
    @Path("/category/{category}")
    @GET
    public String listByCategory(@PathParam("category") Category category) {
        return "Category" + category ;
    }
    //rating
    @GET
    @Path("/{name}/{rating}")
    public String getRating(@PathParam("name") String name, @PathParam("rating") String rating) {
        return name + " " + rating;
    }
}
