package com.stm.pegelhub.controller;

import com.influxdb.exceptions.NotFoundException;
import com.stm.pegelhub.model.MeasurementData;
import com.stm.pegelhub.model.TelemetryData;
import com.stm.pegelhub.service.MeasurementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/datastore/measurement")
public class MeasurementController {

    @Autowired
    MeasurementService service;

    @GetMapping(path = "/{range}")
    public ResponseEntity getAllMeasurementData(@PathVariable String range) {
        return ResponseEntity.ok(this.service.queryData(range));
    }

    @GetMapping(path = "/last/{uuiId}")
    public ResponseEntity getLastMeasurement(@PathVariable String uuiId) {

        try {
            return ResponseEntity.ok(this.service.queryLastData(uuiId));

        } catch (NotFoundException exception) {
            return ResponseEntity.status(404).body(exception.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity writeMeasurementData(@RequestBody MeasurementData measurementData) {

        MeasurementData responseDataPoint = service.writeDataPoint(measurementData);
        return ResponseEntity.ok(responseDataPoint);
    }
}
