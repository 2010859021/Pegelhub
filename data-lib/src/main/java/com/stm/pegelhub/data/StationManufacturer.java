package com.stm.pegelhub.data;

import lombok.Data;

@Data
public class StationManufacturer extends  IdentifiableEntity{
    private String stationManufacturerName;
    private String stationManufacturerTyp;
    private String stationManufacturerFirmwareVersion;
    private String stationRemark;
}
