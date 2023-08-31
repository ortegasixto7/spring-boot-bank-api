FROM eclipse-temurin:17-jdk-alpine as build-stage
WORKDIR /app
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:go-offline
COPY src ./src
RUN ./mvnw clean install -DskipTests

FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
EXPOSE 8001
COPY --from=build-stage /app/target/*.jar /app/bank-api.jar
ENTRYPOINT ["java", "-jar", "/app/bank-api.jar" ]