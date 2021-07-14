package business.concretes;

import core.abstracts.Authorization;
import dataAcces.abstracts.UserDao;
import business.abstracts.CustomerService;
import entities.concretes.User;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class CustomerManager implements CustomerService {
    UserDao userDao;
    Authorization authorization;

    public CustomerManager(UserDao userDao,Authorization authorization) {
        this.userDao = userDao;
        this.authorization = authorization;
    }

    @Override
    public void createUser(User createdUser){


        String mail = createdUser.getEmail();
        Pattern pattern = Pattern.compile("[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?");
        Matcher matcher = pattern.matcher(mail);
        boolean matchFound = matcher.find();

        if (!matchFound){
            System.out.println("Hatalı email");
        }

        for (User user : userDao.getUsers()) {
            if (createdUser.getEmail().equals(user.getEmail())) {
                System.out.println("Email daha önce kullanılmış");
                return;
            }
        }

        if (createdUser.getUsername().length()<=2){
            System.out.println("Kullanıcı adı 2 haneden uzun olmalıdır");
            return;
        }

        if(createdUser.getPassword().length() < 6){
            System.out.println("Parola 6 haneden uzun olmalıdır");
            return;
        }


        authorization.sendActivation(createdUser);
        this.userDao.addUser(createdUser);
    }

    @Override
    public void loginUser(String email, String password) {
        for (User user : userDao.getUsers()) {
            if (email.equals(user.getEmail())) {
                if (password.equals(user.getPassword())){
                    System.out.println("Giriş başarılı");
                    return;
                }

            }
        }
        System.out.println("Verilen bilgilerde kullanıcı bulunamadı");
    }
}
