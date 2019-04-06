package pl.sda.urbaniec.model;

import java.util.List;

public class User {
    private String email;
    private String password;
    private String login;
    private List<Role> role;

    public User(final String email, final String password, final String login, final List<Role> role) {
        this.email = email;
        this.password = password;
        this.login = login;
        this.role = role;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public String getLogin() {
        return this.login;
    }

    public void setLogin(final String login) {
        this.login = login;
    }

    public List<Role> getRole() {
        return this.role;
    }

    public void setRole(final List<Role> role) {
        this.role = role;
    }
}
