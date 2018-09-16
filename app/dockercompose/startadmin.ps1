mvn clean package -f $pwd\..
mvn clean package -f $pwd\..\..\spring-boot-admin
docker-compose -f ../docker-compose-prod.yml -f ../docker-compose-admin.yml -p task_rest_services up -d
