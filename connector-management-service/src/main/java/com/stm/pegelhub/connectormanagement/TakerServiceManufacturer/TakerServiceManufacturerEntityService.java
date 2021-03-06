package com.stm.pegelhub.connectormanagement.TakerServiceManufacturer;

import com.stm.pegelhub.component.base.service.EntityService;
import com.stm.pegelhub.data.TakerServiceManufacturer;
import org.springframework.stereotype.Service;

@Service
public class TakerServiceManufacturerEntityService extends EntityService<TakerServiceManufacturer> {
    protected TakerServiceManufacturerEntityService() {
        super(TakerServiceManufacturer.class);
    }
}
