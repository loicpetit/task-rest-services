docker tag portepoisse/task-rest-services-base:latest localhost:5000/estrescue/task-rest-services-base:latest
docker tag portepoisse/task-rest-services:latest localhost:5000/estrescue/task-rest-services:latest
docker push localhost:5000/estrescue/task-rest-services-base:latest
docker push localhost:5000/estrescue/task-rest-services:latest
