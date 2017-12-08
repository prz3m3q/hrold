package pl.com.bottega.hrs.infrastructure;

import org.springframework.stereotype.Component;
import pl.com.bottega.hrs.application.BasicUserDto;
import pl.com.bottega.hrs.application.UserFinder;
import pl.com.bottega.hrs.application.users.User;

import javax.persistence.EntityManager;

@Component
public class JPAUserFinder implements UserFinder {

    private EntityManager entityManager;

    public JPAUserFinder(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public BasicUserDto getUserDetails(Integer userId) {
        User user = entityManager.find(User.class, userId);
        if (user == null) {
            throw new NoSuchEntityException();
        }
        return new BasicUserDto(user);
    }
}
