FROM openjdk:8-jdk-alpine

LABEL maintainer="steliomo@gmail.com" 

VOLUME [ "/opt/consultation/data" ]

EXPOSE 8080

ARG jar_file

ADD ${jar_file} consultation-integ.jar

ENTRYPOINT [ "java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "consultation-integ.jar" ]