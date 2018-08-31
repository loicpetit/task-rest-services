docker container stop task-rest-services
docker container stop task-rest-services-pgadmin
docker container stop task-rest-services-postgres
docker container rm -v task-rest-services
docker container rm -v task-rest-services-pgadmin
docker container rm -v task-rest-services-postgres
docker network rm task-rest-services-net
docker volume rm task-rest-services-pgdata
docker rmi portepoisse/task-rest-services:latest
