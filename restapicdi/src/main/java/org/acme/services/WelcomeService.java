package org.acme.services;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class WelcomeService {
    public String sayWelcome(){
        return "Welcome to Quarkus!!!";
    }
}
