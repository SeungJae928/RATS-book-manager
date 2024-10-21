package com.example.book.Entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity(name = "books")
public class Book {

    // ISBN를 사용하므로 @GeneratedValue 제거
    @Id
    private String id;

    @Column(name = "title")
    private String title;

    @Column(name = "author")
    private String author;

    @Column(name = "publisher")
    private String publisher;

    @Builder
    public Book(String id, String title, String author, String publisher){
        this.id = id;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
    }
}
