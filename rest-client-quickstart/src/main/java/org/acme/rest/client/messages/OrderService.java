package org.acme.rest.client.messages;


import io.quarkus.vertx.ConsumeEvent;
import io.smallrye.mutiny.Uni;
import io.vertx.core.json.JsonObject;
import io.vertx.mutiny.core.eventbus.Message;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class OrderService {

    @ConsumeEvent("ibm.orders-dummy")
    public void processOrder(Message<JsonObject> orders) {
        System.out.println("Order Service");
        System.out.println(orders.body().encodePrettily());
    }
}
