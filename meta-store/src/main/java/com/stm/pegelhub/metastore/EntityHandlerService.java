package com.stm.pegelhub.metastore;

import com.stm.pegelhub.metastore.entity.*;
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

    @Autowired
    public EntityHandlerService(
            ConnectorRepository connectorRepository,
            ContactRepository contactRepository,
            FunctionModuleRepository functionModuleRepository,
            QualityRepository qualityRepository,
            StationManufacturerRepository stationManufacturerRepository,
            SupplierRepository supplierRepository,
            TakerRepository takerRepository,
            TakerServiceManufacturerRepository takerServiceManufacturerRepository
    ) {
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

        return new ArrayList<>();
    }

    public <T extends IdentifiableEntity> T findById(Class<T> type, UUID id) {
        return (T) baseEntityRepositories.get(type).findById(id).orElse(null);
    }

    public <T extends IdentifiableEntity> T persist(T t) {
        if (t == null) {
            throw new RuntimeException("Cannot save null object!");
        }

        JpaRepository<T, UUID> repository = (JpaRepository<T, UUID>) baseEntityRepositories.get(t.getClass());
        return repository.save(t);
    }

    public void delete(Class<? extends IdentifiableEntity> type, UUID idToDelete) {
        baseEntityRepositories.get(type).deleteById(idToDelete);
    }
}
