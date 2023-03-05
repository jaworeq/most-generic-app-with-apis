FROM gradle:8-jdk11-alpine AS build
COPY build.gradle .
COPY src ./src
RUN gradle build
RUN ls -l ./build/libs
RUN pwd


FROM openjdk:11.0.1-jdk-slim
COPY --from=build /home/gradle/build/libs/* file.jar
ENTRYPOINT ["java", "-jar", "file.jar"]