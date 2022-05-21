package com.stm.pegelhub.connectormanagement.Connector;

import com.stm.pegelhub.component.base.service.EntityService;
import com.stm.pegelhub.data.Connector;
import org.springframework.stereotype.Service;

@Service
public class ConnectorEntityService extends EntityService<Connector> {
    protected ConnectorEntityService() {
        super(Connector.class);
    }
}
