FROM maven:3.6.3-jdk-11-slim AS build
WORKDIR usr/src/app
COPY . ./
RUN mvn clean package


FROM openjdk:17
RUN mkdir api
COPY --from=build /usr/src/app/target/*.jar api/cacauapp.jar
EXPOSE 9000
ENTRYPOINT ["java", "-jar", "/api/cacauapp.jar"]