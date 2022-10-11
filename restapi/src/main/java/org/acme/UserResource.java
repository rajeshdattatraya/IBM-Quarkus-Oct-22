package org.acme;

import javax.ws.rs.*;

//main path
@Path("/api/users")
public class UserResource {

    //api
    @GET
    public String getUsers(){
        return "Users";
    }
    @GET
    @Path("/something")
    public String something(){
        return "Something";
    }
    @POST
    public String saveUser(){
        return "Saved";
    }

    //regular expressions:  mini language for pattern matching
    //syntax :"{variable-Name[":" regularexpression]}"

    //api/users/foo/bar
    //api/users/me/you/bar
    @Path("{foo:.*}/bar")
    @GET
    public String getInfo(){
        return "Info";
    }
    //api/users/foo/stuff
    //api/users/bar/stuff
    @Path("/{variable}/stuff")
    @GET
    public String getInformation(){
        return  "Information";
    }
    @PUT
    public String updateUser(){
        return "Updated";
    }
    @DELETE
    public String removeUser(){
        return  "remove";
    }
}
