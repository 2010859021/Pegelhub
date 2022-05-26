package com.stm.pegelhub.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.influxdb.exceptions.NotFoundException;
import com.stm.pegelhub.data.IdentifiableEntity;
import com.stm.pegelhub.model.DataPoint;
import com.stm.pegelhub.service.MeasurementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/datastore/measurement")
public class MeasurementController {

    @Autowired
    MeasurementService service;

    @GetMapping
    public ResponseEntity getAllMeasurementData() {
        try {

            this.service.queryData();
            return ResponseEntity.ok("OK 200");
        } catch (NotFoundException exception) {

            return ResponseEntity.status(404).body(exception.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity writeMeasurementData(@RequestBody DataPoint dataPoint) {

        DataPoint responseDataPoint = service.writeDataPoint(dataPoint);
        return ResponseEntity.ok(responseDataPoint);

    }
}
