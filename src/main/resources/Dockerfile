FROM java:8
VOLUME /tmp
ADD integration-server-0.0.1-SNAPSHOT.jar /integration.jar
RUN bash -c 'touch /integration.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/integration.jar"]