FROM openjdk:17
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} request-service.jar
EXPOSE 8090
ENTRYPOINT ["java","-jar","/request-service.jar"]