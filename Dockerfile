FROM java:11
EXPOSE 8080
ADD target/spring-boot-docker-maven.jar spring-boot-docker-maven.jar
ENTRYPOINT ["java", "-jar", "spring-publishing-webapp-0.0.1-SNAPSHOT.jar"]