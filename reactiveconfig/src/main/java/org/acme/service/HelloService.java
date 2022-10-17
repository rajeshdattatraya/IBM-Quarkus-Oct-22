package org.acme.service;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class HelloService {

    public String hello() {
        //delay response
        try {
            Thread.sleep(5000);
        }
        catch (InterruptedException es){

        }
        return  "Hello delayed response";
    }
}
