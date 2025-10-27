# Imagen base con JDK
FROM openjdk:17-jdk-slim

# Directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiar el .jar ya compilado (por ejemplo target/backend-lista-compras.jar)
COPY ./target/backend-lista-compras.jar app.jar

# Puerto en el que correrá la aplicación dentro del contenedor
EXPOSE 9000

# Comando para ejecutar el backend
ENTRYPOINT ["java", "-jar", "app.jar"]
