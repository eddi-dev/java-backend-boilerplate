FROM amazoncorretto:11.0.14

RUN mkdir ./image
COPY build/libs/*.jar ./image/app.jar

ENTRYPOINT ["java", "-jar", "./image/app.jar"]