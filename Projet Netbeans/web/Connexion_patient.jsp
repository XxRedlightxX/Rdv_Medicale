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
<a style="color:black" onclick="myFunction('connection')" >Connexion</a>&nbsp;&nbsp;&nbsp;
<a onclick="myFunction('inscription')" alt="Passe">Inscription</a>

<body id="body">
</br></br>
<div id="formuInscr" style="display:none">
<form class="login" action="">

      <label for="nom">Nom : </label>
      <input type="text" name="nom" id="nom"><br> <br>
      
      <label for="prenom">Prenom : </label>
      <input type="text" name="prenom" id="prenom"><br> <br>
      
      <label for="assuranceMaladie">Numero d'assurance maladie : </label>
      <input type="text" name="assuranceMaladie" id="assuranceMaladie"><br> <br>
      
      <label for="numeroSeq">Numero squentiel : </label>
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
<form class="login" action="">

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
<script>


function myFunction(choix) {
if (choix == "connection"){
  document.getElementById("formuInscr").style.display = "none";
  document.getElementById("formuLog").style.display = "block";
  document.getElementById("etatPatient").innerHTML = "Connexion patient";
  
  }
if (choix == "inscription"){
  document.getElementById("formuLog").style.display = "none";
  document.getElementById("formuInscr").style.display = "block";
  document.getElementById("etatPatient").innerHTML = "Inscription d'un patient";
  }
}
</script>
<footer id="footer">

</footer>

</html>
