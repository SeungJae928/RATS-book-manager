package rats.BM.Service;

import jakarta.transaction.Transactional;
import rats.BM.Domain.Book;
import rats.BM.Repository.BookRepository;
import rats.BM.Repository.JPABookRepository;

import java.util.List;

@Transactional
public class BookServiceImpl implements BookService{

    private final BookRepository br;

    public BookServiceImpl(BookRepository br) {
        this.br = br;
    }

    @Override
    public void addBook(Book book) {
        br.addBook(book);
    }

    @Override
    public void borrowBook() {

    }

    @Override
    public void returnBook() {

    }

    @Override
    public Book findBookByBookName(String bookName) {
        return null;
    }

    @Override
    public Book findBookByISBN(String ISBN) {
        return null;
    }

    @Override
    public List<Book> findAllBook() {
        return br.findAllBook();
    }
}
