package dataAcces.concretes;

import dataAcces.abstracts.UserDao;
import entities.concretes.User;

import java.util.ArrayList;

public class FakeUserDao implements UserDao {

    ArrayList<User> users;

    public FakeUserDao() {
        this.users = new ArrayList<User>();
    }

    @Override
    public void addUser(User user) {

        this.users.add(user);
        }

    @Override
    public ArrayList<User> getUsers() {
        return this.users;
    }
}
