package com.stm.pegelhub.connectordata.controller;

import com.stm.pegelhub.model.TelemetryData;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/telemetry")
public class TelemetryController {


    @Operation(summary = "Adds a new telemetry data point to the database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Returns the added telemetry data point",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = TelemetryData.class))})
    })
    @PostMapping
    public ResponseEntity createTelemetryData(@RequestBody TelemetryData measurementData) {
        return null;
    }
}
