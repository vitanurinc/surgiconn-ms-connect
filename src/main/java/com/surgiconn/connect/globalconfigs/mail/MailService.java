package com.surgiconn.connect.globalconfigs.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class MailService {
    private final JavaMailSender javaMailSender;

    @Autowired
    public MailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Async
    public void sendMail(String from, String to, String subject, String msg) {
        try {
            MimeMessage message = javaMailSender.createMimeMessage();

            MimeMessageHelper helper;
            helper = new MimeMessageHelper(message, true);
            helper.setSubject(subject);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setText(msg, true);

            javaMailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
            Logger.getLogger(MailService.class.getName()).log(Level.SEVERE, null, e);
        }
    }

}