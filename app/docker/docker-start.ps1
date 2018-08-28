mvn clean package -DskipTests -f $pwd\..
docker container start task-rest-services-postgres
docker container start task-rest-services-pgadmin
docker container start --attach task-rest-services
