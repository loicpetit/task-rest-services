mvn clean package -f $pwd\..
docker-compose -f ../docker-compose-prod.yml -p task_rest_services up -d --build
