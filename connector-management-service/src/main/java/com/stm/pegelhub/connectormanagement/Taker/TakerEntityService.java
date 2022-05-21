package com.stm.pegelhub.connectormanagement.Taker;

import com.stm.pegelhub.component.base.service.EntityService;
import com.stm.pegelhub.data.Taker;
import org.springframework.stereotype.Service;

@Service
public class TakerEntityService extends EntityService<Taker> {
    protected TakerEntityService() {
        super(Taker.class);
    }
}
