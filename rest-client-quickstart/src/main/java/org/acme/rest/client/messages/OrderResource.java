package org.acme.rest.client.messages;


import io.smallrye.mutiny.Uni;
import io.vertx.core.json.JsonObject;
import io.vertx.mutiny.core.eventbus.EventBus;
import io.vertx.mutiny.core.eventbus.Message;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/orders")
public class OrderResource {

    @Inject
    EventBus eventBus;

    @GET
    public String publishOrders() {
        JsonObject orders = new JsonObject().put("id", 1).put("desc", "Mainframes");
        //point to point -  one to one
        //eventBus.send("ibm.orders", orders);
        //pub- sub - one to many
        // eventBus.publish("ibm.orders",orders);
        //request-reply
        Uni<Message<String>> status = eventBus.request("ibm.orders", orders);
        System.out.println(status);
        status.onItem().transform(stringMessage ->{
            System.out.println(stringMessage);
            return stringMessage;
        }).subscribe();

         return  "Published";
//        return eventBus.<JsonObject>request("ibm.orders",orders).onItem().transform(Message::body);
    }
}
