package com.stm.pegelhub.metastore.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Data
@Table(name="Quality")
public class Quality extends IdentifiableEntity {
    @Column(nullable = false)
    private Integer qualityCode;

    @Column(nullable = false)
    @Lob
    private String plaintext;
}
