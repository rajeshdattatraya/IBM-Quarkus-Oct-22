package com.ibm.reactive.streams.errhandling;

import io.smallrye.mutiny.Uni;
import io.smallrye.mutiny.subscription.UniEmitter;

import java.util.concurrent.ThreadLocalRandom;

public class RetryHandler {
    public static void main(String[] args) {
        Uni.createFrom().emitter(emitter -> {
                    generate(emitter);
                }).onFailure()
                .invoke(() -> System.out.println("failed"))
                .onFailure().retry().atMost(50)
                .subscribe().with(System.out::println, System.out::println);
    }

    private static void generate(UniEmitter<? super Object> emitter) {
        if (ThreadLocalRandom.current().nextDouble(0.0d, 1.0d) < 0.05d) {
            emitter.complete("Success");
        } else {
            emitter.fail(new RuntimeException("Something went Wrong!"));
        }
    }
}
