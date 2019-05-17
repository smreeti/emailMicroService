package com.smriti.emailservice.controller;

import com.smriti.emailservice.responseDTO.AdminResponseDTO;
import com.smriti.emailservice.responseDTO.ResponseDTO;
import com.smriti.emailservice.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/api")
@EnableScheduling
public class EmailController {

    @Autowired
    private RestTemplate restTemplate;

    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @Scheduled(fixedRate = 5000)
    public void scheduleEmailSend() {

//        AdminResponseDTO admins = restTemplate.getForObject("http://localhost:8081/api/admins",
//                AdminResponseDTO.class);
//        System.out.println(admins.getEmailAddress());
//        System.out.println("hello");
        AdminResponseDTO admins = new AdminResponseDTO();

        admins.setEmailAddress("smriti.mool@f1soft.com");
        try{
        emailService.sendEmail(admins);

        }catch (MailException m){
            System.out.println(m);
        }
//        admins.forEach(admin -> {
//            emailService.sendEmail(admin);
//        });


    }
}
