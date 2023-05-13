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
                <p align="center"> Mettre a jour le Tarif du medecin :<strong> </strong> <strong> </strong> </p>

                  </div><c:choose>
                <c:when  test="${requestScope.typeAction == 'modifier'}">
                    <c:if test="${not empty requestScope.unMedecin}">
                        <div class="form-group">
                <form action="medecinGestionController" id="signupForm" method="get" class="form-horizontal" >
                     
                       <input type="hidden" name="modifierMedecin" value="${unMedecin.numeroProfessionel}">
                       
            <div class="form-group">
                        <label class="col-sm-4 control-label" for="facturation">Facturation :</label>
                        <div class="col-sm-5">
                            <td>${unMedecin.facturation} ${unMedecin.nom} </td>
                            <input type="text" class="form-control" id="facturationl"
                                   name="facturation" value="${unMedecin.facturation}" />
                            <input type="submit"  class="btn btn-primary btn-lg" 
                                   value="Sauvegarder"  id="submit"  />
                        </div>
                    </div>
                </form>   
                    </c:if>
                 </c:when>  
                </c:choose>

                  

                 


                    <div class="form-group">
                        <div class="col-sm-9 col-sm-offset-4">

                               <!-- 
                            
                        </div>
                    </div>
                </form>
            </div>
    </body>
     <jsp:include page="pied.jsp"/>
</html>
