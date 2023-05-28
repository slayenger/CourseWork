FROM adoptopenjdk:17-jre-hotspot
ARG JAR_FILE=demo-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} application.jar
ENTRYPOINT ["java", "-jar", "application.jar"]