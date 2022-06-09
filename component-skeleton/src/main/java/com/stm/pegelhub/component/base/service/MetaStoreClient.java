package com.stm.pegelhub.component.base.service;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stm.pegelhub.component.base.MetaStoreException;
import com.stm.pegelhub.data.IdentifiableEntity;
import com.stm.pegelhub.data.Error;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class MetaStoreClient {
    @Autowired
    @Qualifier("metaStoreTemplate")
    private RestTemplate connector;

    public <T> String buildUrl(T entity) {
        return buildUrl(entity.getClass());
    }

    public <T> String buildUrl(Class<T> entity) {
        return "http://META-STORE/metastore/" + entity.getSimpleName() + "/";
    }

    public IdentifiableEntity save(IdentifiableEntity data) {
        try {
            if (data.getId() != null) {
                return connector.exchange(
                        buildUrl(data) + data.getId(),
                        HttpMethod.PUT,
                        new HttpEntity<>(data),
                        data.getClass()
                ).getBody();
            } else {
                return connector.exchange(
                        buildUrl(data),
                        HttpMethod.POST,
                        new HttpEntity<>(data),
                        data.getClass()
                ).getBody();
            }
        } catch (Exception e) {
            throw new MetaStoreException(e);
        }
    }

    public Error save(Error data) {
        try {
            if (data.getErrorCode() != null && data.getTakerServiceManufacturer() != null)
                return connector.exchange(
                        buildUrl(data) + data.createKey(),
                        HttpMethod.PUT,
                        new HttpEntity<>(data),
                        data.getClass()
                ).getBody();
            else
                return connector.exchange(
                        buildUrl(data),
                        HttpMethod.POST,
                        new HttpEntity<>(data),
                        data.getClass()
                ).getBody();
        } catch (Exception e) {
            throw new MetaStoreException(e);
        }
    }

    public IdentifiableEntity findById(IdentifiableEntity data) {
        try {
            return connector.getForObject(buildUrl(data) + data.getId(), data.getClass());
        } catch (Exception e) {
            throw new MetaStoreException(e);
        }
    }

    public Error findById(Error data) {
        try {
            return connector.getForObject(buildUrl(data) + data.createKey(), data.getClass());
        } catch (Exception e) {
            throw new MetaStoreException(e);
        }
    }

    private final ObjectMapper mapper = new ObjectMapper();

    public <T> List<T> findAll(Class<T> entityClass) {
        try {
            JavaType type = mapper.getTypeFactory().
                    constructCollectionType(List.class, entityClass);
            String body = connector.exchange(buildUrl(entityClass), HttpMethod.GET, null, String.class).getBody();
            return mapper.readValue(body, type);
        } catch (Exception e) {
            throw new MetaStoreException(e);
        }
    }

    public void delete(IdentifiableEntity data) {
        try {
            connector.delete(buildUrl(data) + data.getId());
        } catch (Exception e) {
            throw new RuntimeException("Cannot delete entity of type " + data.getClass().getSimpleName(), e);
        }
    }

    public void delete(Error data) {
        try {
            connector.delete(buildUrl(data) + data.createKey());
        } catch (Exception e) {
            throw new RuntimeException("Cannot delete entity of type " + data.getClass().getSimpleName(), e);
        }
    }
}
