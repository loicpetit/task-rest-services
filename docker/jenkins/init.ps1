# require registry container
# attach docker socket to enable jenkins to create containers
docker volume create jenkins_home
docker network create jenkins-net
docker run -d -p 8000:8080 -p 50001:50000 --restart=always --name jenkins -v /var/run/docker.sock:/var/run/docker.sock -v jenkins_home:/var/jenkins_home portepoisse/jenkins:lts
docker network connect jenkins-net jenkins
docker network connect jenkins-net registry
