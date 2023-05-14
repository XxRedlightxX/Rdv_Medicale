<%-- 
    Document   : pied
    Created on : 22-Mar-2023, 1:29:37 PM
    Author     : hundl
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <body>
        
        <footer id="footer">
            <div class="container">
                <c:if test = "${not empty sessionScope.typeCompte}">
                <h3> <a href="deconnexionController">Déconnexion</a></h3>
                </c:if>
                <h3><a href="EspaceDiscussion.jsp">Chat 24/24</a></h3>
                <h3><a href="xyz">Langue Fr/En</a></h3>

            </div>
        </footer>
    </body>
</html>
