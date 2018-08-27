docker stop task-rest-services
mvn clean package -DskipTests -f $pwd\..
docker start --attach task-rest-services
