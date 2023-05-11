<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List" %>
<%@page import="com.medic.entities.Medecin"%>
<%@page import="com.medic.entities.Patient"%>
<%@page import="com.medic.service.MedecinService"%>



<!DOCTYPE html>

<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width,initial-scale=1.0">
        <title>Connexion</title>
        <script src="http://code.jquery.com/jquery-1.12.0.min.js"></script>
        <script src="http://cdn.jsdelivr.net/jquery.validation/1.14.0/jquery.validate.min.js"></script>

        <link rel="stylesheet" href="style.css">
        <style>
            .error {
                color: red;
            }

            input.error {
                border: 1px solid red;
            }
        </style>
    </head>
    <jsp:include page="EnTete.jsp" />

    <body id="body">
        <jsp:useBean id="unPatient" class="com.medic.service.PatientService"/>
        <jsp:useBean id="unMedecin" class="com.medic.service.MedecinService"/>
        <jsp:useBean id="medecinTest" class="com.medic.service.MedecinService"/>
        <jsp:useBean id="cliniqueTest" class="com.medic.service.CliniqueService"/>
        <c:set var="rendezVous" value="${requestScope.unRendezVous}"/>  

    </style>


    <c:choose>
        <c:when test="${requestScope.typeAction == 'ajouter'}">
            <div id=ls>
                <h1 id="etatPatient">Confirmation du rendez-vous</h1>

            </div> <br>
            <div>
                <div style="text-align:left;margin-left: auto;margin-right: auto;width: 13%;">
                    Pour : ${unPatient.chercherPatientParId(requestScope.idPatient).prenom} ${unPatient.chercherPatientParId(requestScope.idPatient).nom}</br></br>
                    Médecin : Dr.${unMedecin.chercherMedecinParId(requestScope.idMedecin).prenom} ${unMedecin.chercherMedecinParId(requestScope.idMedecin).nom}</br></br>
                    Date du rendez-vous : ${requestScope.dateRv} </br></br>
                    Heure : ${requestScope.heureRv}:00</br></br>
                    <form action="rendezVousController">
                        <input type="hidden" name="idPatient" value="${requestScope.idPatient}">
                        <input type="hidden" name="idMedecin" value="${requestScope.idMedecin}">
                        <input type="hidden" name="dateRv" value="${requestScope.dateRv}">
                        <input type="hidden" name="heureRv" value="${requestScope.heureRv}">
                        <label for="raisonConsult">Raison de la consultation :</label></br></br>
                        <select name="raisonConsult" id="raisonConsult">
                            <option value="Urgence mineure">Urgence mineure</option>
                            <option value="Consultation propriétaire">Consultation propriétaire</option>
                            <option value="Suivi périodique ou préventif">Suivi périodique ou préventif</option>
                            <option value="Suivi régulier">Suivi régulier</option>
                            <option value="Suivi de grossesse">Suivi de grossesse</option>
                            <option value="Suivi d’un enfant 0 à 5 ans">Suivi d’un enfant 0 à 5 ans</option>
                        </select></br></br>
                        <label for="descriptionConsult">Description de la raison :</label></br></br>
                        <textarea style="width:25vh;height:15vh;" id="descriptionConsult" name="descriptionConsult" placeholder="Description de la raison.." style="height:200px"></textarea>

                </div>
                </br>
                <h2 style="text-align:center"> Voulez confirmer ce rendez-vous ?</h2></br>


                <input type="hidden" name="actionRv" value="ajouter">
                <input style="width:100px;" type="submit" value="Réserver">
                </form> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

                <form style="display:inline;" action="PriseRendezVous.jsp" method="post">
                    <input style="width:100px;" type="submit" value="Annuler">
                </form>
            </div>                     
        </c:when>
        <c:when test="${requestScope.typeAction == 'modifier'}">
            <div id=ls>
                <h1 id="etatPatient">Modification du rendez-vous</h1>

            </div> <br>
            <div>
                <div style="text-align:left;margin-left: auto;margin-right: auto;width: 15%;">
                    Pour : ${unPatient.chercherPatientParId(requestScope.unRendezVous.idPatientRv).prenom} ${unPatient.chercherPatientParId(requestScope.unRendezVous.idPatientRv).nom}</br></br>
                    Médecin : Dr.${unMedecin.chercherMedecinParId(requestScope.unRendezVous.idMedecinRv).prenom} ${unMedecin.chercherMedecinParId(requestScope.unRendezVous.idMedecinRv).nom}</br></br>
                    Date du rendez-vous : ${requestScope.unRendezVous.dateRv} </br></br>
                    Heure : ${requestScope.unRendezVous.heureRv}:00<br><br>




                        <Button onclick="sauvegarderChangements()">Changer la date et l'heure du rendez-vous</Button><br><br>



                    <form action="rendezVousController">
                        <input id="saveidRendezVous" type="hidden" name="idRendezVous" value="${requestScope.unRendezVous.idRendezVous}">
                        <input id="saveidPatient" type="hidden" name="idPatient" value="${requestScope.unRendezVous.idPatientRv}">
                        <input id="saveidMedecin"type="hidden" name="idMedecin" value="${requestScope.unRendezVous.idMedecinRv}">
                        <input id="savedateRv"type="hidden" name="dateRv" value="${requestScope.unRendezVous.dateRv}">
                        <input id="saveheureRv"type="hidden" name="heureRv" value="${requestScope.unRendezVous.heureRv}">
                        <label for="raisonConsult">Raison de la consultation :</label></br></br>
                        <select name="raisonConsult" id="raisonConsult">
                            <option value="Urgence mineure"<c:if test="${requestScope.unRendezVous.raisonConsult == 'Urgence mineure'}">selected="selected"</c:if> >Urgence mineure</option>
                            <option value="Consultation propriétaire" <c:if test="${requestScope.unRendezVous.raisonConsult == 'Consultation propriétaire'}">selected="selected"</c:if> >Consultation propriétaire</option>
                            <option value="Suivi périodique ou préventif" <c:if test="${requestScope.unRendezVous.raisonConsult == 'Suivi périodique ou préventif'}">selected="selected"</c:if> >Suivi périodique ou préventif</option>
                            <option value="Suivi régulier" <c:if test="${requestScope.unRendezVous.raisonConsult == 'Suivi régulier'}">selected="selected"</c:if> >Suivi régulier</option>
                            <option value="Suivi de grossesse" <c:if test="${requestScope.unRendezVous.raisonConsult == 'Suivi de grossesse'}">selected="selected"</c:if> >Suivi de grossesse</option>
                            <option value="Suivi d’un enfant 0 à 5 ans" <c:if test="${requestScope.unRendezVous.raisonConsult == 'Suivi d’un enfant 0 à 5 ans'}">selected="selected"</c:if> >Suivi d’un enfant 0 à 5 ans</option>
                        </select></br></br>
                        <label for="descriptionConsult">Description de la raison :</label></br></br>
                        <textarea style="width:30vh;height:10vh;" id="descriptionConsult" name="descriptionConsult" style="height:200px">${requestScope.unRendezVous.descriptionConsult}</textarea>

                </div>
                </br>
                <h2 style="text-align:center"> Voulez vous modifier ce rendez-vous ?</h2></br>


                <input type="hidden" name="actionRv" value="modifier">
                <input style="width:100px;" type="submit" value="Sauvegarder">
                </form> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

                <form style="display:inline;" action="pagePatientRendezVous.jsp" method="post">
                    <input style="width:100px;" type="submit" value="Annuler">
                </form>
            </div>                     
        </c:when>
        <c:when test="${requestScope.typeAction == 'supprimer'}">
            <div id=ls>
                <h1 id="etatPatient">Annulation du rendez-vous</h1>

            </div> <br>
            <c:if test="${not empty requestScope.unRendezVous}">
                <div>
                    <table style="margin-left: auto;margin-right: auto;width: 100%;">
                        <tr>
                        <tr>
                            <th>Nom du Médecin :</th>
                            <td>Dr. ${medecinTest.chercherMedecinParId(requestScope.unRendezVous.idMedecinRv).prenom} ${medecinTest.chercherMedecinParId(requestScope.unRendezVous.idMedecinRv).nom}</td>
                        </tr>
                        <tr>
                            <th>Date du rendez-vous</th>
                            <td>${requestScope.unRendezVous.dateRv}</td>
                        </tr>
                        <tr>
                            <th>Clinique</th>
                            <td>${cliniqueTest.chercherCliniqueParId(medecinTest.chercherMedecinParId(requestScope.unRendezVous.idMedecinRv).idCliniqueEmploi).nom}</td>
                        </tr>
                        <tr>
                            <th>Adresse</th>
                            <td>${cliniqueTest.chercherCliniqueParId(medecinTest.chercherMedecinParId(requestScope.unRendezVous.idMedecinRv).idCliniqueEmploi).coordonnees}</td>
                        </tr>
                        <tr>
                            <th>Heure :</th>
                            <td>${requestScope.unRendezVous.heureRv}:00</td>
                        </tr>
                        <tr>
                            <th>Raison de la Consultation :</th>
                            <td>${requestScope.unRendezVous.raisonConsult}</td>

                        </tr>
                        <tr>
                            <th>Description de la consultation :</th>
                            <td>${requestScope.unRendezVous.descriptionConsult}</td>
                        </tr>
                    </table>
                </div>
                </br>

                <h2 style="text-align:center"> Voulez vous supprimer ce rendez-vous ?</h2></br>
                <form action="rendezVousController" method="post">
                    <input type="hidden" name="idRendezVous" value="${unRendezVous.idRendezVous}">
                    <input type="hidden" name="actionRv" value="supprimer">
                    <input style="width:100px;" type="submit" value="Supprimer">
                </form> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

                <form style="display:inline;" action="pagePatientRendezVous.jsp" method="post">
                    <input style="width:100px;" type="submit" value="Annuler">
                </form>
            </div>    
        </c:if>
    </c:when>
</c:choose>

</body>


<jsp:include page="pied.jsp" />
<script>
    function sauvegarderChangements(){
        var idRendezVous = document.getElementById("saveidRendezVous").value;
        var idPatient = document.getElementById("saveidPatient").value;
        var idMedecin = document.getElementById("saveidMedecin").value;
        var dateRv = document.getElementById("savedateRv").value;
        var heureRv = document.getElementById("saveheureRv").value;
        var raisonConsult = document.getElementById("raisonConsult").value;
        var descriptionConsult = document.getElementById("descriptionConsult").value;
        
        window.location.href = "rendezVousController?actionRv=changerTemps&idRendezVous="+idRendezVous+"&idPatient="+idPatient+"&idMedecin="+idMedecin+"&dateRv="+
                dateRv+"&heureRv="+heureRv+"&raisonConsult="+raisonConsult+"&descriptionConsult="+descriptionConsult;
    }
</script>
<script src="javaScript/formValidation.js"></script>

</html>
