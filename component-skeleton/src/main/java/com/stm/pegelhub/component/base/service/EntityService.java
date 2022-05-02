package com.stm.pegelhub.component.base.service;

import com.stm.pegelhub.component.base.InvalidEntityException;
import com.stm.pegelhub.data.IdentifiableEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public abstract class EntityService<T extends IdentifiableEntity> {
    @Autowired
    protected MetaStoreClient repository;

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
    public final Mono<T> save(T entity) {
        if (validateEntityForPersist(entity)) {
            onBeforeSave(entity);
            return repository
                    .save(entity)
                    .map(identifiableEntity -> {
                        onAfterSave((T) identifiableEntity);
                        return (T) identifiableEntity;
                    });
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
}
