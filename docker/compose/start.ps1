docker-compose -f ./docker-compose-admin.yml -f ./docker-compose-dev.yml -p task_rest_services up -d
docker attach task_rest_services_web_1
