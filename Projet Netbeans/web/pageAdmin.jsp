<!DOCTYPE html>

<html lang="en">

<head>
     <meta charset="UTF-8">
     <meta name="viewport" content="width=device-width,initial-scale=1.0">
     <title>Admin</title>

     <link rel="stylesheet" href="style.css">

</head>

<jsp:include page="EnTete.jsp"/>

<body id="body">

<div>   <div id="patient">
          <H1>Patient: </H1>
          <button>Ajoute un patient</button>
          <button>Suprimer un patient</button>
          <button>Modifier un patient</button>

     </div>



     <div id="medecin">
          <H1>Médecin: </H1>
          <button>Ajoute un médecin</button>
          <button>suprimer un médecin</button>
          <button>Modifier un médecin</button>

     </div>

     <div id="clinique">
          <H1>Clinique: </H1>
          <button>Ajoute un Clinique</button>
          <button>Suprimer un Clinique</button>
          <button>Modifier un clinique</button>

     </div>
</div>

  


 

</body>
<jsp:include page="pied.jsp"/>
 
</html>