package com.stm.pegelhub.metastore.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Data
@Table(name="Quality")
public class Quality extends IdentifiableEntity {
    @Column(nullable = false)
    private Integer qualityCode;

    @Column(nullable = false)
    @Lob
    private String plaintext;

    public Quality(String uuid) {
        setId(UUID.fromString(uuid));
    }

    public Quality() {
    }
}
