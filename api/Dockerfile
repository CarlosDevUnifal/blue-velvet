# Define a imagem base
FROM openjdk:19

# Define o diretório de trabalho dentro do container
WORKDIR /app

# Copia o arquivo JAR gerado pelo Maven para dentro do container
COPY target/api-0.0.1-SNAPSHOT.jar /app/api-0.0.1-SNAPSHOT.jar

# Define o comando que será executado quando o container for iniciado
CMD ["java", "-jar", "/app/api-0.0.1-SNAPSHOT.jar"]
