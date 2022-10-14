package com.ibm.reactive.streams;

import io.smallrye.mutiny.Uni;

public class UniWithFailure {
    public static void main(String[] args) {
      Uni<String> stream =  Uni.createFrom().failure(new RuntimeException("oops"));

      stream.subscribe().with(System.out::println);


    }
}
