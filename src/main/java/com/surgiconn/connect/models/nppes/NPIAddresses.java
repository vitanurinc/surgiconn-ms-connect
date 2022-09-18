package com.surgiconn.connect.models.nppes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;

@Setter
@Getter

public class NPIAddresses implements Serializable {

    private String country_code;
    private String country_name;
    private String address_purpose;
    private String address_type;
    private String address_1;
//    private String address_2;
    private String city;
    private String state;
    private String postal_code;
    private String telephone_number;
    private String fax_number;

    public NPIAddresses() {
    }

    public NPIAddresses(String country_code, String country_name, String address_purpose, String address_type, String address_1, String city, String state, String postal_code, String telephone_number, String fax_number) {
        this.country_code = country_code;
        this.country_name = country_name;
        this.address_purpose = address_purpose;
        this.address_type = address_type;
        this.address_1 = address_1;
//        this.address_2 = address_2;
        this.city = city;
        this.state = state;
        this.postal_code = postal_code;
        this.telephone_number = telephone_number;
        this.fax_number = fax_number;
    }
}
