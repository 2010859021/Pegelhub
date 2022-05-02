package com.stm.pegelhub.component;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
        scanBasePackages = "com.stm.pegelhub"
)
public class ComponentApplication {
    public static void main(String[] args) {
        SpringApplication.run(ComponentApplication.class, args);
    }
}
