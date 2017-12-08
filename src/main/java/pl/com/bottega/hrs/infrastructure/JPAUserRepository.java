package pl.com.bottega.hrs.infrastructure;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pl.com.bottega.hrs.application.users.User;
import pl.com.bottega.hrs.model.repositories.UserRepository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

@Component
public class JPAUserRepository implements UserRepository {

    private EntityManager entityManager;

    public JPAUserRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    public User get(Integer userId) {
        User user = entityManager.find(User.class, userId);
        if(user == null)
            throw new NoSuchEntityException();
        return user;
    }

    @Override
    public boolean isLoginTaken(String login) {
        Query query = entityManager.createQuery("SELECT u FROM User u WHERE u.login = :login");
        query.setParameter("login", login);
        try {
            User user = (User) query.getSingleResult();
        }
        catch (NoResultException ex) {
            return false;
        }
        return true;
    }
}
