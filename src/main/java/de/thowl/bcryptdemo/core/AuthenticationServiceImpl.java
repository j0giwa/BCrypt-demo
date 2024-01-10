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

        User usr = this.repo.findByEmail(email);
        if (null == usr) {
            // User not registert
            return null;
        }

        String dbpasswd = usr.getPassword();
        log.info("db-passwd {}", dbpasswd);

        if (encoder.matches(password, dbpasswd))
            log.info("Password matched");

        return usr.getUsername();
    }
}
