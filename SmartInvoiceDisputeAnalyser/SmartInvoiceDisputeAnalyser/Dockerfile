FROM maven:3-eclipse-temurin-21-alpine AS build

WORKDIR /home/app/SmartInvoiceDisputeAnalyser

COPY . .

RUN mvn clean package -DskipTests

FROM eclipse-temurin:21-jre-alpine AS deploy

WORKDIR /home/app/freelanceTrackerPdf/build

COPY --from=build /home/app/SmartInvoiceDisputeAnalyser/target/*.jar SmartInvoiceDisputeAnalyser.jar


EXPOSE 8083


CMD ["java","-jar","SmartInvoiceDisputeAnalyser.jar"]
