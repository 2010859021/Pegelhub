package com.stm.pegelhub.connectormanagement.Error;

import com.stm.pegelhub.data.Error;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/error")
public class ErrorController {
    @Autowired
    ErrorService errorService;

    @GetMapping("/")
    @PreAuthorize("hasRole('PH_USER')")
    public List<Error> findAll() {
        return errorService.findAll();
    }

    @PostMapping("/")
    @PreAuthorize("hasRole('PH_USER')")
    public Error createError(@RequestBody Error error) {
        return errorService.save(error);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('PH_USER')")
    public Error getError(@PathVariable String id) {
        return errorService.findById(id);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('PH_USER')")
    public void updateError(@RequestBody Error error, @PathVariable String id) {
        error.updateFromId(id);
        errorService.save(error);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('PH_USER')")
    public void deleteError(@PathVariable String id) {
        errorService.delete(Error.createFromId(id));
    }
}
