# First stage: complete build environment
FROM maven:3.5.0-jdk-8-alpine AS builder

# add pom.xml and source code
ADD ./pom.xml pom.xml
ADD ./src src/

# package jar
RUN mvn clean package

FROM anapsix/alpine-java:8_server-jre_unlimited

MAINTAINER CheungChingYin@outlook.com

RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime

#RUN mkdir -p /jeecg-boot/config/jeecg/

EXPOSE 8081

#ADD ./src/main/resources/jeecg ./config/jeecg
ADD ./target/repairsystem-0.0.1-SNAPSHOT.jar ./

CMD ["java", "-jar", "repairsystem-0.0.1-SNAPSHOT.jar", "-Dfile.encoding=utf-8"]
