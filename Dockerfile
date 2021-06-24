# Boilerplate
FROM openjdk:15
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ADD src/main/resources /
ENTRYPOINT ["java","-jar","/app.jar"]