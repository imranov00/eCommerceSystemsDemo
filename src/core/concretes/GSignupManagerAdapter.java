package core.concretes;

import GoogleSignUp.GSignUpManager;
import core.abstracts.SignUpService;
import entities.concretes.User;

public class GSignupManagerAdapter implements SignUpService {
    @Override
    public void SignUpService(User user) {
        GSignUpManager gSignUpManager = new GSignUpManager();
        gSignUpManager.SignUp(user.getFirstName() + " " + user.getLastName());

    }
}
