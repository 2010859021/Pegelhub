FROM amazoncorretto:17-alpine-full

# Create user and group to downgrade privileges
RUN addgroup -S coreapp && adduser -S coreapp -G coreapp
USER coreapp:coreapp

# RabbitMQ connection
ENV RABBIT_URL=rabbit
ENV RABBIT_USER=""
ENV RABBIT_PASSWORD=""

# authentication configuration
ENV AUTHENTICATION_CLIENT_ID=pegelhub-client
ENV AUTHENTICATION_REALM=master
ENV AUTHENTICATION_BASE_URL=http://authentication:8081/

# Registry configuration
ENV SERVICE_REGISTRY_HOST=registry
ENV SERVICE_REGISTRY=http://$SERVICE_REGISTRY_HOST:8090/eureka
ENV APP_PORT=8080

# Expose configured port
EXPOSE $APP_PORT

WORKDIR /var/lib/application

ADD ./target/app.jar .

CMD java -jar /var/lib/application/app.jar

HEALTHCHECK --interval=30s --timeout=2s --retries=5 --start-period=40s \
  CMD curl --fail --silent localhost:8081/actuator/health | grep UP || exit 1