# SpringBoot
#spring boot docker
-- 运行容器：docker run --name demo -d -p 0.0.0.0:8080:8080 -v \
/export/logs/demo:/export/logs/demo springboot/spring-boot-docker:latest
-- 进入容器：docker exec -it demo /bin/sh

