docker-compose -f ./docker-compose-admin.yml -f ./docker-compose-dev.yml -p task_rest_services rm -f -s -v web
mvn clean package -f $pwd\..\..\app -DskipTests
docker-compose -f ./docker-compose-admin.yml -f ./docker-compose-dev.yml -p task_rest_services up -d web
docker attach task_rest_services_web_1
