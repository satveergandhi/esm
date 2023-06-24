FROM alpine:3.12.1
USER root

RUN apk update
RUN apk add openjdk11

RUN apk add --no-cache bash
RUN apk add curl

EXPOSE 8080
RUN apk add --update openssl
RUN apk add --update oniguruma 
RUN apk add --update libx11 
RUN apk add --update freetype
RUN apk add --update curl && rm -rf /var/cache/apk/*
COPY target/EmployeeSalaryMgt-0.0.1-SNAPSHOT.jar EmployeeSalaryMgt-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/EmployeeSalaryMgt-0.0.1-SNAPSHOT.jar"] 
