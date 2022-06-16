FROM amazoncorretto:17-alpine-full

# Create user and group to downgrade privileges
RUN addgroup -S coreapp && adduser -S coreapp -G coreapp
USER coreapp:coreapp

# RabbitMQ connection
ENV RABBIT_URL=rabbit \
    RABBIT_USER="" \
    RABBIT_PASSWORD=""

# Registry configuration
ENV SERVICE_REGISTRY_HOST=registry
ENV SERVICE_REGISTRY=http://$SERVICE_REGISTRY_HOST:8090/eureka
ENV APP_PORT=8080

# Datasource configuration
ENV DB_PASSWORD=null \
    DB_HOST=pegelhub-meta:5432 \
    DB_DATABASE=pegelhub \
    DB_URI=$DB_HOST/$DB_DATABASE \
    DB_USER=postgres

# Expose configured port
EXPOSE $APP_PORT

WORKDIR /var/lib/application

ADD ./target/app.jar .

CMD java -jar /var/lib/application/app.jar

HEALTHCHECK --interval=30s --timeout=2s --retries=5 --start-period=40s \
  CMD curl --fail --silent localhost:8081/actuator/health | grep UP || exit 1