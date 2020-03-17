FROM openjdk:8
COPY build/libs/hello-cloud-run-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-Dspring.main.banner-mode=off", "-Dspring.main.lazy-initialization=true", "-XX:TieredStopAtLevel=1", "-XX:+AlwaysPreTouch", "-noverify", "-Djava.security.egd=file:/dev/./urandom", "-jar","/app.jar"]

