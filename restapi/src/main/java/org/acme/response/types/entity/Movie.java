package org.acme.response.types.entity;

public class Movie {
    private String id;
    private String name;
    private String author;

    public Movie() {
    }

    public Movie(String id, String name, String author) {
        this.id = id;
        this.name = name;
        this.author = author;
    }

    public String getISBN() {
        return id;
    }

    public void setISBN(String ISBN) {
        this.id = ISBN;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}