# Boilerplate
FROM openjdk:15
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ADD src/main/resources /resources
EXPOSE 8099:8099
ENTRYPOINT ["java","-jar","/app.jar"]