package com.email.controller;

import com.email.model.EmailRequest;
import com.email.model.EmailResponse;
import com.email.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class EmailController {
    @Autowired
    private EmailService emailService;
//    @GetMapping("/welcome")
//    public String welcome(){
//        return "Hello this is my email api";
//    }

    //api to send email
//    @RequestMapping(value = "/sendemail", method = RequestMethod.POST)
    @PostMapping("/sendemail")
    public ResponseEntity<?> sendEmail(@RequestBody EmailRequest emailRequest){
        System.out.println(emailRequest);
        boolean result=this.emailService.sendEmail(emailRequest.getSubject(), emailRequest.getMessage(), emailRequest.getTo());
        if(result){
            return ResponseEntity.ok(new EmailResponse("Email sent successfully"));
        }else {
            return ResponseEntity.badRequest().body(new EmailResponse("Failed to send email"));
        }
    }
}
