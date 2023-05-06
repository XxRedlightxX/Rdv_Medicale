<%@page import="com.medic.service.MedecinService"%>
<%@page import="com.medic.entities.Medecin"%>
<%@page import="com.medic.entities.Patient"%>
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
            <h1 id="etatPatient">${requestScope.message}</h1>
        </div>
    </c:if>

    <body id="body">
        <div></br>
            <form action="administrateurController" method="get">
                <input type="hidden" name="gestionAction" value="ajouter">
                <input type="hidden" name="idPatient" value="00">
                <input type="submit" value="Ajouter un Patient">
            </form>
        </div>
        <br>
        <div id="containerListe" style="height:60vh;overflow:auto;">   
            <h1 style="margin-right: 50%">Patients: </h1>
                <c:choose>
                    <c:when test= "${not empty sessionScope.listePatients}">
                    <div>
                        <a href="pageAdminMedecins.jsp"></a>
                        <c:forEach var="unPatient" items="${sessionScope.listePatients}" >
                        <table style="border: 1px solid black;border-radius: 10px;width:60%;margin: auto;background-color: white">
                            <tr>
                                <td rowspan="2"><img src="imageWeb2/patient_icon.png" alt="Trulli" width="125" height="125"></td>
                                <td rowspan="2"><table>
                                        <tr>
                                            <th>Nom:</th>
                                            <td>${unPatient.nom}</td>
                                            <th>Numero d'assurance maladie:</th>
                                            <td>${unPatient.numeroAssuranceMaladie}</td>
                                        </tr>
                                        <tr>
                                            <th>Prenom:</th>
                                            <td>${unPatient.prenom}</td>
                                            <th>Numéro séquentiel:</th>
                                            <td>${unPatient.numeroSequentiel}</td>
                                        </tr>
                                        <tr>
                                            <th>Date de naissance:</br></th>
                                            <td>${unPatient.dateNaissance}</td>
                                            <th>Sexe:</th>
                                            <td>${unPatient.sexe}</td>
                                        </tr>
                                        <tr>
                                            <th>Nom du médecin de famille:</th>
                                                <jsp:useBean id="medecinTest" class="com.medic.service.MedecinService"/>
                                     
                                            <c:if test = "${unPatient.idMedecinFamille != 0}">
                                            <td>Dr. ${medecinTest.chercherMedecinParId(unPatient.idMedecinFamille).prenom} ${medecinTest.chercherMedecinParId(unPatient.idMedecinFamille).nom} </td>
                                            </c:if>
                                            
                                            <c:if test = "${unPatient.idMedecinFamille == 0}">
                                            <td>Aucun</td>
                                            </c:if>
                             

                                       
                                        </tr>
                                    </table></td>
                                <td><form action="administrateurController" method="post">
                                        <input type="hidden" name="gestionAction" value="modifier">
                                        <input type="hidden" name="idPatient" value="${unPatient.id}">
                                        <input type="submit" value="Modifier">
                                    </form> </td>
                            <tr>
                                <td><form action="administrateurController" method="post">
                                        <input type="hidden" name="gestionAction" value="supprimer">
                                        <input type="hidden" name="idPatient" value="${unPatient.id}">
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
                    <H1 style="text-align:center;">Il n'y a aucun patient dans la liste </H1>
                    </c:otherwise>
                </c:choose>
        </div>



    </body>

    <jsp:include page="pied.jsp"/>

</html>
