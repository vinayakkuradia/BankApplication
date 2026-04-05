# Build stage
FROM maven:3.9-eclipse-temurin-17 AS build
COPY . .
RUN mvn clean package -DskipTests

# Run stage
FROM eclipse-temurin:17-jre-alpine
COPY --from=build /target/*.war app.war
EXPOSE 10000
ENTRYPOINT ["java", "-jar", "app.war"]