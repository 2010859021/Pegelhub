package com.stm.pegelhub;


import com.influxdb.annotations.Column;
import com.influxdb.annotations.Measurement;
import lombok.Data;

import java.time.Instant;
import java.util.Date;
import java.util.UUID;

@Data
@Measurement(name = "measurementData")
public class MeasurementData {

    @Column(tag = true)
    private UUID id;

    @Column(timestamp = true)
    private Instant timestamp;

    @Column(tag = true)
    private String timetype;

    @Column(tag = true)
    private String errorCode;

    @Column(tag = true)
    private String channelUse;

    @Column(tag = true)
    private String quality;

    @Column(tag = true)
    private String typ;

    @Column
    private Double value;
}
