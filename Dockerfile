#Etapa 1: Build con gradle (Compilacion)
FROM gradle:8.7-jdk21 AS build
WORKDIR /app
COPY . .
RUN chmod +x gradlew && ./gradlew build -x test --no-daemon

#Etapa 2: Imagen final para ejecutar la aplicación
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

#Copiamos unicamente el .jar generado en la estapa anterior
COPY --from=build /app/build/libs/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]