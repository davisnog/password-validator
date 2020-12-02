FROM gradle:jdk15 as builder
WORKDIR /home/app
COPY build.gradle.kts gradle.properties settings.gradle.kts ./
RUN gradle --no-daemon assemble --stacktrace
COPY src src
RUN gradle --no-daemon assemble --stacktrace

FROM openjdk:15-alpine
WORKDIR /home/app

# Copy bin from builder to this new image
COPY --from=builder /home/app/build/layers/libs /home/app/libs
COPY --from=builder /home/app/build/layers/resources /home/app/resources
COPY --from=builder /home/app/build/layers/application.jar /home/app/application.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/home/app/application.jar"]
