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


    <c:choose>
        <c:when test = "${requestScope.typeAction == 'ajouter'}">
            <div id=ls>
                <h1 id="etatPatient">Ajout d'un nouveau patient</h1>

            </div> <br>

            <body id="body">
                </br></br>
                <div id="formuInscr">
                    <form id="signupForm" class="login" action="administrateurController" method="post">
                        <input type="hidden" name="ajouterPatient">

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

                        <label for="gender_male" id="labelgenderM"> 
                            <input type="radio" id="gender_male" value="Homme" name="sexe">Male</label> 
                        <label for="gender_female" id="labelgenderF"> 
                            <input type="radio" id="gender_female" value="Femme" name="sexe">Female</label><br> <br>

                        
                        <label for="password">Mot de passe:</label>
                        <input type="password" name="password" id="password"> <br><br>

                        //id medecin de famille

                        <input type="submit"  class="btn btn-primary btn-lg" 
                               value="Ajouter le patient"  id="submits"  />

                    </form>
                </div>     
            </c:when>

            <c:when test = "${requestScope.typeAction == 'modifier'}">
                <div id=ls>
                    <h1 id="etatPatient">Modifier un patient</h1>

                </div> <br>

            <body id="body">
                <c:if test = "${not empty requestScope.unPatient}">  
                </br></br>
                <div id="formuInscr">
                    <form style="display:inline;" id="signupForm" class="login" action="administrateurController" method="post">
                        <input type="hidden" name="modifierPatient" value="${unPatient.id}">

                        <label for="nom">Nom : </label>
                        <input type="text" name="nom" id="nom" value="${unPatient.nom}"><br> <br>

                        <label for="prenom">Prenom : </label>
                        <input type="text" name="prenom" id="prenom" value="${unPatient.prenom}"><br> <br>

                        <label for="assuranceMaladie">Numero d'assurance maladie : </label>
                        <input type="text" name="assuranceMaladie" id="assuranceMaladie" value="${unPatient.numeroAssuranceMaladie}"><br> <br>

                        <label for="numeroSeq">Numero sequentiel : </label>
                        <input type="text" name="numeroSeq" id="numeroSeq" value="${unPatient.numeroSequentiel}"><br> <br>

                        <label for="dateNaissance">Date de naissance : </label>
                        <input type="date" name="dateNaissance" id="dateNaissance" value="${unPatient.dateNaissance}"><br> <br>

                        <label for="sexe"> Sexe : </label> 

                        <label for="gender_male" id="labelgenderM"> 
                            <input type="radio" id="gender_male" value="Homme" name="sexe" checked>Male</label> 
                        <label for="gender_female" id="labelgenderF"> 
                            <input type="radio" id="gender_female" value="Femme" name="sexe">Female</label><br> <br>


                        <label for="password">Mot de passe:</label>
                        <input type="text" name="password" id="password" value="${unPatient.password}"> <br><br>

                        <label for="passwordConfirm">Confirmation du mot de passe:</label>
                        <input type="text" name="passwordConfirm" id="passwordConfirm" value="${unPatient.password}"> <br><br><br><br><br>


                        <input type="submit"  class="btn btn-primary btn-lg" 
                               value="Sauvegarder"  id="submits"  />                     
                    </form>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <form style="display:inline;" action="pageAdminPatients.jsp" method="post">
                        <input style="width:100px;" type="submit" value="Annuler">
                    </form>
                </div>   
                </c:if>  
            </c:when>

            <c:when test = "${requestScope.typeAction == 'supprimer'}">
                <style>
                    th {
                        text-align: left;
                        width: 500px;
                    }
                    tr tr td {
                        text-align: left;
                        padding-left:5%;
                        width:25%;
                    }
                    td input {
                        width:100px;
                        margin-right: 15px;
                    }
                </style>
                <div id=ls>
                    <h1 id="etatPatient">Supression d'un patient</h1>

                </div> <br>

            <body id="body">
                <c:if test = "${not empty requestScope.unPatient}">
                </br></br>
                <div>   
                    <H1 style="margin-right: 50%">Patient: </H1>
                    <table style="border: 1px solid black;border-radius: 10px;width:60%;margin: auto;background-color: white">
                        <tr>
                            <td rowspan="2"><img src="imageWeb2/patient_vide.png" alt="Trulli" width="125" height="125"></td>
                            <td rowspan="2"><table>
                                    <tr>
                                <th>Nom:</th>
                                <td>${unPatient.nom}</td>
                                <th>Numero d'assurance maladie:</th>
                                <td>${unPatient.numeroAssuranceMaladie}</td>
                            </tr>
                            <tr>
                                <th>Prenom:</th>
                                <td>${unPatient.prenom}</td>
                                <th>Numéro séquentiel:</th>
                                <td>${unPatient.numeroSequentiel}</td>
                            </tr>
                            <tr>
                                <th>Date de naissance:</br></th>
                                <td>${unPatient.dateNaissance}</td>
                                <th>Sexe:</th>
                                <td>${unPatient.sexe}</td>
                            </tr>
                            <tr>
                                <th>Nom du médecin de famille:</th>
                                <td>${unPatient.idMedecinFamille}</td>
                            </tr>
                                </table></td>

                    </table>
                    </br>
                    <h2 style="text-align:center"> Voulez vous vraiment supprimer ce patient ?</h2></br>
                </div>   
                <form style="display:inline;" action="administrateurController" method="post">    
                    <input type="hidden" name="supprimerPatient" value="${unPatient.id}">
                    <input style="width:100px;" type="submit" value="Supprimer">
                </form> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

                <form style="display:inline;" action="pageAdminPatients.jsp" method="post">
                    <input style="width:100px;" type="submit" value="Annuler">
                </form> 
            </c:if>  
            </c:when>
        </c:choose>




    </body>


    <jsp:include page="pied.jsp"/>
    <script src="javaScript/formValidation.js"></script> 
</html>
