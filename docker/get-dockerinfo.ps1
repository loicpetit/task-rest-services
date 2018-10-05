Write-Host ***********
Write-Host * VOLUMES *
Write-Host ***********
docker volume ls
Write-Host 
Write-Host ************
Write-Host * NETWORKS *
Write-Host ************
docker network ls
Write-Host 
Write-Host **********
Write-Host * IMAGES *
Write-Host **********
docker image ls
Write-Host 
Write-Host **************
Write-Host * CONTAINERS *
Write-Host **************
docker container ls -a
Write-Host 
