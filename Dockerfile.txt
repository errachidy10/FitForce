# Utiliser une image de base officielle de Maven pour la compilation
FROM maven:3.6.3-jdk-8 AS build

# Définir le répertoire de travail dans le conteneur
WORKDIR /app

# Copier le fichier pom.xml et télécharger les dépendances du projet
COPY pom.xml .
RUN mvn dependency:go-offline

# Copier le reste des fichiers du projet
COPY src ./src

# Compiler l'application
RUN mvn clean package

# Utiliser une image de base officielle de OpenJDK pour exécuter l'application
FROM openjdk:8-jre

# Définir le répertoire de travail dans le conteneur
WORKDIR /app

# Copier le fichier JAR généré depuis l'étape de compilation
COPY --from=build /app/target/your-app.jar ./your-app.jar

# Exposer le port sur lequel l'application s'exécute
EXPOSE 8081

# Commande pour exécuter l'application
CMD ["java", "-jar", "your-app.jar"]