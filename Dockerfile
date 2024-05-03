FROM maven:3.6.1-jdk-11-slim as builder
LABEL Author="kasun.ranasinghe@icloud.com"

WORKDIR /base
COPY settings.xml /base/
COPY src /base/src
COPY pom.xml /base/

RUN mvn --settings /base/settings.xml clean install

RUN jlink --output /base/customjre --add-modules $(jdeps --print-module-deps /base/target/coop-administration.jar),java.xml,jdk.unsupported,java.sql,java.naming,java.desktop,java.management,java.security.jgss,java.instrument


FROM debian:9-slim

WORKDIR /app
COPY --from=builder /base/target/coop-administration.jar /app/
COPY --from=builder /base/customjre /app/customjre

ENTRYPOINT /app/customjre/bin/java -Djava.security.egd=file:/dev/./urandom -jar coop-administration.jar --server.port=80
