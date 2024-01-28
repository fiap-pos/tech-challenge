FROM maven:3.9.2-eclipse-temurin-17-alpine@sha256:4d9daa0d5471f52a318df5c4aa9d3ab6d5ade68bb5421a4844090cf5b140fbb2 AS build
RUN mkdir /app
WORKDIR /app
COPY . /app
RUN mvn clean package -DskipTests

FROM amazoncorretto:17.0.10
RUN mkdir /app
RUN apt-get update && apt-get install -y dumb-init
COPY --from=build /app/target/lanchonete-*.jar /app/java-application.jar
WORKDIR /app
RUN addgroup --system lanchonete-app && useradd -r lanchonete-app -g lanchonete-app
RUN chown -R lanchonete-app:lanchonete-app /app
USER lanchonete-app
EXPOSE 8080
CMD "dumb-init" "java" "-jar" "java-application.jar"
