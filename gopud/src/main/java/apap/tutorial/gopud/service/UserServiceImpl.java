package apap.tutorial.gopud.service;

import apap.tutorial.gopud.model.UserModel;
import apap.tutorial.gopud.repository.UserDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDB userDB;

    @Override
    public UserModel addUser(UserModel user) {
        String pass = encrypt(user.getPassword());
        user.setPassword(pass);
        return userDB.save(user);
    }

    @Override
    public String encrypt(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(password);
        return hashedPassword;
    }

    @Override
    public UserModel getUserByUsername(String username) {
        return userDB.findByUsername(username);
    }

    @Override
    public UserModel updatePassword(UserModel user, String newPassword) {
        UserModel userTarget = getUserByUsername(user.getUsername());
        String pass = encrypt(newPassword);
        userTarget.setPassword(pass);
        return userDB.save(userTarget);
    }

    @Override
    public boolean validatePasswordDemo(String password) {
        return password.length() >= 10 && Pattern.compile("[0-9]").matcher(password).find() && Pattern.compile("[a-zA-Z]").matcher(password).find();
    }

    @Override
    public boolean validatePassword(String password) {
        return password.length() >= 8 && Pattern.compile("[0-9]").matcher(password).find() && Pattern.compile("[a-zA-Z]").matcher(password).find();
    }
}
