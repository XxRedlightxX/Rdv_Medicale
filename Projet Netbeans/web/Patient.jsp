<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@page import="java.util.ArrayList"%>
<%@page import="com.medic.entities.Patient"%>
<%@page import="com.medic.service.PatientService"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1.0">
    <title>Patient</title>

    <link rel="stylesheet" href="style.css">

</head>
<jsp:include page="EnTete.jsp"/>

<jsp:useBean id="patientTest" class="com.medic.service.PatientService"/>

<body id="body">


    <div><br>
        <h1 style="margin-right: 75%">Profil patient: </h1> 
        <table id="tableService">
            <tr id="serviceRow">
                <td>
                    <h2><a href="xyz" class="services">Votre nom :</a></h2>
                    ${patientTest.chercherParAssuranceMaladie(username).prenom} ${patientTest.chercherParAssuranceMaladie(username).nom}
                </td>
                <td>
                    <h2><a href="xyz" class="services">Numéro d'assurance maladie</a></h2>
                    ${patientTest.chercherParAssuranceMaladie(username).numeroAssuranceMaladie}
                    
                </td>
            </tr>
            <tr id="serviceRow">
                <td>
                    <h2><a href="xyz" class="services">Date de naissance</a></h2>
                    ${patientTest.chercherParAssuranceMaladie(username).dateNaissance}
                </td>
                <td>
                    <h2><a href="xyz" class="services">Numéro séquentiel</a></h2>
                    ${patientTest.chercherParAssuranceMaladie(username).numeroSequentiel}
                </td>
            </tr>
            <tr id="serviceRow">
                <td>
                    <h2><a href="xyz" class="services">Sexe</a></h2>
                    ${patientTest.chercherParAssuranceMaladie(username).sexe}
                </td>
            </tr>
            <tr id="serviceRow">
                <td>
                    <h2><a href="xyz" id="services">Clinique pres de chez soi (Code Postal):</a></h2>
                </td>
            </tr>
        </table>


    </div>


    <button id="souF" type="submit">Soumettre formulaire</button>
    
</body> 
${requestScope.reeee}

<jsp:include page="pied.jsp"/>

</html>