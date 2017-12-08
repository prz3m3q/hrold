package pl.com.bottega.hrs.application.users;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="user")
public class User {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(unique = true)
    private String login;

    private String password;

    @ElementCollection
    @CollectionTable(
        name = "user_roles",
        joinColumns = @JoinColumn(name="user_id")
    )
    @Column(name="role")
    @Enumerated(EnumType.STRING)
    private Set<Role> roles = new HashSet<>();

    User() {}

    public User(String login, String password) {
        this.login = login;
        this.password = password;
        roles.add(Role.STANDARD);
    }

    public Integer getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public Set<Role> getRoles() {
        return roles;
    }
}
