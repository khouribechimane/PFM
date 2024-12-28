# Stage 1: Build with Maven
FROM maven:latest AS builder
WORKDIR /app
COPY ./src ./src
COPY ./pom.xml .
RUN mvn clean package -DskipTests

# Vérifiez le contenu du répertoire target pour confirmer que le .jar a bien été généré
RUN ls -l /app/target

# Stage 2: Create the final image
FROM openjdk:17-jdk-alpine
VOLUME /tmp
COPY --from=builder /app/target/event-sports-back-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
