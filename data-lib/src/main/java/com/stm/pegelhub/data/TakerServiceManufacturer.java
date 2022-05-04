package com.stm.pegelhub.data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="Taker_Service_Manufacturer")
public class TakerServiceManufacturer extends  IdentifiableEntity{

    @Column(name="taker_manufacturer_name", nullable = false)
    private String takerManufacturerName;

    //nur sure about the datatype, feedback from johannes is outstanding
    @Column(name= "", nullable = false)
    private String service;

    @Column(name= "", nullable = false)
    private String takerSystemName;

    @Column(name= "",nullable = false)
    private String stationManufacturerFirmwareVersion;

    @Column(name= "")
    private String requestRemark;
}
