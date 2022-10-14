package com.ibm.reactive.streams.uni;

import io.smallrye.mutiny.Multi;

public class MulitStream {
    public static void main(String[] args) {
        Multi<Integer> itemsStream = Multi.createFrom().items(1, 2, 3, 4, 5);
        //subscribe
        itemsStream.subscribe().with(item -> {
            System.out.println(item);
        }, err -> {
            System.out.println(err);
        }, () -> {
            System.out.println("Completed");
        });
        //emitting more values : 1..100
        Multi.createFrom().range(1,100).subscribe().with(item -> {
            System.out.println(item);
        }, err -> {
            System.out.println(err);
        }, () -> {
            System.out.println("Completed");
        });

    }
}
