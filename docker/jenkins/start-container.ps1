# attach docker socket to enable jenkins to create containers
docker run -d -p 8000:8080 -p 50001:50000 --restart=always --name jenkins -v /var/run/docker.sock:/var/run/docker.sock -v jenkins_home:/var/jenkins_home portepoisse/jenkins:lts
