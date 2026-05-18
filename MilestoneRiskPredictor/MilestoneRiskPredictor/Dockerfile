FROM maven:3-eclipse-temurin-21-alpine AS build

WORKDIR /home/app/MileStoneRiskPredictor

COPY . .

RUN mvn clean package -DskipTests

FROM eclipse-temurin:21-jre-alpine AS deploy

WORKDIR /home/app/MileStoneRiskPredictor/build

COPY --from=build /home/app/MileStoneRiskPredictor/target/*.jar MileStoneRiskPredictor.jar


EXPOSE 8082


CMD ["java","-jar","MileStoneRiskPredictor.jar"]
