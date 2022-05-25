package com.stm.pegelhub.data;

import lombok.Data;

import java.util.UUID;

@Data
public class StationManufacturer extends  IdentifiableEntity{
    private String stationManufacturerName;
    private String stationManufacturerTyp;
    private String stationManufacturerFirmwareVersion;
    private String stationRemark;

    public StationManufacturer(String uuid) {
        setId(UUID.fromString(uuid));
    }

    public StationManufacturer() {
    }
}
