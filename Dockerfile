FROM openjdk:17
#ADD target/General-0.0.1-SNAPSHOT.jar General-0.0.1-SNAPSHOT.jar
EXPOSE 8097
#VOLUME /tmp
#ARG JAR_FILE
#COPY ${JAR_FILE} General-0.0.1-SNAPSHOT.jar
#ENTRYPOINT ["java","-jar","/General-0.0.1-SNAPSHOT.jar"]

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
