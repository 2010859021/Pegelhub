package com.stm.pegelhub.metastore;

import com.stm.pegelhub.metastore.entity.Error;
import com.stm.pegelhub.metastore.store.ErrorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ErrorHandlerService {
    @Autowired private ErrorRepository repository;

    private Error.ErrorPrimaryKey createKeyFromString(String id) {
        Error.ErrorPrimaryKey pk = new Error.ErrorPrimaryKey();
        String[] parts = id.split(":");
        pk.setTakerServiceManufacturerId(UUID.fromString(parts[0]));
        pk.setErrorCode(parts[1]);
        return pk;
    }

    public Error get(String id) {
        return repository.findById(createKeyFromString(id)).orElse(null);
    }

    public List<Error> getAll() {
        return repository.findAll();
    }

    public Error save(Error error) {
        System.out.println(error);

        return repository.save(error);
    }

    public void delete(String id) {
        repository.deleteById(createKeyFromString(id));
    }
}
