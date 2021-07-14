import core.concretes.DefaultAuthorization;
import core.concretes.GoogleAuthorizationAdapter;
import dataAcces.concretes.FakeUserDao;
import business.concretes.CustomerManager;
import entities.concretes.User;

public class Main {

    public static void main(String[] args) {

        CustomerManager customerManager = new CustomerManager(new FakeUserDao(),new DefaultAuthorization());
        User user1 = new User("edibesad","23236490","edibesad@gmail.com");
        customerManager.createUser(user1);

    }
}
