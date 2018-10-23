$path = "$pwd\..\..\app"
mvn clean package -f $path
$buildDate = (Get-Date).ToString("yyyy-MM-ddThh:mm:ssZ")
$version = "1.0.0"
docker build --build-arg BUILD_DATE=$buildDate --build-arg BUILD_VERSION=$version -t portepoisse/task-rest-services:latest $path
