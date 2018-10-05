# spring boot admin
docker network create spring-boot-admin-net
docker create --name spring-boot-admin `
    --publish 8081:8081 `
    --network spring-boot-admin-net `
    --network-alias springbootadmin `
    portepoisse/spring-boot-admin:latest
# pgadmin
docker network create pgadmin-net
docker create --name pgadmin `
    --publish 5433:80 `
    --network pgadmin-net `
    --network-alias pgadmin `
    --env PGADMIN_DEFAULT_EMAIL=loic.petit@capgemini.com `
    --env PGADMIN_DEFAULT_PASSWORD=Support2424 `
    dpage/pgadmin4:latest
# app network
docker network create task-rest-services-net
# app database
docker volume create task-rest-services-db
docker create --name task-rest-services-db `
    --network task-rest-services-net `
    --network-alias database `
    --volume task-rest-services-db:/var/lib/postgresql/data/ `
    portepoisse/task-rest-services-db
docker network connect --alias task-rest-services-db pgadmin-net task-rest-services-db
# app
docker volume create task-rest-services-logs
docker create --name task-rest-services `
    --publish 8080:8080 `
    --network task-rest-services-net `
    --network-alias web `
    --volume $pwd\..\..\app\target\task-rest-services-1.0.0.jar:/app/task-rest-services.jar `
    --volume task-rest-services-logs:/app/logs/ `
    --volume $pwd\..\..\app\properties\:/app/config/ `
    portepoisse/task-rest-services:latest
docker network connect --alias task-rest-services spring-boot-admin-net task-rest-services
