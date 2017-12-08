package pl.com.bottega.hrs.acceptance;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.com.bottega.hrs.application.*;
import pl.com.bottega.hrs.model.Address;
import pl.com.bottega.hrs.model.Gender;
import pl.com.bottega.hrs.model.commands.AddDepartmentCommand;
import pl.com.bottega.hrs.model.commands.AddEmployeeCommand;
import pl.com.bottega.hrs.model.commands.RegisterUserCommand;

import java.time.LocalDate;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
public class RegisterUserTest extends AcceptanceTest {

    @Autowired
    private RegisterUserHandler registerUserHandler;

    @Autowired
    private UserFinder userFinder;

    @Test
    public void shouldRegisterUser() {
        RegisterUserCommand registerUserCommand = new RegisterUserCommand();
        registerUserCommand.setLogin("login");
        registerUserCommand.setPassword("password");
        registerUserCommand.setRepeatedPassword("password");

        registerUserHandler.handle(registerUserCommand);

        // then
        BasicUserDto userDto = userFinder.getUserDetails(1);
        assertEquals("login", userDto.getLogin());
        assertEquals("password", userDto.getPassword());
    }
}
