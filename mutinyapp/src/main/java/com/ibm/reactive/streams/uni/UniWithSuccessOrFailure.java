package com.ibm.reactive.streams.uni;


import io.smallrye.mutiny.Uni;

class LoginService {
    public Uni<String> auth(String name, String password) {
        if (name.equals("admin") && password.equals("admin")) {
            return Uni.createFrom().item("Login Success");
        }
        return Uni.createFrom().failure(new RuntimeException("Login Failed"));
    }
}

public class UniWithSuccessOrFailure {
    public static void main(String[] args) {
        LoginService login = new LoginService();
        login.auth("admin", "admin").subscribe().with(status -> {
            System.out.println(status);
        }, err -> {
            System.out.println(err.getMessage());
        });
        login.auth("foo", "admin").subscribe().with(status -> {
            System.out.println(status);
        }, err -> {
            System.out.println(err.getMessage());
        });
    }
}
