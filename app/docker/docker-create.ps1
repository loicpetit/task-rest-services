docker network create task-rest-services-net
docker create --name task-rest-services `
    --publish 8080:8080 `
    --network task-rest-services-net `
    --volume $pwd\..\target\task-rest-services-1.0.0.jar:/app/task-rest-services.jar `
    --volume $pwd\..\logs\:/app/logs/ `
    --volume $pwd\..\properties\:/app/config/ `
    portepoisse/task-rest-services:latest
docker create --name task-rest-services-postgres `
    --publish 5432:5432 `
    --network task-rest-services-net `
    --env POSTGRES_USER=postgres `
    --env POSTGRES_PASSWORD=Support2424 `
    --env POSTGRES_DB=TaskRestServices `
    --volume $pwd\..\bdd\:/docker-entrypoint-initdb.d/ `
    postgres:10-alpine
docker create --name task-rest-services-pgadmin `
    --publish 5433:80 `
    --network task-rest-services-net `
    --env PGADMIN_DEFAULT_EMAIL=loic.petit@capgemini.com `
    --env PGADMIN_DEFAULT_PASSWORD=Support2424 `
    dpage/pgadmin4:latest
