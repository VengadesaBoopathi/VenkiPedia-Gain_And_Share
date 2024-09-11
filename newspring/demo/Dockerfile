# Step 1: Use an official Maven image to build the application
FROM maven:3.8.4-openjdk-17 AS build

# Step 2: Set the working directory in the container
WORKDIR /app

# Step 3: Copy the Maven project file and download dependencies
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src ./src
RUN mvn clean package -DskipTests

# Step 4: Use an official OpenJDK image to run the application
FROM openjdk:17-jdk-slim

# Step 5: Set the working directory in the container
WORKDIR /app

# Step 6: Copy the JAR file from the build stage
COPY --from=build /app/target/demo-0.0.1-SNAPSHOT.jar .

# Step 7: Expose the port the application will run on
EXPOSE 8080

# Step 8: Define the command to run the application
ENTRYPOINT ["java", "-jar", "/app/demo-0.0.1-SNAPSHOT.jar"]
