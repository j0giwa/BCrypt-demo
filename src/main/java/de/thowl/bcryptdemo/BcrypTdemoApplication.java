package de.thowl.bcryptdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

// Disable login bullshit
@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class BcrypTdemoApplication {


	public static void main(String[] args) {
		SpringApplication.run(BcrypTdemoApplication.class, args);
	}

}
