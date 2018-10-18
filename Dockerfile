FROM openjdk:8
ADD target/spring-data.jar spring-data.jar
EXPOSE 8085
ENTRYPOINT ["java", "-jar", "spring-data.jar"]