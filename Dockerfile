FROM gradle:8-jdk11-alpine
COPY build.gradle .
COPY src/ .
ENTRYPOINT ["gradle","build"]