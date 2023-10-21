FROM eclipse-temurin:17-jdk-jammy AS build
ENV HOME=/usr/app
RUN mkdir -p $HOME
WORKDIR $HOME
ADD . $HOME
RUN --mount=type=cache,target=/root/.m2 ./mvnw -f $HOME/pom.xml clean package

FROM openjdk:17
RUN mkdir api
ARG JAR_FILE=/usr/app/target/*.jar
COPY $JAR_FILE api/cacauapp.jar
EXPOSE 9000
ENTRYPOINT ["java", "-jar", "/api/cacauapp.jar"]