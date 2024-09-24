FROM maven:3.6.3-openjdk-17 AS build
WORKDIR /app
COPY . /app/
RUN mvn clean package

FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY --from=build app/target/BaiCuoiMon-0.0.1-SNAPSHOT.jar /app/BaiCuoiMon-0.0.1-SNAPSHOT.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "BaiCuoiMon-0.0.1-SNAPSHOT.jar"]
