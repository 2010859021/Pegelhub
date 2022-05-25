package com.stm.pegelhub.metastore.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;
import java.util.UUID;

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

    public StationManufacturer(String uuid) {
        setId(UUID.fromString(uuid));
    }

    public StationManufacturer() {
    }
}
