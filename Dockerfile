FROM openjdk:21-jdk-slim

RUN apt-get update && apt-get install -y maven

WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN mvn clean package

ARG JAR_FILE=target/*.jar
RUN cp ${JAR_FILE} app.jar

EXPOSE 8082

ENTRYPOINT ["java","-jar","app.jar"]