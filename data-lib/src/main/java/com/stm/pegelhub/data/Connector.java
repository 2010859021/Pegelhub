package com.stm.pegelhub.data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
@Table(name="Connector")
public class Connector extends  IdentifiableEntity{

    //FK to contact table
    @Column(name= "", nullable = false)
   private UUID manufacturerId;

    @Column(name= "", nullable = false)
    private String typeDescription;

    @Column(name= "", nullable = false)
    private Double softwareVersion;

    @Column(name= "", nullable = false)
    private Double worksFromDataVersion;

    @Column(name= "", nullable = false)
    private String dataDefinition;

    //FK to contact table
    @Column(name= "", nullable = false)
    private UUID softwareManufacturerId;

    //FK to contact table
    @Column(name= "", nullable = false)
    private UUID technicallyResponsibleId;

    //FK to contact table
    @Column(name= "", nullable = false)
    private UUID operatingCompanyId;

    @Column(name= "")
    private String nodes;

}
