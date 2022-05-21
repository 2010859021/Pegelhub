package com.stm.pegelhub.metastore.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Data
@Table(name="TakerServiceManufacturer")
public class TakerServiceManufacturer extends IdentifiableEntity {

    @Column(nullable = false)
    private String takerManufacturerName;

    //nur sure about the datatype, feedback from johannes is outstanding
    @Column(nullable = false)
    private String service;

    @Column(nullable = false)
    private String takerSystemName;

    @Column(nullable = false)
    private String stationManufacturerFirmwareVersion;

    @Column()
    @Lob
    private String requestRemark;
}
