package rats.BM.Repository;

import jakarta.persistence.EntityManager;
import rats.BM.Domain.User;

import java.util.List;
import java.util.Optional;

public class JPAUserRepository implements UserRepository {

    private final EntityManager em;

    public JPAUserRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public User save(User u) {
        em.persist(u);
        return u;
    }

    @Override
    public List<User> findByID(String id) {
        List<User> res = em.createQuery("select m from user m where m.userID = userID", User.class)
                .setParameter("userID", id)
                .getResultList();
        return res;
    }

    @Override
    public Optional<User> findByName(String name) {
        List<User> res = em.createQuery("select m from user m where m.userName = :userName", User.class)
                .setParameter("userName", name)
                .getResultList();
        return res.stream().findAny();
    }

    @Override
    public List<User> findAll() {
        return em.createQuery("select m from user m", User.class).getResultList();
    }

    @Override
    public Optional<User> findBySid(String sid) {
        User user = em.find(User.class, sid);
        return Optional.ofNullable(user);
    }
}
