package business.concretes;

import business.abstracts.UserCheckService;
import business.abstracts.UserService;
import business.abstracts.VerificationService;
import dataAccess.abstracts.UserDao;
import entities.concretes.User;

import java.util.List;

public class UserManager implements UserService {
    private UserDao userDao;
    private UserCheckService userCheckService;
    private VerificationService verificationService;

    public UserManager(UserDao userDao, UserCheckService userCheckService, VerificationService verificationService) {
        this.userDao = userDao;
        this.userCheckService = userCheckService;
        this.verificationService = verificationService;
    }




    public void logIn(User user) {
        if (userDao.getEmail(user.getePosta())&& userDao.getPassword(user.getParola())&&verificationService.checkMailVerificated(user.getePosta())){
            System.out.println(" Giriş başarılı: " + user.getePosta());

        } else if (userDao.getEmail(user.getePosta())&& userDao.getPassword(user.getParola())) {
            System.out.println(" Lütfen eposta hesabınıza gönderilen mailden hesabınızı doğrulayın! ");


        }else {
            System.out.println(" Kullanıcı veya Şifre Hatalı");
        }


    }

    @Override
    public void signUp(User user, List<User> users) {
        if (userCheckService.checkUsedEmail(user,users) && userCheckService.checkEmail(user) && userCheckService.checkFirstName(user)&&userCheckService.checkLastName(user) && userCheckService.checkPassword(user) && userCheckService.eMailConfirmation(true) ){
            userDao.addUser(user);
            System.out.println(" Kayıt Başarılı: " + user.getFirstName()+ " " + user.getLastName());

        }
        else {
            System.out.println(" Kayıt Yapılamadı! ");
        }

    }
}
