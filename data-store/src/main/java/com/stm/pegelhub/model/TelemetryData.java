package com.stm.pegelhub.model;

import com.influxdb.annotations.Column;
import com.influxdb.annotations.Measurement;
import lombok.Data;

import java.time.Instant;


@Data
@Measurement(name = "telemetryData")
public class TelemetryData {

    // notwendig?
   // @Column(tag = true)
  //  private UUID id;

    @Column(tag = true)
    private String stationIPAddressIntern;

    @Column(tag = true)
    private String stationIPAddressExtern;

    @Column(timestamp = true)
    private Instant timestamp;

    @Column
    private Integer cycleTime;

    @Column
    private Double temperatureWater;

    @Column
    private Double temperatureAir;

    @Column
    private Double performanceVoltageBattery;

    @Column
    private Double performanceVoltageSupply;

    @Column
    private Double performanceElectricityBattery;

    @Column
    private Double performanceElectricitySupply;

    @Column
    private Double fieldStrengthTransmission;


}
