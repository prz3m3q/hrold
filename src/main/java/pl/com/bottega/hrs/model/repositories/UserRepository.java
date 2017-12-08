package pl.com.bottega.hrs.model.repositories;

import pl.com.bottega.hrs.application.users.User;

public interface UserRepository {

    void save(User user);

    User get(Integer userId);

    boolean isLoginTaken(String login);
}
