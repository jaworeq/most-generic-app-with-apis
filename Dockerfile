FROM gradle:7.6.1-jdk11-alpine AS build
COPY build.gradle .
COPY src ./src
COPY db ./db
RUN gradle clean assemble
RUN ls -l ./build/libs
RUN pwd


FROM openjdk:11.0.15-jdk-slim
COPY --from=build /home/gradle/build/libs/* file.jar
ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=docker", "file.jar"]