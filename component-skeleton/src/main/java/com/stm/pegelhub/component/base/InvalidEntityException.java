package com.stm.pegelhub.component.base;

import com.stm.pegelhub.data.IdentifiableEntity;
import lombok.ToString;

@ToString
public class InvalidEntityException extends RuntimeException {
    private final IdentifiableEntity affectedEntity;

    public InvalidEntityException(IdentifiableEntity affectedEntity) {
        this.affectedEntity = affectedEntity;
    }

    public IdentifiableEntity getAffectedEntity() {
        return affectedEntity;
    }
}
