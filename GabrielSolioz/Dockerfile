
# Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
# Click nbfs://nbhost/SystemFileSystem/Templates/Other/Dockerfile to edit this template

FROM alpine:latest
FROM amazoncorretto:17-alpine-jdk
MAINTAINER gabrielsolioz
COPY GabrielSolioz/target/GabrielSolioz-0.0.1-SNAPSHOT.jar  gs-app.jar
ENTRYPOINT ["java","-jar","/gs-app.jar"]
