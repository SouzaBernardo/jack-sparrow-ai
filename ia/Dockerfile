FROM openjdk:21-jdk
WORKDIR /app
COPY build/libs/ia-0.0.1-SNAPSHOT.jar /app/ia-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/ia-0.0.1-SNAPSHOT.jar"]
