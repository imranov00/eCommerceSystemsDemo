package business.concretes;

import business.abstracts.VerificationService;
import entities.concretes.User;

import java.util.ArrayList;
import java.util.List;

public class VerificationManager implements VerificationService {
    private List<String> verifiedMails = new ArrayList<String>();
    @Override
    public void sendEmail(User user) {
        System.out.println(user.getePosta() + " Mailine Doğrulama E-Postası Gönderildi. ");
    }

    @Override
    public boolean checkMailVerificated(String email) {
        if (verifiedMails.contains(email)){
            return true;
        }
        return false;
    }
}
