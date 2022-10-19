package org.acme.rest.client;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

//http://localhost:8080/hello
//@RegisterRestClient

@RegisterRestClient(configKey = "hello-api")
@Path("/hello") //Callee route end point
public interface HelloRestClientService {
    //methods
    @GET
    String sayHello();
}
