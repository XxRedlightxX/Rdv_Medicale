

<%@page import="com.medic.entities.Medecin"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  



<%@page import="java.util.ArrayList"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width,initial-scale=1.0">
        <title>Medecin</title>

        <link rel="stylesheet" href="style.css">

    </head>

    <jsp:include page="EnTete.jsp"/>

    <body id="body">
        <div id="tab">

            <div class="container">

                <div class="section">

                    <table >
                        <tr>
                            <td>
                                <h2>Définir les créneaux de disponibilité:</h2>
                            </td>
                            <td><button onclick="document.getElementById('calForm').style.display = 'block'">Calendrier</button>

                                <form id="calForm" style="display: none;">
                                    <label for="date">Date:</label>
                                    <input type="date" id="date" name="date"><br><br>
                                    <label for="heureD">Heure debut: </label>
                                    <input type="time" id="heurD" name="heureD"><br><br>
                                    <label for="heureD">Heure Fin: </label>
                                    <input type="time" id="heurF" name="heureF"><br><br>
                                    <button type="button" onclick="ajouterCreneau()">Ajouter cr?neau</button>
                                </form></td>

                        </tr>


                        <tr>
                            <td>
                                <h2>Modifier les créneaux:</h2>
                            </td>
                            <td>  

                                <button onclick="afficherTab">Calendrier</button>



                                <table id="creneaux-table">
                                    <thead>
                                        <tr>
                                            <th>Date</th>
                                            <th>Heure de debut</th>
                                            <th>Heure de fin</th>
                                            <th>Actions</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    </tbody>
                                </table>


                            </td>
                        <tr>
                            <td>
                                <h2>  <a href="xyz.html">Prendre un rendez-vous avec un patient</a></h2>
                            </td>
                        </tr>
                        <tr>
                            <td> 
                                <h2> <a href="#" onclick="afficherBlock()">Envoyer une invitation a un patient:</a></h2>
                                <div id="block" style="display:none;">
                                    <h4>Chercher un patient par nom</h4>
                                    <form action="patientControlleur" method="get"> 
                                        <input type="search" name="nom">
                                        <input type="submit"  value="nom" />
                                    </form>

                                </div>

                            </td>
                        </tr>
                        <tr>
                            <td>

                                <h2> <a href="#" onclick="afficherMontant()">Tarif de rendez-vous:</a></h2>
                                <div id="montant" style="display:none;">
                                    <h3>Fixer le tarif</h3>
                                    <form action="medecinControlleur" method="get"> 
                                    <input type="number" id="tarif" name="tarif" min="0" max="9999" >
                                     <input type="submit"  value="tarif" /> 
                                    
                                </div>
                            </td>
                        </tr>

                    </table>

                </div>
                <div class="section">
                    <h2 id="infoTitre">information du medecine</h2>

                    <div>
                        <img src="imageWeb2/med.png" height="100" width=110>
                    </div>

                    <div id="courriel">
                        <h2>Vous avez un courriel de:</h2>
                    </div>


                </div>

            </div>


        </div>



        <script>
            // DIFENIR Tableau pour stocker les cr?neaux de disponibilit?
            var creneaux = [];

            function ajouterCreneau() {
                // R?cup?rer les valeurs saisies dans le formulaire
                var date = document.getElementById("date").value;
                var heurDebut = document.getElementById("heurD").value;
                var heurFin = document.getElementById("heurF").value;

                // Ajouter le cr?neau au tableau
                creneaux.push({
                    date: date,
                    startTime: heurDebut,
                    endTime: heurFin
                });

                // Mettre ? jour le tableau HTML
                var tbody = document.getElementById("creneaux-table").getElementsByTagName('tbody')[0];
                var newRow = tbody.insertRow();//ajouter une row vide
                var dateCell = newRow.insertCell();//inserer celle dans 1er cell
                dateCell.appendChild(document.createTextNode(date));
                var startTimeCell = newRow.insertCell();
                startTimeCell.appendChild(document.createTextNode(heurDebut));
                var endTimeCell = newRow.insertCell();
                endTimeCell.appendChild(document.createTextNode(heurFin));
                var actionsCell = newRow.insertCell();
                var supprimerButton = document.createElement("button");
                supprimerButton.appendChild(document.createTextNode("Supprimer"));
                supprimerButton.onclick = function () {
                    // Retirer le cr?neau du tableau
                    //creneaux.splice(creneaux.indexOf(creneau), 1);

                    // Retirer la ligne du tableau HTML
                    tbody.removeChild(newRow);
                };
                actionsCell.appendChild(supprimerButton);

                // R?initialiser le formulaire
                document.getElementById("date").value = "";
                document.getElementById("heurD").value = "";
                document.getElementById("heurF").value = "";
            }



            function afficherTab() {
                // new function to show table
                var table = document.getElementById("creneaux-table");
                if (table.style.display === "table") {
                    table.style.display = "none";
                } else {
                    table.style.display = "table";
                }
            }

            function afficherMontant() {
                document.getElementById("montant").style.display = "block";
            }

            function   afficherBlock() {
                document.getElementById("block").style.display = "block";
            }


             
        </script> 

        <c:forEach items="${rechercheListePatient}" var="patient">
            <p>Patient: ${patient.nom}</p>
            <label>Envoyer lui une invitation: </label>
            <input id="invitation" name="invitation">
<%-- Récupérer la liste depuis la session --%>
<%
List<Medecin> listeMedecins = (List<Medecin>) session.getAttribute("listeMedecins");
%>

<%-- Afficher la liste en utilisant une boucle forEach --%>
<ul>
    <% for (Medecin medecin : listeMedecins) { %>
        <li>Nom: <%= medecin.getNom() %>, Prénom: <%= medecin.getPrenom() %>, Sp

        </c:forEach>

    </body>

    <jsp:include page="pied.jsp"/>

</html>