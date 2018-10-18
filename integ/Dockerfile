FROM openjdk:8-jdk-alpine

LABEL maintainer="steliomo@gmail.com" 

VOLUME [ "/opt/consultation/data" ]

EXPOSE 8080

ARG jar_file

ADD ${jar_file} consultation-integ.jar

# Prod
ENTRYPOINT [ "java", "-Djava.security.egd=file:/dev/./urandom", "-Xdebug", "-jar", "consultation-integ.jar" ]

# Dev
#ENTRYPOINT [ "java", "-Djava.security.egd=file:/dev/./urandom", "-Xdebug", "-Xrunjdwp:server=y,transport=dt_socket,address=8000,suspend=n", "-jar", "consultation-integ.jar" ]
