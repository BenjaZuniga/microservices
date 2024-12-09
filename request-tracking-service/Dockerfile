FROM openjdk:17
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} request-tracking-service.jar
EXPOSE 8090
ENTRYPOINT ["java","-jar","/request-tracking-service.jar"]