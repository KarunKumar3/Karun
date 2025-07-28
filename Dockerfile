# Use Maven to build the app
FROM maven:3.9.6-eclipse-temurin-17 AS build

WORKDIR /app

# Copy pom and source code
COPY pom.xml .
COPY src ./src

# Build the app (creates a .jar file)
RUN mvn clean package -DskipTests

# Use JDK image to run the built app
FROM eclipse-temurin:17-jdk

WORKDIR /app

# Copy the built .jar from the previous stage
COPY --from=build /app/target/*.jar app.jar

# Run the jar
ENTRYPOINT ["java", "-jar", "app.jar"]
