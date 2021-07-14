package core.concretes;

import core.abstracts.Authorization;
import core.concretes.GoogleAuthorization;
import entities.concretes.User;

public class GoogleAuthorizationAdapter implements Authorization {
    @Override
    public void sendActivation(User user) {
    GoogleAuthorization googleAuthorization = new GoogleAuthorization();
    if(googleAuthorization.authorize(user.getEmail())){
        System.out.println("Google ile giriş yapıldı");
    }
    else{
        System.out.println("Google ile giriş yapılırken bir hata oluştu");
    }
    }
}
