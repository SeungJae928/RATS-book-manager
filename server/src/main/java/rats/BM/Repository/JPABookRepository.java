package rats.BM.Repository;

import jakarta.persistence.EntityManager;
import rats.BM.Domain.Book;

import java.util.List;
import java.util.Optional;

public class JPABookRepository implements BookRepository{

    private final EntityManager em;

    public JPABookRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public void addBook(Book book) {
        em.persist(book);
    }

    @Override
    public void deleteBookByBookName(String bookName) {

    }

    @Override
    public Optional<Book> findBookByBookName(String bookName) {
        return Optional.ofNullable(em.find(Book.class, bookName));
    }

    @Override
    public Optional<Book> findBookByISBN(String ISBN) {
        return Optional.ofNullable(em.find(Book.class, ISBN));
    }

    @Override
    public List<Book> findAllBook() {
        return em.createQuery("select m from Book m", Book.class).getResultList();
    }
}
