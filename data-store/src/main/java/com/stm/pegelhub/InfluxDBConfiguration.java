package com.stm.pegelhub;

import com.influxdb.client.InfluxDBClient;
import com.influxdb.client.InfluxDBClientFactory;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "datasource")
@Data
public class InfluxDBConfiguration {
    private DBProps telemetry;
    private DBProps data;

    @Bean("telemetryClient")
    public InfluxDBClient telemetryClient() {
        return telemetry.createClient();
    }

    @Bean("dataClient")
    public InfluxDBClient dataClient() {
        return data.createClient();
    }

    @Bean("telemetryConfiguration")
    public DBProps telemetryConfiguration() {
        return this.telemetry;
    }

    @Bean("dataConfiguration")
    public DBProps dataConfiguration() {
        return this.data;
    }

    @Data
    public static class DBProps {
        private String url;
        private String org;
        private String bucket;
        private String token;

        private InfluxDBClient createClient() {
            return InfluxDBClientFactory.create(url, token.toCharArray(), org, bucket);
        }
    }
}
