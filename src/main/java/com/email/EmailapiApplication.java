package com.email;

import com.email.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmailapiApplication {

    public static void main(String[] args) {

        SpringApplication.run(EmailapiApplication.class, args);
    }

}
