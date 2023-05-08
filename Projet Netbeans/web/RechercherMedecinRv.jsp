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
                    <input type="hidden" name="typeRecherche" value="memeGMF">
                    <select name="medecinChoisi" id="medecinChoisi">

                        <c:forEach var="unMedecin" items="${test.chercherParClinique((test.chercherMedecinParId(daoPatient.chercherParAssuranceMaladie(sessionScope.username).idMedecinFamille).idCliniqueEmploi))}" >
                            <c:if test = "${unMedecin.numeroProfessionel != daoPatient.chercherParAssuranceMaladie(sessionScope.username).idMedecinFamille}">
                                <option value="${unMedecin.numeroProfessionel}">Dr. ${unMedecin.nom}</option> 
                            </c:if>
                        </c:forEach>
                    </select>
                    <input type="submit"  value="Prendre rendez-vous" />
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
        <div>
            <c:forEach var="uneListeMedecinRecherche" items="${listeMedecinRecherche}" >
                ${uneListeMedecinRecherche.nom}
            </c:forEach>
        </div>



    </body>
    <jsp:include page="pied.jsp"/>
</html>
