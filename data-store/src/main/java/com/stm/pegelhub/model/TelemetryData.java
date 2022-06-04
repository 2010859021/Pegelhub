package com.stm.pegelhub.model;

import lombok.Data;

import java.time.Instant;
import java.util.Date;
import java.util.UUID;


@Data
public class TelemetryData {

    private String measurement;

    private String stationIPAddressIntern;

    private String stationIPAddressExtern;

    private Date timestamp;

    private Integer cycleTime;

    private Double temperatureWater;

    private Double temperatureAir;

    private Double performanceVoltageBattery;

    private Double performanceVoltageSupply;

    private Double performanceElectricityBattery;

    private Double performanceElectricitySupply;

    private Double fieldStrengthTransmission;

}
