FROM maven:3.8.2-eclipse-temurin-17 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM eclipse-temurin:17.0.8_7-jre-jammy
VOLUME /tmp
COPY --from=build /target/customer-queue-0.0.1-SNAPSHOT.jar customer-queue.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/customer-queue.jar"]