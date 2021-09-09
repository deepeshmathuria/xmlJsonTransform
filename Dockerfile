FROM openjdk:11
COPY target/demo2-0.0.1-SNAPSHOT.jar demo-spring.jar
EXPOSE 8080
CMD ["java","-jar","demo-spring.jar"]