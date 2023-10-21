FROM maven:3.6.0-jdk-11-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package


FROM openjdk:17
RUN mkdir api
COPY --from=build /home/app/target/*.jar api/cacauapp.jar
EXPOSE 9000
ENTRYPOINT ["java", "-jar", "/api/cacauapp.jar"]