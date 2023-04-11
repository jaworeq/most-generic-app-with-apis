#Test only step, requires /var/run/docker.sock mounted on runtime
FROM docker:20.10.21-dind-alpine3.17 AS test
RUN apk add openjdk11
RUN apk add gradle
WORKDIR /tmp
ENV TESTCONTAINERS_HOST_OVERRIDE=host.docker.internal

COPY build.gradle ./
COPY db ./db
COPY src ./src
ENTRYPOINT ["gradle", "test"]

FROM gradle:7.6.1-jdk11-alpine AS build
COPY build.gradle .
COPY db ./db
COPY src ./src
RUN gradle clean assemble
RUN ls -l ./build/libs


FROM openjdk:11.0.15-jdk-slim
COPY --from=build /home/gradle/build/libs/* file.jar
ENV SPRING_PROFILES_ACTIVE=docker
ENTRYPOINT ["java", "-jar", "file.jar"]