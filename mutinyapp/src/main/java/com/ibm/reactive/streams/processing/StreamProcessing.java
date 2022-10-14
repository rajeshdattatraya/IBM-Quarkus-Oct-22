package com.ibm.reactive.streams.processing;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;

public class StreamProcessing {
    public static void main(String[] args) {
        //uniStreamProcessing();
        multiStreamProcessing().select()
                .where(n -> n % 2 == 0)
                .select().first(5)
                .select().distinct()
                .onItem().transform(n -> "[" + n + "]")
                .subscribe().with(System.out::println);
    }

    private static Multi<Integer> multiStreamProcessing() {
        //filter even numbers
        return Multi.createFrom()
                .range(1, 101);

    }

    private static void uniStreamProcessing() {
        Uni.createFrom()
                .item(2)
                .onItem()
                .transform(item -> item * 2)
                .subscribe().with(System.out::println);
    }
}
