package com.example.book.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BookRegistrationDTO {
    private String title;
    private String author;
    private String publisher;
    private String isbn;
}
