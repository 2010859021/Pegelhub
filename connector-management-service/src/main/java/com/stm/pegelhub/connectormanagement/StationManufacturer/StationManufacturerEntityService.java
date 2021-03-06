package com.stm.pegelhub.connectormanagement.StationManufacturer;

import com.stm.pegelhub.component.base.service.EntityService;
import com.stm.pegelhub.data.StationManufacturer;
import org.springframework.stereotype.Service;

@Service
public class StationManufacturerEntityService extends EntityService<StationManufacturer> {
    protected StationManufacturerEntityService() {
        super(StationManufacturer.class);
    }
}
