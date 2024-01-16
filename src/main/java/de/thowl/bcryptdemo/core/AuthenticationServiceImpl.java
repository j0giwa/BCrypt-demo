package de.thowl.bcryptdemo.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.thowl.bcryptdemo.core.services.AuthenticationService;
import de.thowl.bcryptdemo.storage.UserRepository;
import de.thowl.bcryptdemo.storage.entities.User;
import lombok.extern.slf4j.Slf4j;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Slf4j
@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    
    @Autowired
    private UserRepository repo;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(15);

    public String login(String email, String password){
        log.debug("entering login");
        log.info("Login attempt with E-Mail: {}", email);

        User usr = this.repo.findByEmail(email);
        if (null == usr) {
            // User not registert
            log.error("E-Mail: {} does not exitst", email);
            return null;
        }

        log.info("Comparing Form-password with BCrypt-hash");
        String dbpasswd = usr.getPassword();
        log.debug("BCrypt-hash: {}", dbpasswd);

        if (!encoder.matches(password, dbpasswd)) {
            log.info("Password did not match, login failed");
            return null;
        }

        log.info("Password matched, login successfull");
        return usr.getUsername();
    }
}
