FROM openjdk:8-jre-alpine

RUN mkdir /app; mkdir /app/config; mkdir /app/logs

WORKDIR /app

COPY target/spring-boot-admin-1.0.0.jar spring-boot-admin.jar

EXPOSE 8081

ENTRYPOINT [ "/usr/bin/java", "-jar", "spring-boot-admin.jar" ]
