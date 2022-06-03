package com.stm.pegelhub.metastore;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stm.pegelhub.metastore.entity.IdentifiableEntity;
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

    private Class<?> getEntityClass(String name) throws ClassNotFoundException {
        return Class.forName("com.stm.pegelhub.metastore.entity." + name);
    }

    @GetMapping("/")
    public ResponseEntity<List<?>> getAllEntities(@PathVariable("class") String entityClass) throws ClassNotFoundException {
        return ResponseEntity.ok(handlerService.getAll(getEntityClass(entityClass)));
    }

    @PostMapping("/")
    public ResponseEntity<?> saveEntity(@PathVariable("class") String entityClass, @RequestBody String objectRaw) throws ClassNotFoundException, IOException {
        ObjectMapper parser = new ObjectMapper();
        Object t = parser.readValue(objectRaw, getEntityClass(entityClass));
        if (t instanceof IdentifiableEntity) {
            ((IdentifiableEntity) t).setId(UUID.randomUUID());
        }
        return ResponseEntity.ok(handlerService.persist(t));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateEntity(@PathVariable("class") String entityClass, @PathVariable("id") String id, @RequestBody String objectRaw) throws ClassNotFoundException, IOException {
        ObjectMapper parser = new ObjectMapper();
        Object t = parser.readValue(objectRaw, getEntityClass(entityClass));
        if (t instanceof IdentifiableEntity) {
            ((IdentifiableEntity) t).setId(UUID.fromString(id));
        }
        return ResponseEntity.ok(handlerService.persist(t));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findEntityById(@PathVariable("class") String entityClass, @PathVariable("id") String id) throws ClassNotFoundException, IOException {
        return ResponseEntity.ok(handlerService.findById(getEntityClass(entityClass), id));
    }

    @DeleteMapping ("/{id}")
    public void deleteEntityById(@PathVariable("class") String entityClass, @PathVariable("id") String id) throws ClassNotFoundException, IOException {
        handlerService.delete(getEntityClass(entityClass), id);
    }
}
