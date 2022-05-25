package com.stm.pegelhub.component.configuration;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class StoreConfiguration {
    @Bean(name = "metaStoreTemplate") @LoadBalanced
    public RestTemplate metaStoreTemplate() {
        return new RestTemplate();
    }
}
