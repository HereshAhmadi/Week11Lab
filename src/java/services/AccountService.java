package services;

import dataaccess.UserDB;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.User;

public class AccountService {
    
    public User login(String username, String password) {
        UserDB userDB = new UserDB();
        
        try {
            User user = userDB.getUser(username);
            if (password.equals(user.getPassword())) {
                Logger.getLogger(AccountService.class.getName()).log(Level.INFO, "Successful login by {0}", username);
                return user;
            }
        } catch (Exception e) {
        }
        
        return null;
    }
}
