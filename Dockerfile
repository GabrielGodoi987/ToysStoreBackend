FROM openjdk:21-jdk-slim

RUN apt-get update && apt-get install -y

RUN apt-get install -y maven

WORKDIR /app

COPY . .

RUN mvn clean

RUN mvn package

ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} /app.jar

COPY entrypoint.sh /entrypoint.sh

RUN chmod +x /entrypoint.sh

EXPOSE 8082

ENTRYPOINT ["/entrypoint.sh"]