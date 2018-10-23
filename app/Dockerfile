FROM portepoisse/task-rest-services-base:latest

ARG BUILD_DATE
ARG BUILD_VERSION

LABEL maintainer PETIT LOIC

LABEL org.label-schema.schema-version="1.0"
LABEL org.label-schema.build-date=$BUILD_DATE
LABEL org.label-schema.name="portepoisse/task-rest-services"
LABEL org.label-schema.description="Rest services built with Spring to manage task list"
LABEL org.label-schema.vcs-url="https://github.com/loicpetit/task-rest-services"
LABEL org.label-schema.version=$BUILD_VERSION
LABEL org.label-schema.docker.cmd="docker run -p 8080:8080 -v task-rest-services-logs:/app/logs/ -d portepoisse/task-rest-services"

COPY target/task-rest-services-1.0.0.jar task-rest-services.jar

EXPOSE 8080

CMD [ "--spring.profiles.active=docker,dockeradmin" ]
