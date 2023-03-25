<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width,initial-scale=1.0">

        <link rel="stylesheet" href="style.css">

    </head>
    <body>
        <header id="header">

            <div id="logo">
                <img src="imageWeb2/logo.png" width="60px" , height="50px">

            </div>
            <c:if test = "${not empty sessionScope.typeCompte}">    
                <c:choose>
                    <c:when test = "${sessionScope.typeCompte == 'patient'}">
                        <div class="container" id="menu">
                            <!-- probablement affiche les informations d'un cours dedans -->
                            <a href="Patient.jsp">Accueil Patient</a>  
                            <a href="xyz.jsp">Voir mes informations</a>
                            <a href="xyz.jsp">Prendre un rendez-vous</a>
                            <a href="xyz.jsp">Annuler/Modifier un rendez-vous</a>
                            <a href="xyz.jsp">Contacter un médecin</a>
                        </div>     
                    </c:when>

                    <c:when test = "${sessionScope.typeCompte == 'medecin'}">
                        <div class="container" id="menu">
                            <a href="Medecin.jsp">Accueil Médecin</a>
                            <a href="xyz.jsp">Autres pages A faire au besoin</a>
                        </div>     
                    </c:when>

                    <c:when test = "${sessionScope.typeCompte == 'admin'}">
                        <div class="container" id="menu">
                            <a href="Connexion_patient.jsp">Gestion des Patients</a>
                            <a href="Connexion_patient.jsp">Gestion des Médecins</a>
                            <a href="Connexion_patient.jsp">Gestion des Clinique</a>
                        </div>     
                    </c:when>

                </c:choose>
            </c:if>
            <c:if test = "${empty sessionScope.typeCompte}">    
                <div class="container" id="menu">
                    <a href="Accueil.jsp">Accueil</a>
                    <a href="Connexion_patient.jsp">Portail Patients</a>
                    <a href="Connexion_medecin.jsp">Portail Medecins</a>
                    <a href="Connexion_admin.jsp">Portail Administrateurs</a>
                </div>     
            </c:if>


        </header>
    </body>
</html>