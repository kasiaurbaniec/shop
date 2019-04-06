package pl.sda.urbaniec.DAO;

import pl.sda.urbaniec.model.Role;
import pl.sda.urbaniec.model.User;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class UserDB {
    private static UserDB userDBInstance;
    private final List<User> userList;

    private UserDB() {
        this.userList = new LinkedList<>();
        this.userList.add(new User("admin@admin.com", "admin", "admin", Arrays.asList(Role.ADMIN, Role.USER)));
    }

    public static synchronized UserDB getInstance() {
        if (UserDB.userDBInstance == null) {
            UserDB.userDBInstance = new UserDB();
        }
        return UserDB.userDBInstance;
    }

    public List<User> getUserList() {
        return this.userList;
    }

    public Optional<User> getUserByLogin(final String login) {
        return this.userList.stream().filter(x -> x.getLogin().contains(login)).findFirst();
    }

    public void createUser(final String email, final String password, final String login, final List<Role> roles) {
        final User user = new User(email, password, login, roles);
        this.userList.add(user);

    }

}
