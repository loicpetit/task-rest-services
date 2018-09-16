FROM portepoisse/task-rest-services-base:latest

COPY target/task-rest-services-1.0.0.jar task-rest-services.jar

EXPOSE 8080

CMD [ "--spring.profiles.active=docker,dockeradmin" ]
