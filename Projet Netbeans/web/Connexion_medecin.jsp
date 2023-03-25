<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width,initial-scale=1.0">
  <title>Connexion</title>
<script src="http://code.jquery.com/jquery-1.12.0.min.js"></script>
  <script
        src="http://cdn.jsdelivr.net/jquery.validation/1.14.0/jquery.validate.min.js"></script>

  <link rel="stylesheet" href="style.css">
  <style>
    .error{
        color:red;
    }
    input.error{
        border:1px solid red;
    }
    
</style>

</head>
<jsp:include page="EnTete.jsp"/>

<div id=ls>
  <h1 id="etatPatient">Connexion Médecin</h1>

</div> <br>
<a style="color:black" onclick="myFunction('connection')" id="btnConnexion">Connexion</a>&nbsp;&nbsp;&nbsp;
<a onclick="myFunction('inscription')" alt="Passe" id="btnInscription" style="text-decoration:underline;cursor:pointer;">Inscription</a>

<body id="body">
</br></br>
<c:if test = "${not empty requestScope.invalide}">
    <center><b><font color=red>${requestScope.invalide}</font><b></center>               
</c:if>
<div id="formuInscr" style="display:none">
<form id="signupForm"  class="login" action="inscriptionController" method="post">
    <input type="hidden" name="typeCompte" value="medecin">

      <label for="nom">Nom : </label>
      <input type="text" name="nom" id="nom"><br> <br>
      
      <label for="prenom">Prenom : </label>
      <input type="text" name="prenom" id="prenom"><br> <br>
      
      <label for="specialite">Specialite : </label>
      <input type="text" name="specialite" id="specialite"><br> <br>
      
      <label for="numeroProfessionel">Numéro de professionel : </label>
      <input type="text" name="numeroProfessionel" id="numeroProfessionel"><br> <br>
      
      <label for="facturation">Facturation : </label>
      <input type="text" name="facturation" id="facturation"><br> <br>
      
      <label for="coordonnees">Coordonnées : </label>
      <input type="text" name="coordonnees" id="coordonnees"><br> <br>

      <label for="password">Mot de passe:</label>
      <input type="password" name="password" id="password"> <br><br>
      
      <label for="passwordConfirm">Confirmation du mot de passe:</label>
      <input type="password" name="passwordConfirm" id="passwordConfirm"> <br><br>


      
	  <button class="btn btn-lg btn-primary btn-block" type="submit">
                   Sign in</button>
                <label class="checkbox pull-left">
                    <input type="checkbox" name="sauvegarde" value="yes">
                    Se souvenir </br>
                </label>
    </form>
</div>
<div id="formuLog">
<form class="login" action="connexionController" method="post">
      <input type="hidden" name="typeCompte" value="medecin">
      <label for="username">Numéro de professionel: </label>
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
<script>


function myFunction(choix) {
if (choix === "connection"){
  document.getElementById("formuInscr").style.display = "none";
  document.getElementById("formuLog").style.display = "block";
  document.getElementById("etatPatient").innerHTML = "Connexion Médecin";
  
  document.getElementById("btnConnexion").style.color = "black";
  document.getElementById("btnInscription").style.color = "white";
  
  document.getElementById("btnInscription").style.textDecoration="underline";
  document.getElementById("btnConnexion").style.textDecoration="none";
  
  document.getElementById("btnInscription").style.cursor="pointer";
  document.getElementById("btnConnexion").style.cursor="default";
  
  
  }
if (choix === "inscription"){
  document.getElementById("formuLog").style.display = "none";
  document.getElementById("formuInscr").style.display = "block";
  document.getElementById("etatPatient").innerHTML = "Inscription d'un Médecin";
  
  document.getElementById("btnInscription").style.color = "black";
  document.getElementById("btnConnexion").style.color = "white";
  
  document.getElementById("btnConnexion").style.textDecoration="underline";
  document.getElementById("btnInscription").style.textDecoration="none";
  
  document.getElementById("btnConnexion").style.cursor="pointer";
  document.getElementById("btnInscription").style.cursor="default";
  }
}
</script>
<jsp:include page="pied.jsp"/>
<script src="javaScript/formValidation.js"></script>

</html>
