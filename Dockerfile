FROM openjdk:17
RUN mkdir api
COPY target/*.jar api/cacauapp.jar
EXPOSE 9000
ENTRYPOINT ["java", "-jar", "/api/cacauapp.jar"]