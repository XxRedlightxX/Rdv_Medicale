<!DOCTYPE html>

<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1.0">
    <title>Patient</title>

    <link rel="stylesheet" href="style.css">

</head>
<jsp:include page="EnTete.jsp"/>




<body id="body">


    <div>


        <table id="tableService">
            <tr id="serviceRow">
                <td>
                    <h2><a href="xyz" class="services">Type de profrssionnel de la sante</a></h2>
                </td>
                <td>
                    <h2><a href="xyz" class="services">Specialite du medcin</a></h2>
                </td>
            </tr>
            <tr id="serviceRow">
                <td>
                    <h2><a href="xyz" class="services">Date et heure de rendez-vous</a></h2>
                </td>
                <td>
                    <h2><a href="xyz" class="services">Envoyer une ordonnance ficher PDF</a></h2>
                </td>
            </tr>
            <tr id="serviceRow">
                <td>
                    <h2><a href="xyz" class="services">Description de la raison du rendez-vous</a></h2>
                </td>
            </tr>
            <tr id="serviceRow">
                <td>
                    <h2><a href="xyz" id="services">Clinique pres de chez soi (Code Postal):</a></h2>
                </td>
            </tr>
        </table>


    </div>


    <button id="souF" type="submit">Soumettre formulaire</button>


</body>

<jsp:include page="pied.jsp"/>

</html>