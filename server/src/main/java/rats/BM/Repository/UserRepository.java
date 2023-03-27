package rats.BM.Repository;

import rats.BM.Domain.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    User save(User u);
    List<User> findByID(String id);
    Optional<User> findByName(String name);
    List<User> findAll();
    Optional<User> findBySid(String sid);
}
