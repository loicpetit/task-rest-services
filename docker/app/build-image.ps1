$path = "$pwd\..\..\app"
mvn clean package -f $path
docker build -t portepoisse/task-rest-services:latest $path
