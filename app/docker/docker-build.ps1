mvn clean package -f $pwd\..
docker build -t portepoisse/task-rest-services:latest $pwd\..
