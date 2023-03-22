<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width,initial-scale=1.0">
  <title>Accueil</title>

  <link rel="stylesheet" href="style.css">

</head>

<jsp:include page="EnTete.jsp"/>
<body id="body" class="background-image">
<c:if test = "${not empty requestScope.deconnexion}">
<div id=ls>
  <h1 id="etatPatient">${requestScope.deconnexion}</h1>
</div>
</c:if>



</body>
<jsp:include page="pied.jsp"/>
</html>