#base docker image creation
FROM openjdk:21
LABEL maintainer="bgabryjolek"
ADD target/Cookbook-0.0.1-SNAPSHOT.jar cookbook-docker.jar
ENTRYPOINT ["java", "-jar", "cookbook-docker.jar"]