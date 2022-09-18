package com.surgiconn.connect.models.nppes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;

@Setter
@Getter

public class NPITaxonomies implements Serializable {

    private String code;
    private String desc;
    private Boolean primary;
    private String state;
    private String license;

    public NPITaxonomies() {
    }

    public NPITaxonomies(String code, String desc, Boolean primary, String state, String license) {
        this.code = code;
        this.desc = desc;
        this.primary = primary;
        this.state = state;
        this.license = license;
    }
}
