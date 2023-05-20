<%-- 
    Document   : MedecinGestion
    Created on : 2023-05-05, 18:39:45
    Author     : Admin
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <%@page import="com.medic.entities.Medecin"%>
 
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <jsp:include page="EnTete.jsp"/>
    <body>
        <div class="panel-body">
            <jsp:useBean id="medecinTest" class="com.medic.service.MedecinService"/>
                  <div class="panel-heading">
                <h2 align="center">Mettre à jour les informations</h2>
                <h1 align="center"> Mettre a jour le Tarif du medecin :<strong> </strong> <strong> </strong> </h1>

                  </div><c:choose>
                <c:when  test="${requestScope.typeAction == 'modifier'}">
                    <c:if test="${not empty requestScope.unMedecin}">
                        <div class="form-group">
                <form style="display:inline" action="medecinGestionController" id="signupForm" method="get" class="form-horizontal" >
                     
                       <input type="hidden" name="modifierMedecin" value="${unMedecin.numeroProfessionel}">
                    <table style="background-color:blue;margin-left:auto;margin-right:auto;border: 3px solid black;border-radius: 10px;width:60%;margin: auto;background-color: white">   
                    
                        <tr>
                        <label class="" for="facturation"><th><h2>Facturation :</th></h2></label></tr>
                      
                    <td><h3>${unMedecin.facturation} ${unMedecin.nom}</h3> </td>
                            <td><input type="text" class="form-control" id="facturationl"
                                       name="facturation" value="${unMedecin.facturation}" /></td>
                            <td><input type="submit"  class="btn btn-primary btn-lg" 
                                       value="Sauvegarder"  id="submit"  /></td>
                       
                   
                    </table>        
                </form>   
                    </c:if>
                 </c:when>  
                </c:choose>

                  

                 


                   
                        </div>
                    </div>
               
            </div>
    </body>
     <jsp:include page="pied.jsp"/>
</html>
