package com.stm.pegelhub.component.base.service;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stm.pegelhub.data.IdentifiableEntity;
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

    public <T extends IdentifiableEntity> String buildUrl(T entity) {
        return buildUrl(entity.getClass());
    }

    public <T extends IdentifiableEntity> String buildUrl(Class<T> entity) {
        return "http://META-STORE/metastore/" + entity.getSimpleName() + "/";
    }

    public IdentifiableEntity save(IdentifiableEntity data) {
        try {
            return connector.exchange(
                    buildUrl(data),
                    data.getId() != null ? HttpMethod.PUT : HttpMethod.POST,
                    new HttpEntity<>(data),
                    data.getClass()
            ).getBody();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public IdentifiableEntity findById(IdentifiableEntity data) {
        try {
            return connector.getForObject(buildUrl(data) + data.getId(), data.getClass());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private final ObjectMapper mapper = new ObjectMapper();

    public <T extends IdentifiableEntity> List<T> findAll(Class<T> entityClass) {
        try {
            JavaType type = mapper.getTypeFactory().
                    constructCollectionType(List.class, entityClass);
            String body = connector.exchange(buildUrl(entityClass), HttpMethod.GET, null, String.class).getBody();
            return mapper.readValue(body, type);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void delete(IdentifiableEntity data) {
        try {
            connector.delete(buildUrl(data) + data.getId());
        } catch (Exception e) {
            throw new RuntimeException("Cannot delete entity of type " + data.getClass().getSimpleName(), e);
        }
    }
}
