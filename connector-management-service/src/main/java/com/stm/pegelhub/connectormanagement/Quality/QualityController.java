package com.stm.pegelhub.connectormanagement.Quality;

import com.stm.pegelhub.component.base.web.EntityController;
import com.stm.pegelhub.data.Quality;
import com.stm.pegelhub.data.Supplier;
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
@RequestMapping("/api/v1/quality")
public class QualityController extends EntityController<Quality> {
    @Operation(summary = "Adds a new Quality to the system")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Returns the added Quality",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Quality.class))})
    })
    @PostMapping("/")
    @PreAuthorize("hasRole('PH_USER')")
    Quality createQuality(@RequestBody Quality quality){
        return super.dataService.save(quality);
    }

    @Operation(summary = "Gets a Quality by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Returns the Quality",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Quality.class))})
    })
    @GetMapping("/{uuid}")
    @PreAuthorize("hasRole('PH_USER')")
    Quality getQualityById(@PathVariable UUID uuid){
        Quality searchObj = new Quality();
        searchObj.setId(uuid);
        return super.dataService.findById(searchObj);
    }

    @Operation(summary = "Gets all Qualities")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Returns all Qualitiess",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Quality.class))})
    })
    @GetMapping("/")
    @PreAuthorize("hasRole('PH_USER')")
    List<Quality> getAllQualities() {
        return super.dataService.findAll();
    }

    @Operation(summary = "Updates a Quality")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Returns the updated Quality",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Quality.class))})
    })
    @PutMapping("/")
    @PreAuthorize("hasRole('PH_USER')")
    Quality updateQuality(@RequestBody Quality quality){
        return super.dataService.save(quality);
    }

    @Operation(summary = "Deletes a Quality by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200")
    })
    @DeleteMapping("/{uuid:UUID}")
    @PreAuthorize("hasRole('PH_USER')")
    void deleteQuality(@PathVariable UUID uuid){
        super.dataService.delete(getQualityById(uuid));
    }
}
