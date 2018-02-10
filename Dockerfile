FROM openjdk:8-jdk-alpine
RUN apk add --no-cache bash
COPY ./target/docker-demo-0.0.1-SNAPSHOT.jar  /app.jar
COPY ./src/main/resources/wait-for-it.sh  /wait-for-it.sh
RUN chmod +x /wait-for-it.sh
EXPOSE 8080