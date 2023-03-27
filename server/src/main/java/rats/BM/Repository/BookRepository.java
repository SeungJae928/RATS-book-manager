package rats.BM.Repository;

import rats.BM.Domain.Book;

import java.util.List;
import java.util.Optional;

public interface BookRepository {
    public void addBook(Book book);
    public void deleteBookByBookName(String bookName);
    public Optional<Book> findBookByBookName(String bookName);
    public Optional<Book> findBookByISBN(String ISBN);
    public List<Book> findAllBook();
}
