package com.stm.pegelhub.connectormanagement.Connector;

import com.stm.pegelhub.component.base.web.EntityController;
import com.stm.pegelhub.data.Connector;
import com.stm.pegelhub.data.Supplier;
import com.stm.pegelhub.data.TakerServiceManufacturer;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/connector")
public class ConnectorController extends EntityController<Connector> {
    @Operation(summary = "Adds a new Connector to the system")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Returns the added Connector",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Connector.class))})
    })
    @PostMapping("/")
    Connector createConnector(@RequestBody Connector connector){
        return super.dataService.save(connector);
    }

    @Operation(summary = "Gets a Connector by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Returns the Connector",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Connector.class))})
    })
    @GetMapping("/{uuid}")
    Connector getConnectorById(@PathVariable UUID uuid){
        Connector searchObj = new Connector();
        searchObj.setId(uuid);
        return super.dataService.findById(searchObj);
    }

    @Operation(summary = "Gets all Connectors")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Returns all Connectors",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Connector.class))})
    })
    @GetMapping("/")
    List<Connector> getAllConnectors() {
        return super.dataService.findAll();
    }

    @Operation(summary = "Updates a Connector")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Returns the updated Connector",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Connector.class))})
    })
    @PutMapping("/")
    Connector updateConnector(@RequestBody Connector connector){
        return super.dataService.save(connector);
    }

    @Operation(summary = "Deletes a Connector by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200")
    })
    @DeleteMapping("/{uuid:UUID}")
    void deleteConnector(@PathVariable UUID uuid){
        super.dataService.delete(getConnectorById(uuid));
    }
}
