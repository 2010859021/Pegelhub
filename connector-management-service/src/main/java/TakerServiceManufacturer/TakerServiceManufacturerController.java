package TakerServiceManufacturer;

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

import java.util.UUID;

@RestController
@RequestMapping("/takerServiceManufacturer")
public class TakerServiceManufacturerController extends EntityController<TakerServiceManufacturer> {
    @Operation(summary = "Adds a new TakerServiceManufacturer to the system")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Returns the added TakerServiceManufacturer",
                content = { @Content(mediaType = "application/json", schema = @Schema(implementation = TakerServiceManufacturer.class))})
    })
    @PostMapping("/")
    Mono<TakerServiceManufacturer> createTakerServiceManufacturer(@RequestBody TakerServiceManufacturer takerServiceManufacturer){
        return super.dataService.save(takerServiceManufacturer);
    }

    @Operation(summary = "Gets a TakerServiceManufacturer by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Returns the TakerServiceManufacturer",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = TakerServiceManufacturer.class))})
    })
    @GetMapping("/{uuid}")
    TakerServiceManufacturer getTakerServiceManufacturerById(@PathVariable UUID uuid){
        TakerServiceManufacturer searchObj = new TakerServiceManufacturer();
        searchObj.setId(uuid);
        return super.dataService.findById(searchObj).block();
    }

    @Operation(summary = "Gets all TakerServiceManufacturers")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Returns all TakerServiceManufacturers",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = TakerServiceManufacturer.class))})
    })
    @GetMapping("/")
    Flux<TakerServiceManufacturer> getAllTakerServiceManufacturers() {
        return super.dataService.findAll();
    }

    @Operation(summary = "Updates a TakerServiceManufacturer")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Returns the updated TakerServiceManufacturer",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = TakerServiceManufacturer.class))})
    })
    @PutMapping("/")
    Mono<TakerServiceManufacturer> updateTakerServiceManufacturer(@RequestBody TakerServiceManufacturer takerServiceManufacturer){
        return super.dataService.save(takerServiceManufacturer);
    }

    @Operation(summary = "Deletes a TakerServiceManufacturer by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200")
    })
    @DeleteMapping("/{uuid:UUID}")
    void deleteTakerServiceManufacturer(@PathVariable UUID uuid){
        super.dataService.delete(getTakerServiceManufacturerById(uuid));
    }
}
