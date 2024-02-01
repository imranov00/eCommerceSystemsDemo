package business.abstracts;

import entities.concretes.User;

import java.util.List;

public interface UserService {
    void logIn(User user);
    void signUp(User user, List<User> users);
}
