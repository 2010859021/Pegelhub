package com.stm.pegelhub.connectormanagement.Supplier;

import com.stm.pegelhub.component.base.web.EntityController;
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
@RequestMapping("/supplier")
public class SupplierController extends EntityController<Supplier> {
    @Operation(summary = "Adds a new Supplier to the system")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Returns the added Supplier",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Supplier.class))})
    })
    @PostMapping("/")
    Supplier createSupplier(@RequestBody Supplier supplier) {
        return super.dataService.save(supplier);
    }

    @Operation(summary = "Gets a Supplier by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Returns the Supplier",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Supplier.class))})
    })
    @GetMapping("/{uuid}")
    Supplier getSupplierById(@PathVariable UUID uuid) {
        Supplier searchObj = new Supplier();
        searchObj.setId(uuid);
        return super.dataService.findById(searchObj);
    }

    @Operation(summary = "Gets all Suppliers")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Returns all Suppliers",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Supplier.class))})
    })
    @GetMapping("/")
    List<Supplier> getAllSuppliers() {
        return super.dataService.findAll();
    }

    @Operation(summary = "Updates a Supplier")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Returns the updated Supplier",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Supplier.class))})
    })
    @PutMapping("/")
    Supplier updateSupplier(@RequestBody Supplier supplier) {
        return super.dataService.save(supplier);
    }

    @Operation(summary = "Deletes a Supplier by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200")
    })
    @DeleteMapping("/{uuid:UUID}")
    void deleteSupplier(@PathVariable UUID uuid) {
        super.dataService.delete(getSupplierById(uuid));
    }
}
