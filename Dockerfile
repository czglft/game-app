# Use an official OpenJDK runtime as a base image
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file into the container at /app
COPY target/game-app.jar /app/game-app.jar

# Expose the port that your application runs on
EXPOSE 8080

# Specify the command to run on container startup
CMD ["java", "-jar", "game-app.jar"]
