package core.abstracts;

import entities.concretes.User;

public interface Authorization {
    void sendActivation(User user);
}
