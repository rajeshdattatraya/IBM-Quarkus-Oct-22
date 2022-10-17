package org.acme;

import io.smallrye.common.annotation.Blocking;
import io.smallrye.mutiny.Uni;
import org.acme.service.HelloService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/api/hello")
public class HelloResource {

    @Inject
    HelloService helloService;

    @GET
    @Blocking
    public Uni<String> hello() throws Exception {
        System.out.println("Hello =>" + Thread.currentThread().getName());
        return Uni.createFrom().item(helloService.hello());
    }
}
