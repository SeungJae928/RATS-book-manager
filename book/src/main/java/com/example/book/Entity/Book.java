package com.example.book.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Book {
    private int id;
    private String title;
    private String author;
    private String publisher;
    private String isbn;
}
