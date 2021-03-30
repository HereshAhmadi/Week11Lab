package services;

import dataaccess.UserDB;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.User;

public class AccountService {
    
    public User login(String username, String password, String path) {
        UserDB userDB = new UserDB();
        
        try {
            User user = userDB.getUser(username);
            if (password.equals(user.getPassword())) {
                // Log successful login attempt
                Logger.getLogger(AccountService.class.getName()).log(Level.INFO, "Successful login by {0}", username);
                // Send an email about log in
                //GmailService.sendMail(user.getEmail(), "NoteKeeper Login", "Hi, " +user.getFirstName() + " you logged in on " + (new Date()).toString(), false);
                
                // Setting up template variables
                String to = user.getEmail();
                String subject = "NoteKeeper Login";
                String template = path + "/email_templates/login_email.html";
                // create a hashmap to store the name value pairs that will be used in the template
                HashMap<String, String> tags = new HashMap<>();
                tags.put("firstname", user.getFirstName());
                tags.put("lastname", user.getLastName());
                tags.put("date", (new java.util.Date()).toString() );
                // Send Templated e-mail
                GmailService.sendMailTemplated(to, subject, template, tags);

                return user;
            }
        } catch (Exception e) {
        }
        
        return null;
    }
}
