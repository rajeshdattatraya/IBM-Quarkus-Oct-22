package org.acme.services;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class HeroService {

    public String getHero(){
        return "Hero";
    }
}
