FROM docker:20.10.21-dind-alpine3.17 AS build
RUN apk add openjdk11
COPY gradlew ./
COPY src ./src
COPY db ./db
#VOLUME //var/run/docker.sock
#ENV TESTCONTAINERS_HOST_OVERRIDE=host.docker.internal
#ENV DOCKER_HOST=tcp://localhost:2375
RUN #ls -l /var/run/docker.sock
RUN #docker ps
RUN #curl --unix-socket /var/run/docker.sock http:/_/_ping
RUN #ls -al; return 1
RUN ls ./gradlew
RUN chmod +x gradlew
RUN which java
RUN set -x
RUN ls -l gradlew
RUN dos2unix gradlew
RUN ls -l gradlew
RUN head -n1 gradlew
RUN gradlew clean build
#ENTRYPOINT ["gradle", "clean", "build"]
#RUN ls -l ./build/libs
#RUN pwd

#
#FROM openjdk:11.0.15-jdk-slim
#COPY --from=build /home/gradle/build/libs/* file.jar
#ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=docker", "file.jar"]