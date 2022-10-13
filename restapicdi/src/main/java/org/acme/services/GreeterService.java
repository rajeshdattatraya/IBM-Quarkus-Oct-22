package org.acme.services;


import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

@ApplicationScoped
public class GreeterService {

    @Inject
//    @HaiQualifier
    @Named("helloworld")
    Greeter greeter;

    public String sayGreet() {
        return greeter.sayGreet();
    }
}
