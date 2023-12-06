package service;

import model.User;

public interface UserService {
    User register();
    User login();
    void getUserByEmail(String email);
    void getAllUsers();
}
