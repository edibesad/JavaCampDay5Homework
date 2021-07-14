package core.concretes;

import core.abstracts.Authorization;
import entities.concretes.User;

public class DefaultAuthorization implements Authorization {
    @Override
    public void sendActivation(User user) {
        System.out.println("Kayıt Oluşturuldu. Doğrulama e-postası yollandı : " + user.getEmail());
    }
}
