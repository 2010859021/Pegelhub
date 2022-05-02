package com.stm.pegelhub.component.base.web;

import com.stm.pegelhub.component.base.service.EntityService;
import com.stm.pegelhub.data.IdentifiableEntity;
import org.springframework.beans.factory.annotation.Autowired;

public class EntityController<T extends IdentifiableEntity> {
    @Autowired
    protected EntityService<T> dataService;
}
