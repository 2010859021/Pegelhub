package com.stm.pegelhub.connectordata.controller;

import com.stm.pegelhub.model.MeasurementData;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/measurement")
public class MeasurementController {


    @Operation(summary = "Adds a new measurement data point to the database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Returns the added measurement data point",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = MeasurementData.class))})
    })
    @PostMapping
    public ResponseEntity createMeasurementData(@RequestBody MeasurementData measurementData) {
        return null;
    }
}
