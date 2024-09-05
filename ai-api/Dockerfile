FROM openjdk:21-jdk
WORKDIR /app
COPY build/libs/ai-0.0.1-SNAPSHOT.jar /app/ai-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/ai-0.0.1-SNAPSHOT.jar"]
