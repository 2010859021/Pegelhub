package com.stm.pegelhub.component.base.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.stm.pegelhub.data.IdentifiableEntity;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.Disposable;
import reactor.core.publisher.Mono;

@Service
public class MetaStoreClient {
    @Autowired
    private EurekaClient discoveryClient;

    public String serviceUrl() {
        InstanceInfo instance = discoveryClient.getNextServerFromEureka("META-STORE", false);
        return instance.getHomePageUrl();
    }

    public <T extends IdentifiableEntity> WebClient getClient(T entity) {
        return WebClient
                .builder()
                .baseUrl(serviceUrl() + entity.getClass().getSimpleName())
                .build();
    }

    public Mono<? extends IdentifiableEntity> save(IdentifiableEntity data) {
        try {
            return getClient(data)
                    .post()
                    .uri("/")
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(BodyInserters.fromValue(data))
                    .retrieve()
                    .bodyToMono(data.getClass());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void delete(IdentifiableEntity data) {
        try {
            getClient(data)
                    .delete()
                    .uri("/" + data.getId().toString())
                    .retrieve();
        } catch (Exception e) {
            throw new RuntimeException("Cannot delete entity of type " + data.getClass().getSimpleName(), e);
        }
    }
}
