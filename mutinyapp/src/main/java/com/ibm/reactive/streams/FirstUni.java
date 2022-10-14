package com.ibm.reactive.streams;

import io.smallrye.mutiny.Uni;

public class FirstUni {
    public static void main(String[] args) {
        Uni<String> uniStream = Uni.createFrom().item("Hello World");
        //subscribe
        uniStream.subscribe().with(item -> System.out.println(item));

        new GreeterService(new HelloWorldService()).sayHello();
    }
}
