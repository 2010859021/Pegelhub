package com.stm.pegelhub.metastore;

import com.stm.pegelhub.metastore.entity.*;
import com.stm.pegelhub.metastore.entity.Error;
import com.stm.pegelhub.metastore.store.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class EntityHandlerService {
    private Map<Class<? extends IdentifiableEntity>, JpaRepository<? extends IdentifiableEntity, UUID>> baseEntityRepositories;
    private ErrorHandlerService errorHandlerService;

    @Autowired
    public EntityHandlerService(
            ConnectorRepository connectorRepository,
            ContactRepository contactRepository,
            FunctionModuleRepository functionModuleRepository,
            QualityRepository qualityRepository,
            StationManufacturerRepository stationManufacturerRepository,
            SupplierRepository supplierRepository,
            TakerRepository takerRepository,
            TakerServiceManufacturerRepository takerServiceManufacturerRepository,
            ErrorHandlerService errorHandlerService
    ) {
        this.errorHandlerService = errorHandlerService;
        this.baseEntityRepositories = Map.of(
                Connector.class, connectorRepository,
                Contact.class, contactRepository,
                FunctionModule.class, functionModuleRepository,
                Quality.class, qualityRepository,
                StationManufacturer.class, stationManufacturerRepository,
                Supplier.class, supplierRepository,
                Taker.class, takerRepository,
                TakerServiceManufacturer.class, takerServiceManufacturerRepository
        );
    }

    public List<?> getAll(Class<?> entityClass) {
        if (baseEntityRepositories.containsKey(entityClass)) {
            return baseEntityRepositories.get(entityClass).findAll();
        }

        if (Error.class.isAssignableFrom(entityClass)) {
            return errorHandlerService.getAll();
        }

        return new ArrayList<>();
    }

    public <T> T findById(Class<T> type, String id) {
        if (Error.class.isAssignableFrom(type)) {
            return (T) errorHandlerService.get(id);
        }

        return (T) baseEntityRepositories.get(type).findById(UUID.fromString(id)).orElse(null);
    }

    public <T> T persist(T t) {
        if (t == null) {
            throw new RuntimeException("Cannot save null object!");
        }

        if (Error.class.isAssignableFrom(t.getClass())) {
            return (T) errorHandlerService.save((Error) t);
        }

        JpaRepository<T, UUID> repository = (JpaRepository<T, UUID>) baseEntityRepositories.get(t.getClass());
        return repository.save(t);
    }

    public void delete(Class<?> type, String idToDelete) {
        if (baseEntityRepositories.containsKey(type)) {
            baseEntityRepositories.get(type).deleteById(UUID.fromString(idToDelete));
        }

        if (Error.class.isAssignableFrom(type)) {
            errorHandlerService.delete(idToDelete);
        }
    }
}
