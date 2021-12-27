FROM openjdk:8-jdk-alpine
MAINTAINER 1099272020@qq.com

# 声明暴露的端口
EXPOSE 8899

# time zone
RUN echo "Asia/Shanghai" > /etc/timezone

#运行环境 VOLUME(卷)
VOLUME /tmp

# 工作目录
WORKDIR /usr/local/work

#拷贝文件并且重命名，将应用jar包复制到app.jar
COPY spring-boot-seed-v1.0.0.jar app.jar

#为了缩短 Tomcat 的启动时间，添加java.security.egd的系统属性指向/dev/urandom作为 ENTRYPOINT
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom","-Dspring.profiles.active=test", "-jar", "app.jar"]