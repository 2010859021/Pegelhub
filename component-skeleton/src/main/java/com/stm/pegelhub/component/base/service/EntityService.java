package com.stm.pegelhub.component.base.service;

import com.stm.pegelhub.component.base.InvalidEntityException;
import com.stm.pegelhub.data.IdentifiableEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public abstract class EntityService<T extends IdentifiableEntity> {
    @Autowired
    protected MetaStoreClient repository;

    protected final Class<T> tClass;

    protected EntityService(Class<T> tClass) {
        this.tClass = tClass;
    }

    /**
     * A general validation method to check the entities fields and validity before every call to the meta persistence
     * layer.
     *
     * @param entity The entity to be checked
     * @return true if the given entity is valid, false otherwise
     */
    protected boolean validateEntityForPersist(T entity) {
        return true;
    }

    /**
     * A before persist finalizer to handle internal dependencies or anything that needs to be done in advance.
     *
     * @param entity The entity for finalization
     */
    protected void onBeforeSave(T entity) {
    }

    /**
     * A after persist finalizer to handle internal dependencies or anything that needs to be done after successful
     * execution.
     *
     * @param entity The entity for finalization
     */
    protected void onAfterSave(T entity) {
    }

    /**
     * Save method to send the entity to persistence layer.
     *
     * @param entity The entity to be persisted
     * @return The returned entity from persistence layer
     */
    public final T save(T entity) {
        if (validateEntityForPersist(entity)) {
            onBeforeSave(entity);
            T t = (T) repository.save(entity);
            onAfterSave(t);
            return t;
        }
        throw new InvalidEntityException(entity);
    }

    /**
     * A before delete finalizer to handle internal dependencies or anything that needs to be done in advance.
     *
     * @param entity The entity for finalization
     */
    protected void onBeforeDelete(T entity) {
    }

    /**
     * A after delete finalizer to handle internal dependencies or anything that needs to be done after successful
     * execution.
     *
     * @param entity The entity for finalization
     */
    protected void onAfterDelete(T entity) {
    }

    /**
     * Delete method to send the entity to the persistence layer for deletion.
     *
     * @param entity The entity to be deleted
     */
    public final void delete(T entity) {
        if (validateEntityForPersist(entity)) {
            onBeforeSave(entity);
            repository.delete(entity);
            onAfterSave(entity);
        }
        throw new InvalidEntityException(entity);
    }

    /**
     * Find entity in persistence layer by id.
     *
     * @param entity The entity holding its id
     * @return The returned entity from persistence layer
     */
    public final T findById(T entity) {
        return (T) repository.findById(entity);
    }

    /**
     * Find entity in persistence layer by id.
     *
     * @return The returned entity from persistence layer
     */
    public final List<T> findAll() {
        return repository.findAll(tClass);
    }
}
