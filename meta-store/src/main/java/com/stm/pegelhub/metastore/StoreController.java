package com.stm.pegelhub.metastore;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stm.pegelhub.data.IdentifiableEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/metastore/{class}")
public class StoreController {
    @Autowired
    private EntityHandlerService handlerService;

    private Class<? extends IdentifiableEntity> getEntityClass(String name) throws ClassNotFoundException {
        return (Class<? extends IdentifiableEntity>) Class.forName("com.stm.pegelhub.data." + name);
    }

    @GetMapping("/")
    public ResponseEntity<List<?>> getAllEntities(@PathVariable("class") String entityClass) throws ClassNotFoundException {
        return ResponseEntity.ok(handlerService.getAll(getEntityClass(entityClass)));
    }

    @PostMapping("/")
    public ResponseEntity<? extends IdentifiableEntity> saveEntity(@PathVariable("class") String entityClass, @RequestBody String objectRaw) throws ClassNotFoundException, IOException {
        ObjectMapper parser = new ObjectMapper();
        IdentifiableEntity t = (IdentifiableEntity) parser.readValue(objectRaw, getEntityClass(entityClass));
        t.setId(UUID.randomUUID());
        return ResponseEntity.ok(handlerService.persist(t));
    }
}
