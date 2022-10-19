package org.acme.rest.client;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class HelloService {

    public String sayHello(){
        return "Hello Rest Client!!!!";
    }
}
