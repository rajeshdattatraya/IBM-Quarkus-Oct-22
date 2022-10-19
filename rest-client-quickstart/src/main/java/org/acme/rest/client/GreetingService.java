package org.acme.rest.client;

import io.smallrye.mutiny.Uni;
import io.vertx.ext.web.client.WebClientOptions;
import io.vertx.mutiny.core.Vertx;
import io.vertx.mutiny.ext.web.client.HttpResponse;
import io.vertx.mutiny.ext.web.client.WebClient;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/greet")
public class GreetingService {

    @Inject
    @RestClient
    HelloRestClientService helloRestClientService;

    //Grab Vertx Runtime instance
    @Inject
    Vertx vertx;
    WebClient webClient;

    @GET
    public String greet() {
        return helloRestClientService.sayHello();
    }

    @PostConstruct
    public void init() {
        webClient = WebClient.create(vertx, new WebClientOptions()
                .setDefaultHost("localhost")
                .setDefaultPort(8080)
        );
    }

    @GET
    @Path("/vertxclient")
    public Uni<String> greetVertx() {
        return webClient.get("/hello").send().onItem().transform(HttpResponse::bodyAsString);
    }
}
