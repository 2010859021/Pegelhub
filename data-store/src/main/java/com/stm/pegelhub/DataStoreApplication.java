package com.stm.pegelhub;

import com.influxdb.client.InfluxDBClient;
import com.influxdb.client.InfluxDBClientFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DataStoreApplication {



    public static void main(String[] args) {
        SpringApplication.run(DataStoreApplication.class, args);
    }
}
