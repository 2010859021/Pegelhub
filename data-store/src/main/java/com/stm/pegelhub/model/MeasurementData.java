package com.stm.pegelhub.model;

import lombok.Data;

import java.time.Instant;
import java.util.Map;

@Data
public class MeasurementData {

    private String measurement;

    private Instant timestamp;

    private Map<String, Double> fields;

    private  Map<String, String> infos;
}
