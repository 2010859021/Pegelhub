package com.stm.pegelhub.data;

import lombok.Data;

@Data
public class TakerServiceManufacturer extends  IdentifiableEntity{
    private String takerManufacturerName;
    private String service;
    private String takerSystemName;
    private String stationManufacturerFirmwareVersion;
    private String requestRemark;
}
