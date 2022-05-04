package com.stm.pegelhub.data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="Station_Manufacturer")
public class StationManufacturer extends  IdentifiableEntity{

    @Column(name= "",nullable = false)
    private String stationManufacturerName;

    @Column(name= "",nullable = false)
    private String stationManufacturerTyp;

    @Column(name= "",nullable = false)
    private String stationManufacturerFirmwareVersion;

    @Column(name= "")
    private String stationRemark;
}
