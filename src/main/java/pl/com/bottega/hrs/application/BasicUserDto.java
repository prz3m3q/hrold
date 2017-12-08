package pl.com.bottega.hrs.application;

import pl.com.bottega.hrs.application.users.User;

public class BasicUserDto {

    private Integer id;

    private String login, password;

    public BasicUserDto(User user) {
        this.login = user.getLogin();
        this.password = user.getPassword();
        this.id = user.getId();
    }

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
}
