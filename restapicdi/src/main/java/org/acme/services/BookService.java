package org.acme.services;

import org.acme.model.Book;
import org.acme.services.interceptors.LogEvent;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class BookService {

    @Inject
    NumberGenerator numberGenerator;

    @PostConstruct
    public void init() {
        System.out.println("INIT");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Destroy");
    }

    public Book createBook() {
        Book book = new Book("Quarkus In Action", 1000, "Subramanian");
        book.setIsbnNumber(numberGenerator.generateISBNNumber());
        return book;
    }
}
