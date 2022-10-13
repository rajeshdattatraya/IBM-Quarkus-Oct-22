package org.acme.services;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@ApplicationScoped
//@HelloQualifier
@Named("helloworld")
public class HelloWorld implements Greeter {
    @Override
    public String sayGreet() {
        return "Hello World";
    }
}
