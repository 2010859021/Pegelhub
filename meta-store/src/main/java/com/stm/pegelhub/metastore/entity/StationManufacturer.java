package com.stm.pegelhub.metastore.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Data
@Table(name="StationManufacturer")
public class StationManufacturer extends IdentifiableEntity {

    @Column(nullable = false)
    private String stationManufacturerName;

    @Column(nullable = false)
    private String stationManufacturerTyp;

    @Column(nullable = false)
    private String stationManufacturerFirmwareVersion;

    @Column()
    @Lob
    private String stationRemark;
}
