package com.example.book.Service;

import com.example.book.DTO.BookRegistrationDTO;
import com.example.book.Entity.Book;
import com.example.book.Repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    public String registerBook(BookRegistrationDTO bookRegistrationDTO) {
        // 이미 같은 isbn을 가진 책이 있을 경우 예외 발생
        bookRepository.findById(bookRegistrationDTO.getIsbn()).ifPresent(a -> {
            throw new IllegalStateException("이미 등록된 도서입니다.");
        });

        Book book = Book.builder()
                .title(bookRegistrationDTO.getTitle())
                .id(bookRegistrationDTO.getIsbn())
                .author(bookRegistrationDTO.getAuthor())
                .publisher(bookRegistrationDTO.getPublisher())
                .build();

        // 책 등록 성공시 등록 id 반환
        return bookRepository.save(book).getId();
    }
}
