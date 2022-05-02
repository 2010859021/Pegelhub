package com.stm.pegelhub.component.configuration;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;

import java.util.List;

@Configuration
@ConfigurationProperties(prefix = "security")
public class SecurityConfiguration {
    enum MethodMapping {
        GET(HttpMethod.GET),
        POST(HttpMethod.POST),
        PUT(HttpMethod.PUT),
        DELETE(HttpMethod.DELETE),
        HEAD(HttpMethod.HEAD),
        OPTIONS(HttpMethod.OPTIONS),
        TRACE(HttpMethod.TRACE),
        PATCH(HttpMethod.PATCH);

        private final HttpMethod method;

        MethodMapping(HttpMethod method) {
            this.method = method;
        }

        public HttpMethod getMethod() {
            return method;
        }
    }

    @Data
    static final class Config {
        private String path;
        private String role;
        private MethodMapping method;
        private Boolean permit;

        public boolean hasMethod() {
            return method != null;
        }

        public HttpMethod getHttpMethod() {
            return method != null ? method.getMethod() : null;
        }
    }

    @Getter
    @Setter
    private List<Config> configurations;
}
