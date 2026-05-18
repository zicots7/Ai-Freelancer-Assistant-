FROM maven:3-eclipse-temurin-21-alpine AS build

WORKDIR /home/app/SmartProposal

COPY . .

RUN mvn clean package -DskipTests

FROM eclipse-temurin:21-jre-alpine AS deploy

WORKDIR /home/app/SmartProposal/build

COPY --from=build /home/app/SmartProposal/target/*.jar SmartProposal.jar


EXPOSE 8084


CMD ["java","-jar","SmartProposal.jar"]
