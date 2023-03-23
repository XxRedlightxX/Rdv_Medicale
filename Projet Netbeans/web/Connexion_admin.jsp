<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width,initial-scale=1.0">
  <title>Connexion</title>

  <link rel="stylesheet" href="style.css">

</head>
<jsp:include page="EnTete.jsp"/>

<div id=ls>
  <h1 id="etatPatient">Connexion Administrateur</h1>

</div> <br>

<body id="body">
</br></br>

<c:if test = "${not empty requestScope.invalide}">
    <center><b><font color=red>${requestScope.invalide}</font><b></center>               
</c:if>

<div id="formuLog">
<form class="login" action="connexionController">
      <input type="hidden" name="typeCompte" value="patient">
      <label for="username">Nom d'utilisateur: </label>
      <input type="text" name="username" id="username"><br> <br>
      
      <label for="password">Mot de passe:</label>
      <input type="password" name="password" id="password"> <br><br>
      
	  <button class="btn btn-lg btn-primary btn-block" type="submit">
                   Se connecter</button>
      <label class="checkbox pull-left">
	  <input type="checkbox" name="sauvegarde" value="yes">Se souvenir </br>
      </label>
    </form>
</div>
</body>

<jsp:include page="pied.jsp"/>

</html>
