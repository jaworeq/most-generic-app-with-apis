FROM docker:20.10.21-dind-alpine3.17
RUN apk add openjdk11
RUN apk add gradle
WORKDIR /tmp
ENV TESTCONTAINERS_HOST_OVERRIDE=host.docker.internal

COPY gradlew ./
COPY gradle ./gradle
COPY src ./src
COPY db ./db
COPY build.gradle ./
COPY settings.gradle ./
RUN chmod +x gradlew
RUN dos2unix gradlew
ENTRYPOINT ["gradle", "test"]
