FROM openjdk:11-jre-slim-buster

LABEL version=0.0.1-SNAPSHOT
ADD target/demo2-0.0.1-SNAPSHOT.jar demo2-0.0.1-SNAPSHOT.jar
EXPOSE 8083
ENTRYPOINT ["java","-jar","demo2-0.0.1-SNAPSHOT.jar"]