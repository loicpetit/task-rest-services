# add registry in insecure registries
#   Docker settings -> Daemon
docker tag portepoisse/task-rest-services-base:latest 127.0.0.1:5000/estrescue/task-rest-services-base:latest
docker tag portepoisse/task-rest-services:latest 127.0.0.1:5000/estrescue/task-rest-services:latest
docker push 127.0.0.1:5000/estrescue/task-rest-services-base:latest
docker push 127.0.0.1:5000/estrescue/task-rest-services:latest
docker image rm 127.0.0.1:5000/estrescue/task-rest-services-base:latest 127.0.0.1:5000/estrescue/task-rest-services:latest
