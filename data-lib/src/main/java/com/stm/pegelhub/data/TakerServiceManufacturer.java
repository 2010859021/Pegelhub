package com.stm.pegelhub.data;

import lombok.Data;

import java.util.UUID;

@Data
public class TakerServiceManufacturer extends  IdentifiableEntity{
    private String takerManufacturerName;
    private String service;
    private String takerSystemName;
    private String stationManufacturerFirmwareVersion;
    private String requestRemark;

    public TakerServiceManufacturer(String uuid) {
        setId(UUID.fromString(uuid));
    }

    public TakerServiceManufacturer() {
    }
}
