# Stage 1: Build the application
FROM maven:3.8.2-eclipse-temurin-17 AS build
COPY . .
RUN mvn clean package -DskipTests

# Stage 2: Create the final image
FROM eclipse-temurin:17.0.8_7-jre-jammy

# Set the working directory
WORKDIR /app

# Set environment variables for PostgreSQL
ENV SPRING_DATASOURCE_URL=""
ENV SPRING_DATASOURCE_USERNAME=""
ENV SPRING_DATASOURCE_PASSWORD=""
ENV SPRING_DATASOURCE_DRIVER_CLASS_NAME=""
ENV SPRING_JPA_DATABASE_PLATFORM=""
ENV SPRING_JPA_HIBERNATE_DDL_AUTO=""

# Create the /app directory
RUN mkdir /app

# Create the application.properties file from environment variables
RUN echo "spring.datasource.url=${SPRING_DATASOURCE_URL}" > /app/application.properties \
    && echo "spring.datasource.username=${SPRING_DATASOURCE_USERNAME}" >> /app/application.properties \
    && echo "spring.datasource.password=${SPRING_DATASOURCE_PASSWORD}" >> /app/application.properties \
    && echo "spring.datasource.driverClassName=${SPRING_DATASOURCE_DRIVER_CLASS_NAME}" >> /app/application.properties \
    && echo "spring.jpa.database-platform=${SPRING_JPA_DATABASE_PLATFORM}" >> /app/application.properties \
    && echo "spring.jpa.hibernate.ddl-auto=${SPRING_JPA_HIBERNATE_DDL_AUTO}" >> /app/application.properties

# Copy the JAR file from the build stage
COPY --from=build /target/customer-queue-0.0.1-SNAPSHOT.jar customer-queue.jar

# Expose the port
EXPOSE 8080

# Entry point to run the application
ENTRYPOINT ["java", "-jar", "customer-queue.jar"]
