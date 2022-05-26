package com.stm.pegelhub.model;

import com.influxdb.annotations.Column;

import java.time.Instant;
import java.util.Map;

public class DataPoint {

    @Column(tag = true)
    private String measurement;

    @Column(timestamp = true)
    private Instant timestamp;

    private Map<String, Double> fields;

    private  Map<String, String> infos;
}
