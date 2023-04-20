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

        
        </style>
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
                        <input style="width:25vh" type="text" id="raisonConsult" name="raisonConsult" placeholder="Raison de la consultation.."></br></br>
                        <label for="descriptionConsult">Description de la raison :</label></br></br>
                        <textarea style="width:25vh;height:15vh;" id="descriptionConsult" name="descriptionConsult" placeholder="Description de la raison.." style="height:200px"></textarea>

                </div>
                </br>
                <h2 style="text-align:center"> Voulez confirmer ce rendez-vous ?</h2></br>
            
           
                <input type="hidden" name="ajouterRv" value="1">
                <input style="width:100px;" type="submit" value="Réserver">
            </form> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

            <form style="display:inline;" action="PriseRendezVous.jsp" method="post">
                <input style="width:100px;" type="submit" value="Annuler">
            </form>
            </div>


    </body>


    <jsp:include page="pied.jsp" />
    <script src="javaScript/formValidation.js"></script>

</html>