package com.stm.pegelhub.metastore.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;


@Entity
@Data
@Table(name = "Connector")
public class Connector extends IdentifiableEntity {
    @ManyToOne
    @JoinColumn(nullable = false)
    private Contact manufacturer;

    @Column(nullable = false)
    private String typeDescription;

    @Column(nullable = false)
    private Double softwareVersion;

    @Column(nullable = false)
    private Double worksFromDataVersion;

    @Column(nullable = false)
    private String dataDefinition;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Contact softwareManufacturer;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Contact technicallyResponsible;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Contact operatingCompany;

    @Column
    @Lob
    private String nodes;

    public Connector(String uuid) {
        setId(UUID.fromString(uuid));
    }

    public Connector() {
    }
}
