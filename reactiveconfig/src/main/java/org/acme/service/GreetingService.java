package org.acme.service;

import org.eclipse.microprofile.config.ConfigProvider;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GreetingService {

    @ConfigProperty(name = "greeting.message", defaultValue = "Greeting")
    String message;
    @ConfigProperty(name = "greeting.name", defaultValue = "Quarkus")
    String name;

    public String sayGreet() {
        return message + "  " + name;
    }

    //Read config values via code
    public String saySomething() {
        //    return ConfigProvider.getConfig().getValue("greeting.when",String.class);

        return ConfigProvider.getConfig().
                getOptionalValue("greeting.when", String.class)
                .orElse("long long ago");
    }
}
