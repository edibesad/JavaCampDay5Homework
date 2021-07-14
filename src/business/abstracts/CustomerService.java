package business.abstracts;

import entities.concretes.User;

public interface CustomerService {
    void createUser(User user);
    void loginUser(String email, String password);
}
