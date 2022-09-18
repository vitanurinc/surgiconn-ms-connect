package com.surgiconn.connect.models.others;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GeneralEmailRequest {

    private String from;

    private String to;

    private String subject;

    private String html;

}
