docker container stop jenkins
docker container rm jenkins
docker network disconnect jenkins-net registry
docker network rm jenkins-net
