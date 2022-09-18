package com.surgiconn.connect.models.nppes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Optional;

@Setter
@Getter

public class NPIIdentifiers implements Serializable {

    private String identifier;
    private String code;
    private String desc;
    private String state;
    private Optional<String> issuer;

    public NPIIdentifiers() {
    }

    public NPIIdentifiers(String identifier, String code, String desc, String state, Optional<String> issuer) {
        this.identifier = identifier;
        this.code = code;
        this.desc = desc;
        this.state = state;
        this.issuer = issuer;
    }
}
