package rats.BM;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import rats.BM.Controller.BookController;
import rats.BM.Controller.UserController;
import rats.BM.Repository.BookRepository;
import rats.BM.Repository.JPABookRepository;
import rats.BM.Repository.JPAUserRepository;
import rats.BM.Repository.UserRepository;
import rats.BM.Service.BookService;
import rats.BM.Service.BookServiceImpl;
import rats.BM.Service.UserService;
import rats.BM.Service.UserServiceImpl;

@Configuration
public class AppConfig {

    private EntityManager em;

    @Autowired
    public AppConfig(EntityManager em) {
        this.em = em;
    }

    @Bean
    public UserService userService() {
        return new UserServiceImpl(userRepository());
    }

    @Bean
    public BookService bookService() {
        return new BookServiceImpl(bookRepository());
    }

    @Bean
    public BookRepository bookRepository() {
        return new JPABookRepository(em);
    }

    @Bean
    public UserRepository userRepository() {
        return new JPAUserRepository(em);
    }
}
