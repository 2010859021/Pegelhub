package com.stm.pegelhub.data;

import javax.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="StationManufacturer")
public class StationManufacturer extends  IdentifiableEntity{

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
