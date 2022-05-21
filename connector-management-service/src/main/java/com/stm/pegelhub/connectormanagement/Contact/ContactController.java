package com.stm.pegelhub.connectormanagement.Contact;

import com.stm.pegelhub.component.base.web.EntityController;
import com.stm.pegelhub.data.Contact;
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
@RequestMapping("/contact")
public class ContactController extends EntityController<Contact> {
    @Operation(summary = "Adds a new Contact to the system")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Returns the added Contact",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Contact.class))})
    })
    @PostMapping("/")
    Contact createContact(@RequestBody Contact contact){
        return super.dataService.save(contact);
    }

    @Operation(summary = "Gets a Contact by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Returns the Contact",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Contact.class))})
    })
    @GetMapping("/{uuid}")
    Contact getContactById(@PathVariable UUID uuid){
        Contact searchObj = new Contact();
        searchObj.setId(uuid);
        return super.dataService.findById(searchObj);
    }

    @Operation(summary = "Gets all Contact")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Returns all Contacts",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Contact.class))})
    })
    @GetMapping("/")
    List<Contact> getAllContacts() {
        return super.dataService.findAll();
    }

    @Operation(summary = "Updates a Contact")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Returns the updated Contact",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Contact.class))})
    })
    @PutMapping("/")
    Contact updateContact(@RequestBody Contact contact){
        return super.dataService.save(contact);
    }

    @Operation(summary = "Deletes a Contact by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200")
    })
    @DeleteMapping("/{uuid:UUID}")
    void deleteContact(@PathVariable UUID uuid){
        super.dataService.delete(getContactById(uuid));
    }
}
