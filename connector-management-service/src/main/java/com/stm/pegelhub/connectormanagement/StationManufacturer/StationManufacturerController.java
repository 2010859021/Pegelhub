package com.stm.pegelhub.connectormanagement.StationManufacturer;

import com.stm.pegelhub.component.base.web.EntityController;
import com.stm.pegelhub.data.StationManufacturer;
import com.stm.pegelhub.data.TakerServiceManufacturer;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/stationManufacturer")
public class StationManufacturerController extends EntityController<StationManufacturer> {
    @Operation(summary = "Adds a new StationManufacturer to the system")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Returns the added StationManufacturer",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = StationManufacturer.class))})
    })
    @PostMapping("/")
    @PreAuthorize("hasRole('PH_USER')")
    StationManufacturer createStationManufacturer(@RequestBody StationManufacturer stationManufacturer){
        return super.dataService.save(stationManufacturer);
    }

    @Operation(summary = "Gets a StationManufacturer by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Returns the StationManufacturer",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = StationManufacturer.class))})
    })
    @GetMapping("/{uuid}")
    @PreAuthorize("hasRole('PH_USER')")
    StationManufacturer getStationManufacturerById(@PathVariable UUID uuid){
        StationManufacturer searchObj = new StationManufacturer();
        searchObj.setId(uuid);
        return super.dataService.findById(searchObj);
    }

    @Operation(summary = "Gets all StationManufacturers")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Returns all StationManufacturers",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = StationManufacturer.class))})
    })
    @GetMapping("/")
    @PreAuthorize("hasRole('PH_USER')")
    List<StationManufacturer> getAllStationManufacturer() {
        return super.dataService.findAll();
    }

    @Operation(summary = "Updates a StationManufacturer")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Returns the updated StationManufacturer",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = StationManufacturer.class))})
    })
    @PutMapping("/")
    @PreAuthorize("hasRole('PH_USER')")
    StationManufacturer updateStationManufacturer(@RequestBody StationManufacturer stationManufacturer){
        return super.dataService.save(stationManufacturer);
    }

    @Operation(summary = "Deletes a StationManufacturer by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200")
    })
    @DeleteMapping("/{uuid:UUID}")
    @PreAuthorize("hasRole('PH_USER')")
    void deleteStationManufacturer(@PathVariable UUID uuid){
        super.dataService.delete(getStationManufacturerById(uuid));
    }
}
