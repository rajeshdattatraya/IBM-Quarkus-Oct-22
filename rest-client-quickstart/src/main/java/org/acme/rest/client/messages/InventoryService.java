package org.acme.rest.client.messages;

import io.quarkus.vertx.ConsumeEvent;
import io.smallrye.mutiny.Uni;
import io.vertx.core.json.JsonObject;
import io.vertx.mutiny.core.eventbus.Message;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class InventoryService {
    @ConsumeEvent("ibm.orders")
    public void processOrder(Message<JsonObject> orders) {
        System.out.println("Inventory Service");
        System.out.println(orders.body().encodePrettily());
    }

//    @ConsumeEvent("ibm.orders")
//    public Uni<String> processOrder(Message<JsonObject> orders){
//          orders.body().encode()
//     }
}
