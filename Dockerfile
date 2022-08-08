FROM openjdk:8-jdk-alpine
RUN mkdir -p /excercies1
COPY target/hello-world-rest-api.jar excercies1/hello-world-rest-api.jar
ENTRYPOINT ["java","-jar","/excercies1/hello-world-rest-api.jar"]
