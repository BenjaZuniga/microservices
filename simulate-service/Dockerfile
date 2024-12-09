FROM openjdk:17
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} simulate-service.jar
EXPOSE 8090
ENTRYPOINT ["java","-jar","/simulate-service.jar"]