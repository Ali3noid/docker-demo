FROM openjdk:8-jdk-alpine
RUN apk add --no-cache bash
COPY ./target/screeningServer-0.0.1-SNAPSHOT.jar  /app.jar
CMD ["/wait-for-it/wait-for-it.sh", "db-postgres:5432", "--strict", "--", "java", "-jar", "/app.jar"]
EXPOSE 8080