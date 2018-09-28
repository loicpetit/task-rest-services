# spring boot admin
mvn clean package -f $pwd\..\spring-boot-admin
docker build -t portepoisse/spring-boot-admin:latest $pwd\..\spring-boot-admin
# app
mvn clean package -f $pwd\..\app
docker build -t portepoisse/task-rest-services:latest $pwd\..\app
