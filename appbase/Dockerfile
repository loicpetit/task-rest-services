FROM openjdk:8-jre-alpine

RUN mkdir /app; mkdir /app/config; mkdir /app/logs

WORKDIR /app

ENTRYPOINT [ "/usr/bin/java", "-jar", "task-rest-services.jar" ]
