package com.example.book.Controller;

import com.example.book.DTO.BookRegistrationDTO;
import com.example.book.Service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;

@RestController
@RequiredArgsConstructor
@RequestMapping("/Books")
public class BookController {

    private final BookService bookService;

    @PostMapping("/register")
    public ResponseEntity<?> registerBook(@RequestBody BookRegistrationDTO bookRegistrationDTO) {
        String resISBN = null;
        HttpHeaders header = new HttpHeaders();
        header.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));
        try {
            resISBN = bookService.registerBook(bookRegistrationDTO);
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                    .headers(header)
                    .body(e.getMessage());
        }
        return ResponseEntity.ok()
                .headers(header)
                .body(resISBN);
    }
}
