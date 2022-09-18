package com.surgiconn.connect.models.others;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OTPEmailRequest {

    private String email;

    private String otp;

}
