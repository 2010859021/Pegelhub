package com.stm.pegelhub;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "influxDB")
@Data
public class InfluxDBConfiguration {

    private String url;
    private String org;
    private String bucket;
    private String token;
}
