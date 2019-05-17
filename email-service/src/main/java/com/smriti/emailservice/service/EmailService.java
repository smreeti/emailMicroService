package com.smriti.emailservice.service;

import com.smriti.emailservice.responseDTO.AdminResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service("emailService")
public class EmailService {

    private JavaMailSender javaMailSender;

    @Autowired
    public EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendEmail(AdminResponseDTO admin)throws MailException {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(admin.getEmailAddress());
        mailMessage.setFrom("etest4367@gmail.com");
        mailMessage.setSubject("Email sent...");
        mailMessage.setText(" Dear " +admin.getEmailAddress() +" email has been sent to you..");
        javaMailSender.send(mailMessage);
    }
}