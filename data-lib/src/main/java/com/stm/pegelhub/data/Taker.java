package com.stm.pegelhub.data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
@Table(name="Taker")
public class Taker extends  IdentifiableEntity{

    @Column(name= "",nullable = false)
    private String stationNumber;

    @Column(name= "",nullable = false)
    private Integer stationId;

    @Column(name= "",nullable = false)
    private Integer stationChannel;

    @Column(name= "",nullable = false)
    private String channelUse;

    @Column(name= "",nullable = false)
    private String refreshRate;

    // FK to taker service manufacturer table
    @Column(name= "", nullable = false)
    private UUID takerServiceManufacturerId;

    // FK to connector table
    @Column( name= "",nullable = false)
    private UUID connectorId;

    // FK to contact table
    @Column( name= "")
    private UUID takerContactId;

    // FK to contact table
    @Column( name= "")
    private UUID endUserId;

    // FK to contact table
    @Column( name= "")
    private UUID dataNetworkOperatorId;
}
