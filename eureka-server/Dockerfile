FROM openjdk:17
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} eureka-server.jar
EXPOSE 8090
ENTRYPOINT ["java","-jar","/eureka-server.jar"]