package rats.BM.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import rats.BM.DTO.BookDTO;
import rats.BM.Domain.Book;
import rats.BM.Service.BookService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000/", allowCredentials = "true")
public class BookController {

    private final BookService bs;

    @Autowired
    public BookController(BookService bs) {
        this.bs = bs;
    }

    //책 추가
    @PutMapping("/api/book/add")
    public Book addBook(@RequestBody BookDTO bookDTO) {
        Book book = new Book();
        book.setBookname(bookDTO.getBookName());
        book.setISBN(bookDTO.getISBN());
        book.setAuthor(bookDTO.getAuthor());
        book.setPublisher(bookDTO.getPublisher());

        bs.addBook(book);
        return book;
    }

    //책 조회 - 전체 책 리스트 반환
    @GetMapping("/api/book/list")
    @ResponseBody
    public List<Book> getBookList() {
        for(Book item : bs.findAllBook()){
            System.out.println(item.getSid());
        }
        return bs.findAllBook();
    }

    //책 대출

}
