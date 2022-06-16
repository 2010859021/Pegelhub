package com.stm.pegelhub;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.influxdb.client.InfluxDBClient;
import com.influxdb.client.InfluxDBClientFactory;
import lombok.Data;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;

@Configuration
@ConfigurationProperties(prefix = "datasource")
@Data
public class InfluxDBConfiguration {
    private static final Logger logger = LogManager.getLogger(InfluxDBConfiguration.class);

    private DBProps telemetry;
    private DBProps data;

    @PostConstruct
    private void reloadPropertiesFromInfluxFile() {
        if (System.getenv("INFLUX_FILE") != null && !System.getenv("INFLUX_FILE").isEmpty()) {
            logger.info("Reading influx configuration from environmentally given file");
            try {
                ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
                Configuration config = mapper.readValue(
                        new File(System.getenv("INFLUX_FILE")),
                        Configuration.class
                );

                this.telemetry.token = config.telemetry.token;
                this.telemetry.org = config.telemetry.org;
                this.telemetry.bucket = config.telemetry.bucket;
                this.data.token = config.data.token;
                this.data.org = config.data.org;
                this.data.bucket = config.data.bucket;
                logger.info("using alternate influx configuration");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Bean("telemetryClient")
    public InfluxDBClient telemetryClient() {
        logger.trace("creating telemetry client with properties: " + telemetry);
        return telemetry.createClient();
    }

    @Bean("dataClient")
    public InfluxDBClient dataClient() {
        logger.trace("creating data client with properties: " + data);
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

    @Data
    private static final class Configuration {
        private DBProps telemetry;
        private DBProps data;
    }
}
