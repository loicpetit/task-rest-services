docker container stop spring-boot-admin
docker container stop pgadmin
docker container stop task-rest-services
docker container stop task-rest-services-postgres
docker container rm -v spring-boot-admin
docker container rm -v pgadmin
docker container rm -v task-rest-services
docker container rm -v task-rest-services-postgres
docker network rm spring-boot-admin-net
docker network rm pgadmin-net
docker network rm task-rest-services-net
docker volume rm task-rest-services-pgdata
docker volume rm task-rest-services-logs
#docker image rm portepoisse/spring-boot-admin:latest
#docker rmi portepoisse/task-rest-services:latest
