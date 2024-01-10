package de.thowl.bcryptdemo.web;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

//import de.thowl.bcryptdemo.core.AuthenticationService;
import de.thowl.bcryptdemo.web.forms.LoginForm;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class LoginController {

    //@Autowired
    //private AuthenticationService authsvc;

    @GetMapping("/login")
    public String showLoginPage() {
        log.info("entering showLoginPage (GET-Method: /login)");
        return "index";
    }

    @PostMapping("/login")
    public String doLogin(LoginForm form, Model model) {
        log.info("entering doLogin (POST-Method: /login)");

        log.debug("Email=" + form.getEmail());
        log.debug("Password=" + form.getPassword());

        

        return "index";
    }
    
}
