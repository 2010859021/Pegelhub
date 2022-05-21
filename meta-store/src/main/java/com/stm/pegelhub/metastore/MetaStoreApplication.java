package com.stm.pegelhub.metastore;

import com.stm.pegelhub.metastore.store.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Map;
import java.util.UUID;

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
