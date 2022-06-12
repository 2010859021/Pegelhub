package com.stm.pegelhub.connectormanagement.Taker;

import com.stm.pegelhub.component.base.web.EntityController;
import com.stm.pegelhub.data.Supplier;
import com.stm.pegelhub.data.Taker;
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
@RequestMapping("/taker")
public class TakerController extends EntityController<Taker> {
    @Operation(summary = "Adds a new Taker to the system")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Returns the added Taker",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Taker.class))})
    })
    @PostMapping("/")
    @PreAuthorize("hasRole('PH_USER')")
    Taker createTaker(@RequestBody Taker taker){
        return super.dataService.save(taker);
    }

    @Operation(summary = "Gets a Taker by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Returns the Taker",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Taker.class))})
    })
    @GetMapping("/{uuid}")
    @PreAuthorize("hasRole('PH_USER')")
    Taker getTakerById(@PathVariable UUID uuid){
        Taker searchObj = new Taker();
        searchObj.setId(uuid);
        return super.dataService.findById(searchObj);
    }

    @Operation(summary = "Gets all Takers")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Returns all Takers",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Taker.class))})
    })
    @GetMapping("/")
    @PreAuthorize("hasRole('PH_USER')")
    List<Taker> getAllTakers() {
        return super.dataService.findAll();
    }

    @Operation(summary = "Updates a Taker")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Returns the updated Taker",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = TakerServiceManufacturer.class))})
    })
    @PutMapping("/")
    @PreAuthorize("hasRole('PH_USER')")
    Taker updateTaker(@RequestBody Taker taker){
        return super.dataService.save(taker);
    }

    @Operation(summary = "Deletes a Taker by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200")
    })
    @DeleteMapping("/{uuid:UUID}")
    @PreAuthorize("hasRole('PH_USER')")
    void deleteTaker(@PathVariable UUID uuid){
        super.dataService.delete(getTakerById(uuid));
    }
}
