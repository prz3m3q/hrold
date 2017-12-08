package pl.com.bottega.hrs.ui.rest;

import org.springframework.web.bind.annotation.*;
import pl.com.bottega.hrs.application.BasicUserDto;
import pl.com.bottega.hrs.application.CommandGateway;
import pl.com.bottega.hrs.application.UserFinder;
import pl.com.bottega.hrs.model.commands.RegisterUserCommand;

@RestController
public class UserController {

    private UserFinder userFinder;
    private CommandGateway gateway;

    public UserController(UserFinder userFinder, CommandGateway gateway) {
        this.userFinder = userFinder;
        this.gateway = gateway;
    }

    @PostMapping("/users")
    public void register(@RequestBody RegisterUserCommand cmd) {
        gateway.execute(cmd);
    }

//    @PatchMapping("/users/{id}")
//    public void update(@RequestBody UpdateUserCommand cmd) {
//        gateway.execute(cmd);
//    }

    @GetMapping("/users/{userId}")
    public BasicUserDto getUserDetails(@PathVariable Integer userId) {
        return userFinder.getUserDetails(userId);
    }
}
