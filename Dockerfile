FROM eclipse-temurin:17-jre-alpine

RUN addgroup --system javauser && adduser -S -s /usr/sbin/nologin -G javauser javauser
USER javauser

ARG WAR_FILE=GymSubscribe-0.0.1-SNAPSHOT.war

WORKDIR /app

COPY target/${WAR_FILE} app.war

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.war"]


