package com.ibm.reactive.streams.errhandling;

import io.smallrye.mutiny.Uni;

public class FailureHandler {
    public static void main(String[] args) {
        //throw exception and handling
        createException();
        createExceptionWithFallback();
    }

    //fallback with String
    static String fallback(Object item) {
        return "You are good Person";
    }
    //fallback with Another Stream
    static Uni<String> fallbackUni(Object item){
        return Uni.createFrom().item(item.toString());
    }

    private static void createExceptionWithFallback() {
        Uni.createFrom().failure(new Exception("oops"))
                //.onFailure().recoverWithItem(FailureHandler::fallback)
                .onFailure().recoverWithItem(FailureHandler::fallbackUni)
                .onItem().transform(item -> item.toString().toUpperCase())
                .subscribe().with(success -> {
                    System.out.println("Success data  " + success);
                }, err -> {
                    System.out.println(err);
                });
    }

    private static void createException() {
        Uni.createFrom().failure(new Exception("oops"))
                .subscribe().with(success -> {
                    System.out.println(success);
                }, err -> {
                    System.out.println(err);
                });
        System.out.println("done");
    }
}
