package com.example.book.Service;

import com.example.book.DTO.BookRegistrationDTO;
import com.example.book.Entity.Book;

public interface BookService {
    String registerBook(BookRegistrationDTO bookRegistrationDTO); // 신규 도서 등록
}
