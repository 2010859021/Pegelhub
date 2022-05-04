package com.stm.pegelhub.data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="Quality")
public class Quality extends  IdentifiableEntity{

    @Column(name= "",nullable = false)
    private Double qualityCode;

    @Column(name= "",nullable = false)
    private Double plaintext;
}
