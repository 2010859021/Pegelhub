package com.stm.pegelhub.model;

import lombok.Data;

import java.time.Instant;
import java.util.Date;
import java.util.Map;

@Data
public class MeasurementData {

    private String measurement;

    private String timestamp;

    private Map<String, Double> fields;

    private  Map<String, String> infos;
}
