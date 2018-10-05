# containers
docker container stop spring-boot-admin
docker container stop pgadmin
docker container stop task-rest-services
docker container stop task-rest-services-db
docker container rm -v spring-boot-admin
docker container rm -v pgadmin
docker container rm -v task-rest-services
docker container rm -v task-rest-services-db
# networks
docker network rm task-rest-services-net
docker network rm pgadmin-net
docker network rm spring-boot-admin-net
# volumes
docker volume rm task-rest-services-db
docker volume rm task-rest-services-logs
