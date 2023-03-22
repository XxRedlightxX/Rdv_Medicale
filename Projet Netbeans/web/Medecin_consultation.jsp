<!DOCTYPE html>

<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1.0">
    <title>Medecin(consultation)</title>

    <link rel="stylesheet" href="style.css">

</head>

<header id="header">


    <div id="logo">
        <img src="imageWeb2/logo.png" width="60px" , height="50px">
        
          </div>

</header> <br><br>

<body id="body">


   
<div id="barCherche">
     <form action="/search">
            <input type="text" placeholder="Rechercher un patient">
            <button type="submit">Recherche</button>
          </form>
</div><br><br>

          


    <div>
        <h2 id="ip">INFORMATION DU PATIENT:</h2><BR></BR>
    </div>
    <div>


        <table id="patientTable">
            <tr id="patientRow">
                <td>
                    <h3>ID</h3>
                </td>
                <td>
                    <h3>Nom</h3>
                </td>
                <td>
                    <h3>Annee de naissance</h3>
                </td>
                <td>
                    <h3>Statut de sante</h3>
                </td>
                <td>
                    <h3>Photo de l'ordonnance</h3>
                </td>
            </tr>
            <tr id="patientRow">
                <td>
                    <h3>...</h3>
                </td>
                <td>
                    <h3>...</h3>
                </td>
                <td>
                    <h3>...</h3>
                </td>
                <td>
                    <h3>...</h3>
                </td>
                <td>
                    <h3>...</h3>
                </td>
            </tr>
        </table>


    </div>



</body>

<footer>
    <div id=partageDoc>
        <button>Partager un document avec un client</button>

    </div>
</footer>

</html>