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
        <title>JSP Page</title>
        <link rel="stylesheet" href="style.css">
    </head>
    <jsp:include page="EnTete.jsp"/>
    
    
    
    
    <body>
        <jsp:useBean id="test" class="com.medic.service.MedecinService"/>
        <jsp:useBean id="test2" class="com.medic.service.ServicesCliniqueService"/>
        <jsp:useBean id="test3" class="com.medic.service.CliniqueService"/>
         <form action="cliniqueController" method="get">

                    <select name="nomclinique" id="nomclinique">
                        <option value="Clinique Rosemon">Clinique Rosemont</option>
                        <option value="Dr Mathieu et associés">Dr Mathieu et Associes</option>
                        <option value="Clinique sante vivre">Clinique Santé et Vivre</option>
                        <option value="Clinique du matin">Clinique du Matin</option>
                        <option value="Jacques Mercier">Jacques Mercier</option>
                    </select>
                    <input type="submit"  value="nomclinique" />
                </form>
        <h4>Chercher une clinique par son nom</h4>
                <form action="cliniqueController" method="get"> 
                    <input type="search" name="nom">
                    <input type="submit"  value="nom" />
                </form>
        
        
         <div class="droite">
                <h4>Filter par services</h4>
                <form action="cliniqueController" method="get">
                    <input type="radio" name="typeService" value="Admin"/> <label>Médecine général </label> <br>
                    <input type="radio" name="typeService" value="Vendeur"/> <label>Cardiologie</label><br>
                    <input type="radio" name="typeService" value="Assistant"/> <label>Dermatologie</label> <br><!-- comment -->
                    <input type="radio" name="typeService" value="Editeur"/> <label>Grippe, rhume</label><br><!-- comment -->
                    <input type="radio" name="typeService" value="Expediteur"/> <label>Dépistage d'ITSS</label> <br><!-- comment -->
                    <input type="submit"  value="typeService" />
                </form>
        
        
        
         <table style="width:79%">
            <tr>
                <th>Nom de la clinique</th>
                <th>Coordonnées</th>
                <th>services offerts</th>
                <th> Médecins associés à la clinique</th>
                <th> les patients de la clinique en indiquant le médecin et le service</th>
                

                <th>Status</th>
                
            </tr>
            <c:if test="${not empty requestScope.listeClinique}">
                
            
            <c:forEach var="user" items="${requestScope.listeClinique}" >
                        <tr>
                            
                            
                            <td>    ${user.nom} </td> 
                            
                            <td>${user.coordonnees} </td>
                            
                            <td> <c:if test = "${unPatient.idMedecinFamille != 0}">
                                     <c:forEach var="user2" items="${test.chercherParClinique(user.id)}" >
                                        <td>Dr. ${user2.prenom} ${user2.nom} </td>
                                            
                                     </c:forEach>
                                        </c:if>
                                        <td><c:if test = "${unPatient.idMedecinFamille != 0}">
                                             <c:forEach var="user3" items="${test2.afficherLesServicesDuneClinique(user.id)}" >
                                        <td>  ${user3.nom} ${user3.description} </td>
                                            
                                     </c:forEach>
                                        </c:if></td>
                                         
                                        <td><c:if test = "${unPatient.idMedecinFamille != 0}">
                                             <c:forEach var="user4" items="${test.afficherLesMedecin()}" >
                                        <td>  ${user4.nom}  </td>
                                            
                                     </c:forEach>
                                         </c:if>

                              
                        </tr>
            </c:forEach>
                        </c:if>
                        
                        </table>
            
    </body>
    <jsp:include page="pied.jsp"/>
</html>
