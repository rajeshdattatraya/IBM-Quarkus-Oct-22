package com.ibm.reactive.streams;

import io.smallrye.mutiny.Uni;

public class HelloWorldService {

    //api to return stream
    public Uni<String> sayHello(){
        return Uni.createFrom().item("Hello World");
    }
}
