package pl.com.bottega.hrs.application;

import org.springframework.stereotype.Component;
import pl.com.bottega.hrs.application.users.User;
import pl.com.bottega.hrs.model.commands.Command;
import pl.com.bottega.hrs.model.commands.CommandInvalidException;
import pl.com.bottega.hrs.model.commands.RegisterUserCommand;
import pl.com.bottega.hrs.model.commands.ValidationErrors;
import pl.com.bottega.hrs.model.repositories.UserRepository;

@Component
public class RegisterUserHandler implements Handler<RegisterUserCommand> {

    private UserRepository userRepository;

    public RegisterUserHandler(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void handle(RegisterUserCommand cmd) {
        if (userRepository.isLoginTaken(cmd.getLogin())) {
            ValidationErrors validationErrors = new ValidationErrors();
            validationErrors.add("login", "This login is already taken.");
            throw new CommandInvalidException(validationErrors);
        }
        User user = new User(cmd.getLogin(), cmd.getPassword());
        userRepository.save(user);
    }

    @Override
    public Class<? extends Command> getSupportedCommandClass() {
        return RegisterUserCommand.class;
    }
}
