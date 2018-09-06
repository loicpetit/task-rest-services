mvn clean package -f $pwd\..
docker build -t portepoisse/spring-boot-admin:latest $pwd\..
