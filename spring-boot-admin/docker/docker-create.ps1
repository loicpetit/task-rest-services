docker network create spring-boot-admin-net
docker create --name spring-boot-admin `
    --publish 8081:8081 `
    --network spring-boot-admin-net `
    --network-alias webadmin `
    portepoisse/spring-boot-admin:latest
