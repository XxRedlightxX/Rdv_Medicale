<%@page import="com.medic.service.MedecinService"%>
<%@page import="com.medic.service.RendezVousService"%>
<%@page import="com.medic.entities.RendezVous"%>
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
            table {
                font-family: arial, sans-serif;
                border-collapse: collapse;
                margin-left: auto;
                margin-right: auto;
                width: 50%;

            }

            td, th {
                border: 1px solid #dddddd;
                text-align: left;
            }

            th {
                width: 50%;
            }


        </style>

    </head>

    <jsp:include page="EnTete.jsp"/>    
    <jsp:useBean id="medecinTest" class="com.medic.service.MedecinService"/>
    <jsp:useBean id="patientTest" class="com.medic.service.PatientService"/>
    <jsp:useBean id="rendezVous" class="com.medic.service.RendezVousService"/>
    <jsp:useBean id="cliniqueTest" class="com.medic.service.CliniqueService"/>
    <h2 style="text-align:center;color: black;">Rendez-vous pour ${patientTest.chercherParAssuranceMaladie(sessionScope.username).prenom} ${patientTest.chercherParAssuranceMaladie(sessionScope.username).nom}</h2>
    <div style="height:65vh;overflow:auto;">
        <body id="body">
            </br>
            <br>
            <c:forEach var="unRendezVous" items="${rendezVous.chercherToutLesRendezVousIdPatient(patientTest.chercherParAssuranceMaladie(sessionScope.username).id)}" >
                <table style="border-radius: 10px;margin-left:35%">
                    <td style="width:70vh;background-color: white;"><table style="margin-left: auto;margin-right: auto;width: 100%;">
                            <tr>
                                <tr>
                                    <th>Nom du Médecin :</th>
                                    <td>Dr. ${medecinTest.chercherMedecinParId(unRendezVous.idMedecinRv).prenom} ${medecinTest.chercherMedecinParId(unRendezVous.idMedecinRv).nom}</td>
                                </tr>
                                <tr>
                                    <th>Date du rendez-vous</th>
                                    <td>${unRendezVous.dateRv}</td>
                                </tr>
                                <tr>
                                    <th>Clinique</th>
                                    <td>${cliniqueTest.chercherCliniqueParId(medecinTest.chercherMedecinParId(unRendezVous.idMedecinRv).idCliniqueEmploi).nom}</td>
                                </tr>
                                <tr>
                                    <th>Adresse</th>
                                    <td>${cliniqueTest.chercherCliniqueParId(medecinTest.chercherMedecinParId(unRendezVous.idMedecinRv).idCliniqueEmploi).coordonnees}</td>
                                </tr>
                                <tr>
                                    <th>Heure :</th>
                                    <td>${unRendezVous.heureRv}:00</td>
                                </tr>
                                <tr>
                                    <th>Raison de la Consultation :</th>
                                    <td>${unRendezVous.raisonConsult}</td>

                                </tr>
                                <tr>
                                    <th>Description de la consultation :</th>
                                    <td>${unRendezVous.descriptionConsult}</td>
                                </tr>
                            </table></td>
                            
                            <td style="text-align: center;border: none;"><form action="rendezVousController" method="post">
                                        <input type="hidden" name="etape1Rv" value="modifier">
                                        <input type="hidden" name="idRendezVous" value="${unRendezVous.idRendezVous}">
                                        <input type="submit" value="Modifier le rendez-vous">
                                    </form> <br><br>
                           
                                <form action="rendezVousController" method="post">
                                        <input type="hidden" name="etape1Rv" value="supprimer">
                                        <input type="hidden" name="idRendezVous" value="${unRendezVous.idRendezVous}">
                                        <input type="submit" value="Annuler le rendez-vous">
                                    </form> </td>
                            

                            
                        </table>
                <br><br>
            </c:forEach>
        </body>
        <div>

            <jsp:include page="pied.jsp"/>

            </html>
