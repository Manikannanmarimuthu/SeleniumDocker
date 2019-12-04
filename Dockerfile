FROM openjdk:8u191-jre-alpine3.8

RUN apk add curl jq

WORKDIR /usr/share/dockertest

ADD target/selenium-docker.jar selenium-docker.jar
ADD target/selenium-docker-tests.jar selenium-docker-tests.jar
ADD target/libs libs

ADD testng.xml       testng_mercury.xml
ADD testng_Search.xml   testng_search.xml

#Healthcheck Script
ADD healthcheck.sh   healthcheck.sh

ENTRYPOINT sh healthcheck.sh