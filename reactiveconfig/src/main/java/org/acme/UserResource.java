package org.acme;


import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.List;

@Path("/api/users")
public class UserResource {

    //This is running in worker pool thread : Dedicated thread
    @GET
    public String getUserInfo() {
        System.out.println("User Info End Point => " + Thread.currentThread().getName());
        return "User";
    }
    //Event loop: how to schedule this request in non-blocking mode

    @GET
    @Path("/reactive")
    public Uni<String> getUserReactiveInfo(){
        System.out.println("Reactive End point - Uni => " + Thread.currentThread().getName());
        return Uni.createFrom().item("Hello reactive");
    }

    @GET
    @Path("/reactive/multi")
    public Multi<List<String>> getUsers(){
        System.out.println("Reactive End point - Multi  => " + Thread.currentThread().getName());

        return Multi.createFrom().item(List.of("Subramanian","Karhtik"));
    }


}
