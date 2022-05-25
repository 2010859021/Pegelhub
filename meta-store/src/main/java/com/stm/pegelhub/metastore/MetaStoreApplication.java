package com.stm.pegelhub.metastore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(
        scanBasePackages = {
                "com.stm.pegelhub.metastore",
                "com.stm.pegelhub.metastore.store"
        }
)
@EntityScan(
        basePackages = {
                "com.stm.pegelhub.metastore.entity"
        }
)
public class MetaStoreApplication {
    public static void main(String[] args) {
        SpringApplication.run(MetaStoreApplication.class, args);
    }
}
