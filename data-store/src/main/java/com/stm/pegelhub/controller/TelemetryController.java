package com.stm.pegelhub.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.influxdb.exceptions.NotFoundException;
import com.stm.pegelhub.data.IdentifiableEntity;
import com.stm.pegelhub.model.TelemetryData;
import com.stm.pegelhub.service.TelemetryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.time.Instant;
import java.util.List;


@RestController
@RequestMapping("/datastore/telemetry")
public class TelemetryController {

    @Autowired
    TelemetryService service;

    @GetMapping(path = "/{range}")
    public ResponseEntity getAllTelemetryData(@PathVariable String range) {

        return ResponseEntity.ok(this.service.queryData(range));
    }

    @GetMapping(path = "/last/{uuiId}")
    public ResponseEntity getLastTelemetry(@PathVariable String uuiId) {

        try {
            return ResponseEntity.ok(this.service.queryLastData(uuiId));

        } catch (NotFoundException exception) {
            return ResponseEntity.status(404).body(exception.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity writeTelemetryData(@RequestBody TelemetryData telemetryData) {

        TelemetryData responseDataPoint = service.writeTelemetryData(telemetryData);

        if(responseDataPoint == null){
            return ResponseEntity.status(400).body("Failed to post");
        }
        return ResponseEntity.ok(responseDataPoint);
    }
}
