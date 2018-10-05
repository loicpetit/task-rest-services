docker container stop task-rest-services
mvn clean package -DskipTests -f $pwd\..\..\app
docker container start --attach task-rest-services
