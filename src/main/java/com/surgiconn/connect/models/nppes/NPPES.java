package com.surgiconn.connect.models.nppes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.surgiconn.connect.globalconfigs.AuditModel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Setter
@Getter

public class NPPES implements Serializable {

    private int result_count;

    private List<NPPESResult> results;

    public NPPES() {
    }

    public NPPES(int result_count, List<NPPESResult> results) {
        this.result_count = result_count;
        this.results = results;
    }

}
