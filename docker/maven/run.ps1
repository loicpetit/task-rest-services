docker container run --rm --volume maven:/root/.m2 --volume $pwd/../../app:/app --workdir /app maven:3.5.4-alpine mvn clean package
