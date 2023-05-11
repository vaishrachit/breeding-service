
#
# Build stage
#
FROM maven:3.8.2-jdk-8 AS build
COPY . .
RUN mvn clean package -DskipTests

#
# Package stage
#

FROM openjdk:8
EXPOSE 8090
COPY --from=build /target/breeding-service-docker.jar breeding-service-docker.jar
ENTRYPOINT [ "java","-jar","breeding-service-docker.jar" ]