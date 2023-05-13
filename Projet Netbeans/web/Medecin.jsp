

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@page import="java.util.ArrayList"%>
<%@page import="com.medic.entities.Clinique"%>
<%@page import="com.medic.entities.Medecin"%>

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
    <jsp:useBean id="medecinTest" class="com.medic.service.MedecinService"/>
    <h1>Bonjour Dr ${medecinTest.chercherMedecinParId(username).nom}</h1>
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
                                
                                <form id="calForm" style="display: none;" action="dispoMedecinController">
                                    <label for="date">Date:</label>
                                    <input type="date" id="date" name="date"><br><br>
                                    <label for="heureD">Heure debut: </label>
                                    <select id="heureD" name="heureD" form="calForm">
                                        <c:forEach var="uneHeureD" begin="6" end="20">
                                        <option value="${uneHeureD}">${uneHeureD}:00</option>
                                        </c:forEach>
                                    </select><br><br>
                                    <label for="heureF">Heure Fin: </label>
                                    <select id="heureF" name="heureF" form="calForm">
                                        <c:forEach var="uneHeureF" begin="6" end="20">
                                        <option value="${uneHeureF}" <c:if test ="${uneHeureF == 18}">selected="selected"</c:if>>${uneHeureF}:00</option>
                                        </c:forEach>
                                    </select><br><br>
                                    <input type="submit" value="Ajouter créneau">
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
                                    <form action="testController" method="get"> 
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
                                    <p>${medecinTest.chercherMedecinParId(username).facturation}<br> $<p>
                                    <input type="number" id="tarif" name="tarif" min="0" max="9999">
                                    <button onclick="validerTarif()">Valider</button>
                                    
                                  
                                </div>
                                    <form action="medecinGestionController" method="get">
                                        <input type="hidden" name="gestionAction" value="modifier">
                                        <input type="hidden" name="idMedecin" value="${sessionScope.username}">
                                        <input type="submit" value="Modifier">
                                    </form> </td>
                                    ${sessionScope.username}
                        <h1>
                        <h1>
                            
                        </tr>

                    </table>

                </div>
                <div class="section">
                    <h2 id="infoTitre">information du medecine</h2>
                    <div> ${medecinTest.chercherMedecinParId(username).prenom} ${medecinTest.chercherMedecinParId(username).nom}</div>
                    <div> ${medecinTest.chercherMedecinParId(username).specialite}</div>
                    <div> ${medecinTest.chercherMedecinParId(username).coordonnees}</div>
                    <div> ${medecinTest.chercherMedecinParId(username).idCliniqueEmploi}</div>
                    <div>Clinique où médecin est employé:</div>
                    <form action="administrateurController" method="get">
                    </form>
                    <c:choose>
                    <c:when test= "${not empty sessionScope.listeMedecins}">
                    <jsp:useBean id="test5" class="com.medic.service.CliniqueService"/>
                                         <c:forEach var="unMedecin" items="${sessionScope.listeMedecins}" >
                                            
                                            <c:if test = "${unMedecin.idCliniqueEmploi != 0}">
                                            <div>${test5.chercherCliniqueParId(unMedecin.idCliniqueEmploi).nom}</div>
                                            </c:if>
                                            <c:if test = "${unMedecin.idCliniqueEmploi == 0}">
                                            <td>Aucun</td>
                                            </c:if>
                                            </c:forEach>
                                                
                                                            
                                            
                                
                    
                                            <</c:when>
                                            </c:choose>
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


            function validerTarif() {
                var tarif = document.getElementById("tarif").value;
                alert("Le tarif a tarif fix " + tarif + " dollars.");
                document.getElementById("montant").style.display = "none";
            }

        </script>

        <c:forEach items="${requestScope.listePatient}" var="patient">
            <p>${patient.nom}</p>
        </c:forEach>

    </body>

    <jsp:include page="pied.jsp"/>

</html>