$path = "$pwd\..\..\springbootadmin"
mvn clean package -f $path
docker build -t portepoisse/spring-boot-admin:latest $path
