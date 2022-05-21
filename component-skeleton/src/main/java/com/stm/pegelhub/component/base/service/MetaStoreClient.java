package com.stm.pegelhub.component.base.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.stm.pegelhub.data.IdentifiableEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import reactor.core.Disposable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class MetaStoreClient {
    @Autowired
    private EurekaClient discoveryClient;

    @Autowired
    private RestTemplate connector;

    public String serviceUrl() {
        InstanceInfo instance = discoveryClient.getNextServerFromEureka("META-STORE", false);
        return instance.getHomePageUrl() + "/metastore/";
    }

    public <T extends IdentifiableEntity> String buildUrl(T entity) {
        return buildUrl(entity.getClass());
    }

    public <T extends IdentifiableEntity> String buildUrl(Class<T> entity) {
        return "http://META-STORE/metastore/" + entity.getSimpleName() + "/";
        //return serviceUrl() + entity.getSimpleName();
    }

    public IdentifiableEntity save(IdentifiableEntity data) {
        try {
            return connector.exchange(
                    buildUrl(data),
                    data.getId() != null ? HttpMethod.PUT : HttpMethod.POST,
                    new HttpEntity<>(data),
                    data.getClass()
            ).getBody();
//                    .post()
//                    .uri("/")
//                    .contentType(MediaType.APPLICATION_JSON)
//                    .body(BodyInserters.fromValue(data))
//                    .retrieve()
//                    .bodyToMono(data.getClass());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public IdentifiableEntity findById(IdentifiableEntity data) {
        try {
            return connector.getForObject(buildUrl(data) + data.getId(), data.getClass());
//            return getClient(data)
//                    .get()
//                    .uri("/" + data.getId())
//                    .retrieve()
//                    .bodyToMono(data.getClass());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

//    public TypeReference<List<? extends IdentifiableEntity>> decodeListType(Class<? extends IdentifiableEntity> type) {
//        switch (type) {
//            case
//        }
//    }
//
    private ObjectMapper mapper = new ObjectMapper();

    public <T extends IdentifiableEntity> List<T> findAll(Class<T> entityClass) {
        try {
            JavaType type = mapper.getTypeFactory().
                    constructCollectionType(List.class, entityClass);
            String body = connector.exchange(buildUrl(entityClass), HttpMethod.GET, null, String.class).getBody();
            return mapper.readValue(body, type);
//            return getClient(entityClass)
//                    .get()
//                    .uri("/")
//                    .retrieve()
//                    .bodyToFlux(entityClass);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void delete(IdentifiableEntity data) {
        try {
            connector.delete(buildUrl(data) + data.getId());
//            getClient(data)
//                    .delete()
//                    .uri("/" + data.getId().toString())
//                    .retrieve();
        } catch (Exception e) {
            throw new RuntimeException("Cannot delete entity of type " + data.getClass().getSimpleName(), e);
        }
    }
}
