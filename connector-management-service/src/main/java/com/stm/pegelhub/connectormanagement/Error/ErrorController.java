package com.stm.pegelhub.connectormanagement.Error;

import com.stm.pegelhub.data.Error;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/error")
public class ErrorController {
    @Autowired
    ErrorService errorService;

    @GetMapping("/")
    public List<Error> findAll() {
        return errorService.findAll();
    }

    @PostMapping("/")
    public Error createError(@RequestBody Error error) {
        return errorService.save(error);
    }

    @GetMapping("/{id}")
    public Error getError(@PathVariable String id) {
        return errorService.findById(id);
    }

    @PutMapping("/{id}")
    public void updateError(@RequestBody Error error, @PathVariable String id) {
        error.updateFromId(id);
        errorService.save(error);
    }

    @DeleteMapping("/{id}")
    public void deleteError(@PathVariable String id) {
        errorService.delete(Error.createFromId(id));
    }
}
