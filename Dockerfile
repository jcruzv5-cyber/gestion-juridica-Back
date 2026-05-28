FROM maven:3.9.12-eclipse-temurin-25 AS build
WORKDIR /app

COPY . .

RUN mvn clean package -DskipTests

FROM eclipse-temurin:25-jre
WORKDIR /app

COPY --from=build /app/target/quarkus-app/ /app/quarkus-app/

EXPOSE 10000

CMD ["java", "-jar", "/app/quarkus-app/quarkus-run.jar"]