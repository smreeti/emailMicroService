package com.smriti.emailservice.controller;

import com.smriti.emailservice.responseDTO.ResponseDTO;
import com.smriti.emailservice.service.AdminService;
import com.smriti.emailservice.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@EnableScheduling
public class EmailController {

//    @Autowired
//    private RestTemplate restTemplate;

    @Autowired
    AdminServiceProxy adminServiceProxy;

    private final AdminService adminService;

    private final EmailService emailService;

    public EmailController(AdminService adminService, EmailService emailService) {
        this.adminService = adminService;
        this.emailService = emailService;
    }

    //    @Scheduled(fixedRate = 60000)
    @RequestMapping("/check")
    public void scheduleEmailSend() {

        ResponseDTO admins = adminServiceProxy.getAdminsToSendEmail();
//        ResponseDTO admins = restTemplate.getForObject("http://AdminService/api/admins", ResponseDTO.class);

        admins.getAdminResponseDTOS().forEach(admin -> {
            try {
                emailService.sendEmail(admin);
                adminService.updateAdmin(admin);
            } catch (MailException m) {
                System.out.println(m);
            }
        });
    }

    @GetMapping("/hello/{name}")
    public ResponseEntity<ResponseDTO> sayHello(@PathVariable("name") String name) {
        return new ResponseEntity<>(adminServiceProxy.sayHello(name), HttpStatus.OK);
    }
}
