<%@page import="com.medic.service.CliniqueService"%>
<%@page import="com.medic.entities.Clinique"%>
<%@page import="com.medic.entities.Medecin"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width,initial-scale=1.0">
        <title>Admin</title>

        <link rel="stylesheet" href="style.css">
        <style>
            th {
                text-align: left;
                width: 500px;
            }
            tr tr td {
                text-align: left;
                padding-left:5%;
                width:25%;
            }
            td input {
                width:100px;
                margin-right: 15px;
            }
        </style>

    </head>

    <jsp:include page="EnTete.jsp"/>
    <c:if test = "${not empty requestScope.message}">
        <div id=ls>
            <h1 id="etatMedecin">${requestScope.message}</h1>
        </div>
    </c:if>

    <body id="body">
        <div></br>
            <form action="administrateurController" method="get">
                <input type="hidden" name="gestionAction" value="ajouter">
                <input type="hidden" name="idMedecin" value="00">
                <input type="submit" value="Ajouter un Médecin">
            </form>
        </div>
        <div id="containerListe" style="height:60vh;overflow:auto;">   
            <h1 style="margin-right: 50%">Médecins: </h1>
                <c:choose>
                    <c:when test= "${not empty sessionScope.listeMedecins}">
                    <div>
                        <c:forEach var="unMedecin" items="${sessionScope.listeMedecins}" >
                        <table style="border: 1px solid black;border-radius: 10px;width:60%;margin: auto;background-color: white">
                            <tr>
                                <td rowspan="2"><img src="imageWeb2/patient_vide.png" alt="Trulli" width="125" height="125"></td>
                                <td rowspan="2"><table>
                                        <tr>
                                            <th>Nom:</th>
                                            <td>${unMedecin.nom}</td>
                                            <th>Numero de professionel:</th>
                                            <td>${unMedecin.numeroProfessionel}</td>
                                        </tr>
                                        <tr>
                                            <th>Prenom:</th>
                                            <td>${unMedecin.prenom}</td>
                                            <th>Spécialitée:</th>
                                            <td>${unMedecin.specialite}</td>
                                        </tr>
                                        <tr>
                                            <th>Facturation:</br></th>
                                            <td>${unMedecin.facturation} $</td>
                                            <th>Coordonnées:</th>
                                            <td>${unMedecin.coordonnees}</td>
                                        </tr>
                                        <tr>
                                            <th>Clinique où médecin est employé:</th>
                                                <jsp:useBean id="test" class="com.medic.service.CliniqueService"/>

                                            <td>${test.chercherCliniqueParId(unMedecin.idCliniqueEmploi).nom}</td>

                                        </tr>
                                    </table></td>
                                <td><form action="administrateurController" method="post">
                                        <input type="hidden" name="gestionAction" value="modifier">
                                        <input type="hidden" name="idMedecin" value="${unMedecin.numeroProfessionel}">
                                        <input type="submit" value="Modifier">
                                    </form> </td>
                            <tr>
                                <td><form action="administrateurController" method="post">
                                        <input type="hidden" name="gestionAction" value="supprimer">
                                        <input type="hidden" name="idMedecin" value="${unMedecin.numeroProfessionel}">
                                        <input type="submit" value="Supprimer">
                                    </form> </td></td>
                            </tr>

                            </tr>
                        </table>
                        </br>
                    </c:forEach>
                        </div>
                </c:when>
                <c:otherwise>
                    </br></br>
                    <H1 style="text-align:center;">Il n'y a aucun médecin dans la liste </H1>
                    </c:otherwise>
                </c:choose>
        </div>



    </body>

    <jsp:include page="pied.jsp"/>

</html>
