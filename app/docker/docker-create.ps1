docker create --name task-rest-services -p 8080:8080 -v $pwd\..\target\task-rest-services-1.0.0.jar:/app/task-rest-services.jar portepoisse/task-rest-services:latest
