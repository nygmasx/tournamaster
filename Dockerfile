FROM maven:3.8.2-eclipse-temurin-21 as build
COPY pom.xml .
COPY src/ src/
RUN mvn -f pom.xml -Pprod clean package

FROM eclipse-temurin:21-jre as run
RUN useradd nygma
USER nygma
COPY --from=build /target/tourna-master.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]