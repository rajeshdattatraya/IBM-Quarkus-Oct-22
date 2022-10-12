package org.acme.services;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class HeroineService {
    public String getHeroine(){
        return  "Heroine";
    }
}
