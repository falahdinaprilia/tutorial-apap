package apap.tutorial.gopud.service;

import apap.tutorial.gopud.model.UserModel;

public interface UserService {
    UserModel addUser(UserModel user);
    public String encrypt(String password);
    UserModel getUserByUsername(String username);
    UserModel updatePassword(UserModel user, String newPassword);
    boolean validatePasswordDemo(String password);
    boolean validatePassword(String password);
}
