

# PriseRendezVousMédicalHundleyJean-GabrielVictorRabbi (Info santé)

Projet fait en Spring Boot avec l'utilisation de thymeleaf


## Lancer script SQL

Premièrement pour obtenir la base de données il faut prendre le fichier :

Il se peut que dans différentes versions de mysql workbench qu'il faut enlever tous les mots VISIBLE et INVISIBLE

Version sans VISIBLE et INVISIBLE :
ProjetSpringBoot/src/main/java/com/medical/sql/script_base_de_données.txt

ou

Version avec VISIBLE et INVISIBLE :
Base_de_donne/script_base_de_données.txt

La table disponibilités de médecin se base sur la semaine courante et elle a des disponibilités de la semaine du 21 mai au 25 mai 
et j'en ai ajouté pour la semaine du 28 mai au 3 juin

Il se peut qu'une erreur se produise lors de la cération d'une valeur dans la db a cause du hibernate_sequence et la façon dont on incrémente nos clés


## Essayer le projet

Tout le  projet devrait être fonctionnel sauf pour envoyer des courriels et des fichiers

 Un administrateur se connecte avec : 
 - nom_utilisateur
 - password
 
Un patient se connecte avec :
- numero_assurance_maladie
- password

Un medecin se connecte avec :
- id_medecin (numéro de professionnel)
- password

###### Le projet netbeans n'est plus fonctionnel

## Liste des dépendances présentes dans le projet 

Voici la liste des dépendances présentes dans le projet :
```

<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.6.5</version>
        <relativePath/> <!-- lookup parent from repository -->
    </parent>
    <groupId>com.medical</groupId>
    <artifactId>ProjetSpringBoot</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>ProjetSpringBoot</name>
    <description>ProjetSpringBoot</description>
    <properties>
        <java.version>1.8</java.version>
    </properties>
    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <scope>runtime</scope>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-thymeleaf</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-mail</artifactId>
        </dependency>


        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
            <scope>runtime</scope>
            <optional>true</optional>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>


    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>

</project>
```

