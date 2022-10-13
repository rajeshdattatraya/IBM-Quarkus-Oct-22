package org.acme.services;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@ApplicationScoped
//@HaiQualifier
@Named("haiworld")
public class HaiWorld implements Greeter{
    @Override
    public String sayGreet() {
        return "Hai World";
    }
}
