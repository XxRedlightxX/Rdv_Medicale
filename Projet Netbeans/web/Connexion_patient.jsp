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
  <h1 id="etatPatient">Connexion patient</h1>

</div> <br>
<a style="color:black" onclick="myFunction('connection')" id="btnConnexion">Connexion</a>&nbsp;&nbsp;&nbsp;
<a onclick="myFunction('inscription')" alt="Passe" id="btnInscription" style="text-decoration:underline;cursor:pointer;">Inscription</a>

<body id="body">
</br></br>

<c:if test = "${not empty requestScope.invalide}">
    <center><b><font color=red>${requestScope.invalide}</font><b></center>               
</c:if>
            
<div id="formuInscr" style="display:none">
<form class="login" action="">

      <label for="nom">Nom : </label>
      <input type="text" name="nom" id="nom"><br> <br>
      
      <label for="prenom">Prenom : </label>
      <input type="text" name="prenom" id="prenom"><br> <br>
      
      <label for="assuranceMaladie">Numero d'assurance maladie : </label>
      <input type="text" name="assuranceMaladie" id="assuranceMaladie"><br> <br>
      
      <label for="numeroSeq">Numero sequentiel : </label>
      <input type="text" name="numeroSeq" id="numeroSeq"><br> <br>
      
      <label for="dateNaissance">Date de naissance : </label>
      <input type="date" name="dateNaissance" id="dateNaissance"><br> <br>
      
      <label for="sexe"> Sexe : </label>
      <label for="gender_male"> 
      <input type="radio" id="gender_male" value="male" name="sexe">Male</label> 
      <label for="gender_female"> 
      <input type="radio" id="gender_female" value="female" name="sexe">Female</label><br> <br>


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
<form class="login" action="connexionController">
      <input type="hidden" name="typeCompte" value="patient">
      <label for="username">Numero d'assurance maladie: </label>
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
  document.getElementById("etatPatient").innerHTML = "Connexion patient";
  
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
  document.getElementById("etatPatient").innerHTML = "Inscription d'un patient";
  
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

</html>
