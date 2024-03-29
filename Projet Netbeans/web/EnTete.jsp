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
                            <a href="pagePatientRendezVous.jsp">Consulter mes rendez-vous</a>  
                            <a href="PriseRendezVous.jsp">Prendre un rendez-vous</a>
                            <a href="xyz.jsp">Contacter un médecin</a>
                            <a href="CliniqueInfo.jsp">Recherche de cliniques</a>
                        </div>     
                    </c:when>

                    <c:when test = "${sessionScope.typeCompte == 'medecin'}">
                        <div class="container" id="menu">
                            <a href="Medecin.jsp">Accueil Médecin</a>
                            <a href="CliniqueInfo.jsp">Recherche de cliniques</a>
                        </div>     
                    </c:when>

                    <c:when test = "${sessionScope.typeCompte == 'admin'}">
                        <div class="container" id="menu">
                            <a href="pageAdminPatients.jsp">Gestion des Patients</a>
                            <a href="pageAdminMedecins.jsp">Gestion des Médecins</a>
                            <a href="pageAdminCliniques.jsp">Gestion des Cliniques</a>
                            <a href="CliniqueInfo.jsp">Recherche de cliniques</a>
                        </div>     
                    </c:when>

                </c:choose>
            </c:if>
            <c:if test = "${empty sessionScope.typeCompte}">    
                <div class="container" id="menu">
                    <a href="Accueil.jsp">Accueil</a>
                    <a href="connexionController?typeCompte=patient&username= ">Portail Patients</a>
                    <a href="connexionController?typeCompte=medecin&username= ">Portail Medecins</a>
                    <a href="connexionController?typeCompte=admin&username= ">Portail Administrateurs</a>
                </div>     
            </c:if>


        </header>
    </body>
</html>
