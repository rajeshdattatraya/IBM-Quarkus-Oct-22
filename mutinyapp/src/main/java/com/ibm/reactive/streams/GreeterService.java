package com.ibm.reactive.streams;

public class GreeterService {
    private HelloWorldService helloWorldService;

    public GreeterService() {

    }

    public GreeterService(HelloWorldService helloWorldService) {
        this.helloWorldService = helloWorldService;
    }

    public void sayHello() {
        helloWorldService.sayHello().subscribe().with(System.out::println);
    }
}
