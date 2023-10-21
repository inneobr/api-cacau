FROM maven:3.6.0-jdk-11-slim AS build  
COPY src /usr/src/app/src  
COPY pom.xml /usr/src/app  
RUN mvn -f /usr/src/app/pom.xml clean package


FROM openjdk:17
RUN mkdir api
COPY --from=build /usr/src/app/target/*.jar api/cacauapp.jar
EXPOSE 9000
ENTRYPOINT ["java", "-jar", "/api/cacauapp.jar"]