package com.surgiconn.connect.controllers;

import com.surgiconn.connect.globalconfigs.mail.MailService;
import com.surgiconn.connect.models.others.GeneralEmailRequest;
import com.surgiconn.connect.models.others.OTPEmailRequest;
import com.surgiconn.connect.models.others.WaitListEmailRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import java.util.Locale;

@RequiredArgsConstructor
@CrossOrigin
@RestController
@RequestMapping(path = "api/v1/send")
@Api(value = "Send Email", description = "Send Email")
public class SendEmailController {

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private MailService mailService;

    private final SpringTemplateEngine htmlTemplateEngine;

    private static final Logger logger = LoggerFactory.getLogger(SendEmailController.class);

    @ApiOperation(value = "Send wait list eMail")
    @PostMapping(path = "/email")
    public ResponseEntity<?> sendEmailGeneral(@RequestBody GeneralEmailRequest generalEmailRequest) {
        try {
            mailService.sendMail(
                    generalEmailRequest.getFrom(),
                    generalEmailRequest.getTo(),
                    generalEmailRequest.getSubject(),
                    generalEmailRequest.getHtml()
            );
            return ResponseEntity.ok().build();
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @ApiOperation(value = "Send wait list eMail")
    @PostMapping(path = "/emailWaitlist")
    public ResponseEntity<?> sendEmailWaitList(@RequestBody WaitListEmailRequest request) {

        final Context ctx = new Context(Locale.US);
        ctx.setVariable("fullname", request.getFullName());
        ctx.setVariable("type", request.getType());
        ctx.setVariable("email", request.getEmail());
        ctx.setVariable("comment", request.getComment());

        final String htmlContent = this.htmlTemplateEngine.process("email-wait-list.html", ctx);

        try {
            mailService.sendMail(
                    "noreply@horecami.com",
                    "faridvaliyev.az@gmail.com",
                    "Surgiconn - Received new Wait List!",
                    htmlContent
            );
            return ResponseEntity.ok().build();
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @ApiOperation(value = "Send OTP Code eMail")
    @PostMapping(path = "/emailOTP")
    public ResponseEntity<?> sendEmailOTP(@RequestBody OTPEmailRequest request) {

        System.out.println("REQ EMAIL: "+ request.getEmail());
        System.out.println("REQ OTP: "+ request.getOtp());
        final Context ctx = new Context(Locale.US);
        ctx.setVariable("otp", request.getOtp());

        final String htmlContent = this.htmlTemplateEngine.process("email-otp.html", ctx);

        try {
            mailService.sendMail(
                    "noreply@horecami.com",
                    request.getEmail(),
                    "Surgiconn - OTP",
                    htmlContent
            );
            return ResponseEntity.ok().build();
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

}