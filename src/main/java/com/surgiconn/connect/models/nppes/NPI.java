package com.surgiconn.connect.models.nppes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;

@Setter
@Getter

public class NPI implements Serializable {

    private String first_name;
    private String last_name;
    private String credential;
    private String sole_proprietor;
    private String gender;
    private String enumeration_date;
    private String last_updated;
    private String status;
    private String name_prefix;
    private String name_suffix;

    public NPI() {
    }

    public NPI(String first_name,
               String last_name,
               String credential,
               String sole_proprietor,
               String gender,
               String enumeration_date,
               String last_updated,
               String status,
               String name_prefix,
               String name_suffix) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.credential = credential;
        this.sole_proprietor = sole_proprietor;
        this.gender = gender;
        this.enumeration_date = enumeration_date;
        this.last_updated = last_updated;
        this.status = status;
        this.name_prefix = name_prefix;
        this.name_suffix = name_suffix;
    }
}
