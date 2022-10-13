package org.acme.services;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import java.util.List;

@ApplicationScoped
public class Producers {
    //instance variables; going to be dependency to some other classes

    @Produces
    double price = 10.90;

    //instance methods; going to be dependency to some other classes
    @Produces
    List<String> topics() {
        return List.of("cdi", "rest", "reactive");
    }

}
