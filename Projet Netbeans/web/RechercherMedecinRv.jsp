<%-- 
    Document   : CliniqueInfo
    Created on : 2023-04-07, 17:46:38
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSPdsds Page</title>
        <link rel="stylesheet" href="style.css">
    </head>
    <style>
        th {
            text-align: left;
        }
        tr tr td {
            text-align: left;
        }
    </style>
    <jsp:include page="EnTete.jsp"/>




    <body>
        <jsp:useBean id="test" class="com.medic.service.MedecinService"/>
        <jsp:useBean id="daoPatient" class="com.medic.service.PatientService"/>
        <jsp:useBean id="test2" class="com.medic.service.ServicesCliniqueService"/>
        <jsp:useBean id="test3" class="com.medic.service.CliniqueService"/>
        <div style="font-size: 14px;float: left">
            <div>
                <h4>Rendez-vous avec un médecin du même GMF</h4>
                <form action="choixMedecinRendezVousController" method="get">   
                    <input type="hidden" name="typeRecherche" value="filtrerGMF">
                    <input type="hidden" name="medecinGMF" value="${test.chercherMedecinParId(daoPatient.chercherParAssuranceMaladie(sessionScope.username).idMedecinFamille).idCliniqueEmploi}">   
                    <input type="submit"  value="Afficher les médecins" />
                </form>
            </div>

            <div>
                <h4 >Filter par spécialité du médecin</h4>
                <form action="choixMedecinRendezVousController" method="get">   
                    <input type="hidden" name="typeRecherche" value="filtrerSpecialite">
                    <c:forEach var="unService" items="${test2.afficherServicesClinique()}" >
                        <input type="radio" name="nomSpecialite" value="${unService.nom}"/> <label>${unService.nom}</label> <br>
                    </c:forEach><br>
                    <input type="submit"  value="Filtrer" />
                </form>
            </div>
            <div >
                <h4 >Filter par cliniques</h4>
                <form action="choixMedecinRendezVousController" method="get">   
                    <input type="hidden" name="typeRecherche" value="filtrerClinique">
                    <c:forEach var="uneClinique" items="${test3.afficherLesCliniques()}" >
                        <input type="radio" name="nomClinique" value="${uneClinique.nom}"/> <label>${uneClinique.nom}</label> <br>
                    </c:forEach><br>
                    <input type="submit"  value="Filtrer" />
                </form>
            </div>
            <div>
                <h4 >Filtrer par prix</h4>
                <form action="choixMedecinRendezVousController" method="get">
                    <input type="hidden" name="typeRecherche" value="filtrerPrix">
                    <input type="radio" name="prixRecherche" value="0-25"/> <label>0-25$</label> <br>
                    <input type="radio" name="prixRecherche" value="25-50"/> <label>25-50$</label> <br>
                    <input type="radio" name="prixRecherche" value="50-100"/> <label>50-100$</label> <br>
                    <input type="radio" name="prixRecherche" value="100-200"/> <label>100-200$</label> <br>
                    <input type="radio" name="prixRecherche" value="200+"/> <label>200$ et plus</label> <br><br>
                    <input type="submit"  value="Filtrer" />
                </form>
            </div>
        </div>
        <jsp:useBean id="rechercheTest" class="com.medic.service.CliniqueService"/>
        <c:choose>
            <c:when test = "${not empty requestScope.listeMedecinRecherche}">    
                <c:forEach var="medecinRecherche" items="${listeMedecinRecherche}">
                    <div>
                        <table style="border: 1px solid black;border-radius: 10px;width:35%;background-color: white;float:left;margin: 30px">

                            <td rowspan="2"><img src="imageWeb2/patient_icon.png" alt="Trulli" width="125" height="125"></td>
                            <td rowspan="2"><table>
                                    <tr>
                                        <th>Nom :</th>
                                        <td>${medecinRecherche.nom}</td>

                                    </tr>
                                    <tr>
                                        <th>Prenom :</th>
                                        <td>${medecinRecherche.prenom}</td>
                                        <th>Spécialitée :</th>
                                        <td>${medecinRecherche.specialite}</td>
                                    </tr>
                                    <tr>
                                        <th>Facturation :</br></th>
                                        <td>${medecinRecherche.facturation} $</td>
                                        <th>Coordonnées :</th>
                                        <td>${medecinRecherche.coordonnees}</td>
                                    </tr>
                                    <tr>
                                        <th style="width:150px" >Clinique où médecin est employé :</th>



                                        <c:if test = "${medecinRecherche.idCliniqueEmploi != 0}">
                                            <td>${rechercheTest.chercherCliniqueParId(medecinRecherche.idCliniqueEmploi).nom}</td>
                                        </c:if>

                                        <c:if test = "${medecinRecherche.idCliniqueEmploi == 0}">
                                            <td>Aucun</td>
                                        </c:if>
                                    </tr>
                                    <tr><td colspan="3" style="text-align: center;">
                                            <form action="choixMedecinRendezVousController" method="get">
                                                <input type="hidden" name="typeRecherche" value="prendreRendezVous">
                                                <input type="hidden" name="medecinChoisi" value="${medecinRecherche.numeroProfessionel}">
                                                <input type="submit"  value="Prendre rendez-vous" />
                                            </form></td>
                                    </tr>

                                </table>
                        </table>
                    </div>
                </c:forEach>
            </c:when>
            <c:otherwise>    
                <h1 style="text-align: center">Aucun résultat de recherche<h1>
            </c:otherwise>
        </c:choose>
    </body>
    <jsp:include page="pied.jsp"/>
</html>
