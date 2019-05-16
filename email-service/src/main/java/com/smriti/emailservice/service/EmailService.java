package com.smriti.emailservice.service;

import com.smriti.emailservice.entities.Admin;
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

    public void sendEmail(Admin admin)throws MailException {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(admin.getEmailAddress());
        mailMessage.setFrom("mool.smreeti@gmail.com");
        mailMessage.setSubject("Thank you for registering on Instagram " +admin.getUsername()+"....");
        mailMessage.setText(" Dear " +admin.getEmailAddress() +" activate your account by using this password:");
        javaMailSender.send(mailMessage);
    }
}