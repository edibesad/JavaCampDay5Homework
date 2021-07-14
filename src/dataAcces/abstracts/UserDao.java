package dataAcces.abstracts;

import entities.concretes.User;

import java.util.ArrayList;

public interface UserDao {
    void addUser(User user);
    ArrayList<User> getUsers();
}
