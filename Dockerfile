FROM eclipse-temurin:17-jre-alpine

RUN addgroup --system javauser && adduser -S -s /usr/sbin/nologin -G javauser javauser
USER javauser

WORKDIR /app

COPY target/GymSubscribe-0.0.1-SNAPSHOT.war app.war

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.war"]


