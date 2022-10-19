package org.acme.rest.client;


import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/hello")
public class HelloResource {

    @Inject
    HelloService helloService;

    @GET
    public String hello(){
        return helloService.sayHello();
    }
}
