FROM openjdk:17
WORKDIR /app
COPY target/docker-springapplication-0.0.1-SNAPSHOT.jar /app/app.jar
CMD ["java", "-jar", "app.jar"]