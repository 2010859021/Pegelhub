package com.stm.pegelhub.connectormanagement.FunctionModule;

import com.stm.pegelhub.component.base.web.EntityController;
import com.stm.pegelhub.data.FunctionModule;
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
@RequestMapping("/api/v1/functionModule")
public class FunctionModuleController extends EntityController<FunctionModule> {
    @Operation(summary = "Adds a new FunctionModule to the system")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Returns the added FunctionModule",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = FunctionModule.class))})
    })
    @PostMapping("/")
    @PreAuthorize("hasRole('PH_USER')")
    FunctionModule createFunctionModule(@RequestBody FunctionModule functionModule){
        return super.dataService.save(functionModule);
    }

    @Operation(summary = "Gets a FunctionModule by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Returns the FunctionModule",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = FunctionModule.class))})
    })
    @GetMapping("/{uuid}")
    @PreAuthorize("hasRole('PH_USER')")
    FunctionModule getFunctionModuleById(@PathVariable UUID uuid){
        FunctionModule searchObj = new FunctionModule();
        searchObj.setId(uuid);
        return super.dataService.findById(searchObj);
    }

    @Operation(summary = "Gets all FunctionModules")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Returns all FunctionModules",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = FunctionModule.class))})
    })
    @GetMapping("/")
    @PreAuthorize("hasRole('PH_USER')")
    List<FunctionModule> getAllFunctionModules() {
        return super.dataService.findAll();
    }

    @Operation(summary = "Updates a FunctionModule")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Returns the updated FunctionModule",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = FunctionModule.class))})
    })
    @PutMapping("/")
    @PreAuthorize("hasRole('PH_USER')")
    FunctionModule updateFunctionModule(@RequestBody FunctionModule functionModule){
        return super.dataService.save(functionModule);
    }

    @Operation(summary = "Deletes a FunctionModule by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200")
    })
    @DeleteMapping("/{uuid:UUID}")
    @PreAuthorize("hasRole('PH_USER')")
    void deleteFunctionModule(@PathVariable UUID uuid){
        super.dataService.delete(getFunctionModuleById(uuid));
    }
}
