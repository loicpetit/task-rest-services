docker create --name task-rest-services -p 8080:8080 -v $pwd\..\target\task-rest-services-1.0.0.jar:/app/task-rest-services.jar -v $pwd\..\logs\:/app/logs/ -v $pwd\..\properties\:/app/config/ portepoisse/task-rest-services:latest
