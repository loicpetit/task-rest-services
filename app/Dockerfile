FROM openjdk:8-jre-alpine

RUN mkdir app

WORKDIR app

COPY target/task-rest-services-1.0.0.jar task-rest-services.jar

EXPOSE 8080

ENTRYPOINT [ "/usr/bin/java", "-jar", "task-rest-services.jar" ]
