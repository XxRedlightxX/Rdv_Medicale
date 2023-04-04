<%@page import="com.medic.service.CliniqueService"%>
<%@page import="com.medic.entities.Medecin"%>
<%@page import="com.medic.entities.Clinique"%>
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
            <h1 id="etatClinique">${requestScope.message}</h1>
        </div>
    </c:if>

    <body id="body">
        <div></br>
            <form action="administrateurController" method="get">
                <input type="hidden" name="gestionAction" value="ajouter">
                <input type="hidden" name="idClinique" value="00">
                <input type="submit" value="Ajouter une clinique">
            </form></br>
        </div>
        <div id="containerListe" style="height:60vh;overflow:auto;">   
            <h1 style="margin-right: 50%">Cliniques: </h1>
                <c:choose>
                    <c:when test= "${not empty sessionScope.listeCliniques}">
                    <div>
                        <c:forEach var="uneClinique" items="${sessionScope.listeCliniques}" >
                        <table style="border: 1px solid black;border-radius: 10px;width:50%;margin: auto;background-color: white">
                            <tr>
                                <td rowspan="2"><img src="imageWeb2/clinique_icon.png" alt="Trulli" width="125" height="125"></td>
                                <td rowspan="2"><table>
                                        <tr>
                                            <th>Nom de la clinique :</th>
                                            <td>${uneClinique.nom}</td>     
                                        </tr>
                                        <tr >
                                            <th style="width:10%">Coordonnées :</th>
                                            <td>${uneClinique.coordonnees}</td>   
                                        </tr>

                                    </table></td>
                                <td><form action="administrateurController" method="post">
                                        <input type="hidden" name="gestionAction" value="modifier">
                                        <input type="hidden" name="idClinique" value="${uneClinique.id}">
                                        <input type="submit" value="Modifier">
                                    </form> </td>
                            <tr>
                                <td><form action="administrateurController" method="post">
                                        <input type="hidden" name="gestionAction" value="supprimer">
                                        <input type="hidden" name="idClinique" value="${uneClinique.id}">
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
                    <H1 style="text-align:center;">Il n'y a aucune clinique dans la liste </H1>
                    </c:otherwise>
                </c:choose>
        </div>



    </body>

    <jsp:include page="pied.jsp"/>

</html>
