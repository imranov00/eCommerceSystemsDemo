import business.abstracts.VerificationService;
import business.concretes.UserCheckManager;
import business.concretes.UserManager;
import business.concretes.VerificationManager;
import core.concretes.GSignupManagerAdapter;
import dataAccess.concretes.HibernateUserDao;
import entities.concretes.User;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {


        List<User> users =new ArrayList<>();
        User user1 = new User(1,"Emin","İmranov","imranov001@gmail.com" ,"123456");
        User user2 = new User(2,"Emin","İmranov","imranov002@gmail.com" ,"123456");
        User user3 = new User(3,"Emin","İmranov","imranov003@gmail.com" ,"123456");
        User user4 = new User(4,"Emin","İmranov","imranov004@gmail.com" ,"123456");
        User user5 = new User(5,"Emin","İmranov","imranov005@gmail.com" ,"123456");
        UserManager userManager = new UserManager(new HibernateUserDao(users), new UserCheckManager(),new VerificationManager());
        userManager.signUp(user1,users);
        System.out.println("-------------------");
        userManager.signUp(user2,users);
        System.out.println("-------------------");
        userManager.signUp(user3,users);
        System.out.println("-------------------");


        GSignupManagerAdapter gSignupManagerAdapter = new GSignupManagerAdapter();
        gSignupManagerAdapter.SignUpService(user4);
        System.out.println("--------------------");
        VerificationManager verificationManager = new VerificationManager();
        verificationManager.sendEmail(user4);
        userManager.logIn(user2);
        System.out.println("--------------------");
        userManager.logIn(user4);

    }
}