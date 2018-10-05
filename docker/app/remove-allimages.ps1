$current = $pwd

./remove-image.ps1

cd ../appbase
./remove-image.ps1

cd ../appdb
./remove-image.ps1

cd ../springbootadmin
./remove-image.ps1

cd $current

docker image rm openjdk:8-jre-alpine postgres:10-alpine dpage/pgadmin4:latest
