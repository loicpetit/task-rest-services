$current = $pwd

docker pull dpage/pgadmin4:latest

cd ../springbootadmin
./build-image.ps1

cd ../appdb
./build-image.ps1

cd ../appbase
./build-image.ps1

cd $current
./build-image.ps1
