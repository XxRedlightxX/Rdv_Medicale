<%@page import="com.medic.service.PatientService"%>
<%@page import="com.medic.entities.DispoMedecin"%>
<%@page import="com.medic.service.DispoMedecinService"%>
<%@page import="com.medic.entities.RendezVous"%>
<%@page import="com.medic.service.RendezVousService"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="java.time.temporal.TemporalAdjusters"%>
<%@page import="java.time.DayOfWeek"%>
<%@page import="java.time.LocalDate"%>
<%@page import="com.medic.service.CliniqueService"%>
<%@page import="com.medic.entities.Medecin"%>
<%@page import="com.medic.entities.Patient"%>
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
            table {
                font-family: arial, sans-serif;
                border-collapse: collapse;
                width: 100%;
                background-color: white;
            }

            td {
                border: 1px solid #dddddd;
                text-align: center;
                height: 33px;
            }

            th {
                border: 1px solid #dddddd;
                text-align: center;
                padding: 8px;
                height: 20px;
            }
            input[type=submit] {
                background-color: #0E86D4;
                font-size: 15px;
                border: none;
                color: white;
                padding: 8px;
                width: 100%;
                text-decoration: none;

                cursor: pointer;
            }

            tr:nth-child(even) {
                background-color: #dddddd;
            }

        </style>

    </head>

    <jsp:include page="EnTete.jsp"/>
    <%
        LocalDate date = LocalDate.now().with(TemporalAdjusters.previous(DayOfWeek.SUNDAY));
        pageContext.setAttribute("jourSemaine", date);

    %>
    <div >
        <jsp:useBean id="daoMedecin" class="com.medic.service.MedecinService"/>
        <jsp:useBean id="daoPatient" class="com.medic.service.PatientService"/>   
        <c:set var="medecinRv" value="${daoMedecin.chercherMedecinParId(requestScope.unRendezVous.idMedecinRv).numeroProfessionel}"/>  

        <h2 >Prendre un rendez-vous a un autre moment <form action="rendezVousController" style="display:inline;float:right;margin-right: 49%">
                            <input type="hidden" name="idRendezVous" value="${unRendezVous.idRendezVous}">
                            <input type="hidden" name="idPatient" value="${unRendezVous.idPatientRv}">
                            <input type="hidden" name="idMedecin" value="${unRendezVous.idMedecinRv}">
                            <input type="hidden" name="raisonConsult" value="${unRendezVous.raisonConsult}">
                            <input type="hidden" name="descriptionConsult" value="${unRendezVous.descriptionConsult}">
                            <input type="hidden" name="dateRv" value="${unRendezVous.dateRv}">
                            <input type="hidden" name="heureRv" value="${unRendezVous.heureRv}">
                            <input type="hidden" name="etape1Rv" value="modifier2">
                            <input style="all:revert" type="submit" value="Annuler le changement">
                        </form> </h2>
    </div>
    <body id="body">
        <div style="overflow: auto;height:70vh">
            <table>
                <tr>
                    <th></th>
                    <th>Dimanche</th>
                    <th>Lundi</th>
                    <th>Mardi</th>
                    <th>Mercredi</th>
                    <th>Jeudi</th>
                    <th>Vendredi</th>
                    <th>Samedi</th>
                </tr>
                <tr>
                    <th></th>
                    <th>${jourSemaine.plusDays(0)}</th>
                    <th>${jourSemaine.plusDays(1)}</th>
                    <th>${jourSemaine.plusDays(2)}</th>
                    <th>${jourSemaine.plusDays(3)}</th>
                    <th>${jourSemaine.plusDays(4)}</th>
                    <th>${jourSemaine.plusDays(5)}</th>
                    <th>${jourSemaine.plusDays(6)}</th>
                </tr>
                <% for (int i = 6; i <= 20; i++) {%>
                <tr>
                    <td><%=i%>:00</td>
                    <% for (int j = 0; j <= 6; j++) {%>
                    <td><%
                        PatientService patientDao = new PatientService();
                        int idMedecinFamille = Integer.valueOf("" + pageContext.getAttribute("medecinRv"));

                        RendezVousService rendezVousDao = new RendezVousService();
                        RendezVous unRendezVous = null;
                        unRendezVous = rendezVousDao.verifierRendezVousPris(idMedecinFamille, date.plusDays(j).toString(), String.valueOf(i));

                        DispoMedecinService dispoMedecinDao = new DispoMedecinService();
                        DispoMedecin uneDispo = null;
                        uneDispo = dispoMedecinDao.verifierExistanceDispoMedecin(idMedecinFamille, date.plusDays(j).toString());;
                        boolean heureDansDispo = false;

                        if (uneDispo != null) {
                            if ((i >= Integer.parseInt(uneDispo.getHeureDispoDebut())) && (i <= Integer.parseInt(uneDispo.getHeureDispoFin()))) {
                                heureDansDispo = true;
                            } else {
                                heureDansDispo = false;
                            }
                        }
                        if (unRendezVous != null) {%>
                        Déja réservé<%
                        } else if (heureDansDispo == true) {%>
                        <form action="rendezVousController" style="display: block;margin-left: auto;margin-right: auto;width: 65%;">
                            <input type="hidden" name="idRendezVous" value="${unRendezVous.idRendezVous}">
                            <input type="hidden" name="idPatient" value="${unRendezVous.idPatientRv}">
                            <input type="hidden" name="idMedecin" value="${unRendezVous.idMedecinRv}">
                            <input type="hidden" name="raisonConsult" value="${unRendezVous.raisonConsult}">
                            <input type="hidden" name="descriptionConsult" value="${unRendezVous.descriptionConsult}">
                            <input type="hidden" name="dateRv" value="<%=date.plusDays(j).toString()%>">
                            <input type="hidden" name="heureRv" value="<%=i%>">
                            <input type="hidden" name="etape1Rv" value="modifier2">
                            <input type="submit" value="Disponible">
                        </form> 
                        <%} else {%><%}
                        %>
                    </td>
                    <%}%>
                </tr>
                <%}%>

            </table>
        </div>

    </body>

    <jsp:include page="pied.jsp"/>

</html>
