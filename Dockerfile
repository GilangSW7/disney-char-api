FROM openjdk:8 as builder
COPY target/disney-char-api-0.0.1-SNAPSHOT.jar disney-char-api.jar
ENTRYPOINT ["java","-jar","/disney-char-api.jar"]