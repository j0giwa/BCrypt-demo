package de.thowl.bcryptdemo.core.services;

public interface AuthenticationService {
    
    /**
     * Performs an "login" action for demonstrition purpuses.
     * No Accestokens or similar this are handled
     * 
     * Source: https://www.masterspringboot.com/security/authentication/using-bcryptpasswordencoder-to-encrypt-your-passwords/
     * 
     * @param email
     * @param password
     * @return Username of user
     * @return @Code{}
     */
    public String login(String email, String password);
}
