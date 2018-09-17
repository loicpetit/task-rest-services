docker-compose -f ../docker-compose-dev.yml -p task_rest_services rm -f -s -v web
mvn clean package -f $pwd\.. -DskipTests
docker-compose -f ../docker-compose-dev.yml -p task_rest_services up -d web
