FROM openjdk:8-jdk-stretch
COPY build/libs/hello-cloud-run-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar","/app.jar"]

