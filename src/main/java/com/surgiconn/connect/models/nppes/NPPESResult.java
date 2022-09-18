package com.surgiconn.connect.models.nppes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Setter
@Getter

public class NPPESResult implements Serializable {

    private String enumeration_type;
    private String number;
    private String last_updated_epoch;
    private String created_epoch;

    private String[] other_names;

    private String[] practiceLocations;

    private String[] endpoints;

    private List<NPIAddresses> addresses;

    private List<NPITaxonomies> taxonomies;

    private List<NPIIdentifiers> identifiers;

    private NPI basic;

    public NPPESResult() {
    }

    public NPPESResult(String enumeration_type,
                       String number,
                       String last_updated_epoch,
                       String created_epoch,
                       NPI basic,
                       String[] other_names,
                       List<NPIAddresses> addresses,
                       List<NPITaxonomies> taxonomies,
                       List<NPIIdentifiers> identifiers,
                       String[] practiceLocations,
                       String[] endpoints) {
        this.enumeration_type = enumeration_type;
        this.number = number;
        this.last_updated_epoch = last_updated_epoch;
        this.created_epoch = created_epoch;
        this.basic = basic;
        this.other_names = other_names;
        this.addresses = addresses;
        this.taxonomies = taxonomies;
        this.identifiers = identifiers;
        this.practiceLocations = practiceLocations;
        this.endpoints = endpoints;
    }
}
