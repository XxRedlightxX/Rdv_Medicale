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

        <div>   
            <H1 style="margin-right: 50%">Patients: </H1>
            <table style="border: 1px solid black;border-radius: 10px;width:60%;margin: auto;background-color: white">
                <tr>
                    <td rowspan="2"><img src="imageWeb2/patient_vide.png" alt="Trulli" width="125" height="125"></td>
                    <td rowspan="2"><table>
                            <tr>
                                <th>Nom:</th>
                                <td>Bertrand</td>
                                <th>Numero d'assurance maladie:</th>
                                <td>JOSH2131</td>
                            </tr>
                            <tr>
                                <th>Prenom:</th>
                                <td>Bob</td>
                                <th>Numéro séquentiel:</th>
                                <td>03</td>
                            </tr>
                            <tr>
                                <th>Date de naissance:</br></th>
                                <td>2001-04-14</td>
                                <th>Sexe:</th>
                                <td>M</td>
                            </tr>
                            <tr>
                                <th>Nom du médecin de famille:</th>
                                <td>Bob Tremblay</td>
                            </tr>
                        </table></td>
                    <td><form action="administrateurController" method="post">
                            <input type="hidden" name="gestionAction" value="modifier">
                            <input type="hidden" name="idPatient" value="10">
                            <input type="submit" value="Modifier">
                        </form> </td>
                <tr>
                    <td><form action="administrateurController" method="post">
                            <input type="hidden" name="gestionAction" value="supprimer">
                            <input type="hidden" name="idPatient" value="10">
                            <input type="submit" value="Supprimer">
                        </form> </td></td>
                </tr>

                </tr>
            </table>
            </br>
        </div>

        <div></br>
                <form action="administrateurController" method="post">
                    <input type="hidden" name="gestionAction" value="ajouter">
                    <input type="hidden" name="idPatient" value="10">
                    <input type="submit" value="Ajouter un Patient">
                </form>
        </div>
    </body>
    <jsp:include page="pied.jsp"/>

</html>