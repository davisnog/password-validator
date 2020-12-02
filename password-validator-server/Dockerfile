FROM oracle/graalvm-ce:20.3.0-java11 as graalvm
RUN gu install native-image

WORKDIR /home/app
COPY ../build/layers/libs /home/app/libs
COPY ../build/layers/resources /home/app/resources
COPY build/layers/complete-*-all.jar /home/app/application.jar
RUN native-image -H:Class=dev.davinogueira.password.MainKt -H:Name=password-validator --no-fallback -cp /home/app/libs/complete-*-all.jar:/home/app/resources:/home/app/application.jar

FROM frolvlad/alpine-glibc
RUN apk update && apk add libstdc++
EXPOSE 8080
RUN apk update && apk add libstdc++
COPY --from=graalvm /home/app/application /app/application
ENTRYPOINT ["/app/application"]
