package com.stm.pegelhub.connectormanagement.Error;

import com.stm.pegelhub.component.base.service.MetaStoreClient;
import com.stm.pegelhub.data.Error;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ErrorService {
    @Autowired private MetaStoreClient client;

    public Error findById(String id) {
        return client.findById(Error.createFromId(id));
    }

    public List<Error> findAll() {
        return client.findAll(Error.class);
    }

    public Error save(Error error) {
        return client.save(error);
    }

    public void delete(Error id) {
        client.delete(id);
    }
}
