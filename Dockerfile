FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app
EXPOSE 4000

COPY . /app/

CMD ["./mvnw", "spring-boot:run"]