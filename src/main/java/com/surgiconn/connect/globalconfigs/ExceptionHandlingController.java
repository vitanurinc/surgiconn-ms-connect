package com.surgiconn.connect.globalconfigs;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.mail.MessagingException;
import javax.net.ssl.SSLHandshakeException;
import java.sql.SQLException;

@Controller
public class ExceptionHandlingController {

    // @RequestHandler methods
    // Exception handling methods
    // Convert a predefined exception to an HTTP Status code
    @ResponseStatus(value = HttpStatus.CONFLICT, reason = "Data integrity violation")  // 409
    @ExceptionHandler(DataIntegrityViolationException.class)
    public void conflict() {
        // Nothing to do
    }

    @ExceptionHandler({SQLException.class, DataAccessException.class})
    public String databaseError() {
        return "databaseError";
    }

    @ExceptionHandler({MessagingException.class})
    public String emailError() {
        return "emailError";
    }

    @ExceptionHandler({SSLHandshakeException.class})
    public String sslError() {
        return "sslError";
    }
}