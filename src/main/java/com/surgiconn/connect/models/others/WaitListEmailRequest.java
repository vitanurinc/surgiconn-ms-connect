package com.surgiconn.connect.models.others;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class WaitListEmailRequest {
    private String fullName;
    private String type;
    private String email;
    private String comment;
}
