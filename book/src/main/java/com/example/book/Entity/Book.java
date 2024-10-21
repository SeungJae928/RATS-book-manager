package com.example.book.Entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "author")
    private String author;

    @Column(name = "publisher")
    private String publisher;

    @Column(name = "isbn")
    private String isbn;

    @Builder
    public Book(String title, String author, String publisher, String isbn){
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.isbn = isbn;
    }
}
