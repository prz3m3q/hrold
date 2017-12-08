package pl.com.bottega.hrs.model.commands;

public class RegisterUserCommand implements Command {

    private Integer id;
    private String login, password, repeatedPassword;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepeatedPassword() {
        return repeatedPassword;
    }

    public void setRepeatedPassword(String repeatedPassword) {
        this.repeatedPassword = repeatedPassword;
    }

    @Override
    public void validate(ValidationErrors validationErrors) {
        validatePresence(validationErrors, "login", login);
        validatePresence(validationErrors, "password", password);
        validatePresence(validationErrors, "repeatedPassword", repeatedPassword);

        if (login != null && !login.matches("[A-Za-z0-9]*")) {
            validationErrors.add("login", "Login should contain only letters.");
        }

        if (password != null && password.trim().length() < 6) {
            validationErrors.add("password", "Minimum password length is 6.");
        }

        if (password != null && !password.equals(repeatedPassword)) {
            validationErrors.add("repeatedPassword", "Repeated password is not the same.");
        }
    }
}
