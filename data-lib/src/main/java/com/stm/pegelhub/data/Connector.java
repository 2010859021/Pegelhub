package com.stm.pegelhub.data;

import javax.persistence.*;
import lombok.Data;


@Entity
@Data
@Table(name = "Connector")
public class Connector extends IdentifiableEntity {


    @ManyToOne
    @JoinColumn(nullable = false)
    private Contact manufacturerId;

    @Column(name = "", nullable = false)
    private String typeDescription;

    @Column(name = "", nullable = false)
    private Double softwareVersion;

    @Column(name = "", nullable = false)
    private Double worksFromDataVersion;

    @Column(name = "", nullable = false)
    private String dataDefinition;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Contact softwareManufacturerId;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Contact technicallyResponsibleId;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Contact operatingCompanyId;

    @Column(name = "")
    @Lob
    private String nodes;

}
