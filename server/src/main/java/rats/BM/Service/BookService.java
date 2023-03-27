package rats.BM.Service;

import rats.BM.Domain.Book;

import java.util.List;

public interface BookService {
    public void addBook(Book book);
    public void borrowBook();
    public void returnBook();
    public Book findBookByBookName(String bookName);
    public Book findBookByISBN(String ISBN);
    public List<Book> findAllBook();
}
