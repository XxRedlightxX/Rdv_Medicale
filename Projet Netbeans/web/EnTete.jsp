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
                            <a href="Accueil.jsp">Accueil</a>
                            <a href="Connexion_patient.jsp">Voir mes informations</a>
                            <a href="Connexion_patient.jsp">Prendre un rendez-vous</a>
                            <a href="Connexion_medecin.jsp">Annuler/Modifier un rendez-vous</a>
                            <a href="Connexion_medecin.jsp">Contacter un médecin</a>
                        </div>     
                    </c:when>

                    <c:when test = "${sessionScope.typeCompte == 'medecin'}">
                        <div class="container" id="menu">
                            <a href="Accueil.jsp">Accueil</a>
                            <a href="Connexion_patient.jsp">A faire</a>
                        </div>     
                    </c:when>

                    <c:when test = "${sessionScope.typeCompte == 'admin'}">
                        <div class="container" id="menu">
                            <a href="Accueil.jsp">Accueil</a>
                            <a href="Connexion_patient.jsp">A faire</a>
                        </div>     
                    </c:when>

                </c:choose>
            </c:if>
            <c:if test = "${empty sessionScope.typeCompte}">    
                <div class="container" id="menu">
                    <a href="Accueil.jsp">Accueil</a>
                    <a href="Connexion_patient.jsp">Portail Patients</a>
                    <a href="Connexion_medecin.jsp">Portail Medecins</a>
                </div>     
            </c:if>


        </header>
    </body>
</html>