<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List" %>
<%@page import="com.medic.entities.Medecin"%>
<%@page import="com.medic.entities.Clinique"%>
<%@page import="com.medic.service.CliniqueService"%>



<!DOCTYPE html>

<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width,initial-scale=1.0">
        <title>Connexion</title>
        <script src="http://code.jquery.com/jquery-1.12.0.min.js"></script>
        <script src="http://cdn.jsdelivr.net/jquery.validation/1.14.0/jquery.validate.min.js"></script>

        <link rel="stylesheet" href="style.css">
        <style>
            .error {
                color: red;
            }

            input.error {
                border: 1px solid red;
            }
        </style>
    </head>
    <jsp:include page="EnTete.jsp" />
    <jsp:useBean id="daoServices" class="com.medic.service.ServicesCliniqueService"/>
    <body id="body">
        <jsp:useBean id="cliniqueTest" class="com.medic.service.CliniqueService"/>
        <c:choose>
            <c:when test="${requestScope.typeAction == 'ajouter'}">
                <div id=ls>
                    <h1 id="etatMedecin">Ajout d'un nouveau médecin</h1>

                </div> 
                </br>
                <div id="formuInscr">
                    <form id="signupForm"  class="login" action="administrateurController" method="get">
                        <input type="hidden" name="ajouterMedecin">

                        <label for="nom">Nom : </label>
                        <input type="text" name="nom" id="nom"><br> <br>

                        <label for="prenom">Prenom : </label>
                        <input type="text" name="prenom" id="prenom"><br> <br>


                        <select id="specialite" name="specialite">
                            <c:forEach var="uneSpecialite" items="${daoServices.afficherServicesClinique()}" >
                                <option value="${uneSpecialite.nom}">
                                    ${uneSpecialite.nom}</option>
                                </c:forEach>
                        </select> <br> <br>

                        <label for="numeroProfessionel">Numéro de professionel : </label>
                        <input type="text" name="numeroProfessionel" id="numeroProfessionel"><br> <br>

                        <label for="facturation">Facturation : </label>
                        <input type="text" name="facturation" id="facturation"><br> <br>

                        <label for="coordonnees">Coordonnées : </label>
                        <input type="text" name="coordonnees" id="coordonnees"><br> <br>

                        <label for="password">Mot de passe:</label>
                        <input type="password" name="password" id="password"> <br><br>

                        <label for="password">Clinique : </label>
                        <select id="idClinique" name="idClinique">
                            <option value = "0">Aucun</option>
                            <c:forEach var="uneClinique" items="${sessionScope.listeCliniques}" >
                                <option value="${uneClinique.id}">
                                    ${uneClinique.nom}</option>
                                </c:forEach>
                        </select> <br><br>



                        <button class="btn btn-lg btn-primary btn-block" type="submit">
                            Ajouter le médecin</button>

                    </form>
                    <br>
                    <form style="display:inline;" action="pageAdminMedecins.jsp" method="post">
                        <input style="width:100px;" type="submit" value="Annuler">
                    </form>
                </div>

            </c:when>

            <c:when test="${requestScope.typeAction == 'modifier'}">
                <div id=ls>
                    <h1 id="etatMedecin">Modifier un médecin</h1>

                </div> <br><br><br>
                <c:if test="${not empty requestScope.unMedecin}">

                    </br></br>
                    <div id="formuInscr">
                        <form style="display:inline;" id="signupForm" class="login" action="administrateurController" method="get">


                            <input type="hidden" name="modifierMedecin" value="${unMedecin.numeroProfessionel}">
                            <table style="background-color:white;margin-left:auto;margin-right:auto;">



                                <tr>
                                    <th>Informations médecin</label></th>
                                    <th>Données courantes</th>
                                    <th>Modifications</th>
                                </tr>
                                <tr>
                                    <td><label for="nom">Nom : </label></td>
                                    <td>${unMedecin.nom}</td>
                                    <td><input type="text" name="nom" id="nom" value="${unMedecin.nom}"></td>
                                </tr>

                                <tr>
                                    <td><label for="prenom">Prenom : </label></td>
                                    <td>${unMedecin.prenom}</td>
                                    <td><input type="text" name="prenom" id="prenom" value="${unMedecin.prenom}">
                                    </td>
                                </tr>
                                <tr>
                                    <td><label for="specialite">Specialite : </label></td>
                                    <td>${unMedecin.specialite}</td>
                                    <td>
                                        <select id="specialite" name="specialite">
                                            <c:forEach var="uneSpecialite" items="${daoServices.afficherServicesClinique()}" >
                                                <option value="${uneSpecialite.nom}"<c:if test="${uneSpecialite.nom == unMedecin.specialite}"> 
                                                            selected="selected"
                                                        </c:if>>
                                                    ${uneSpecialite.nom}</option>
                                                </c:forEach>
                                        </select> <br> <br>
                                    </td>
                                </tr>

                                <tr>
                                    <td><label for="numeroProfessionel">Numéro de professionel : </label></td>
                                    <td>${unMedecin.numeroProfessionel}</td>
                                    <td><input type="text" name="numeroProfessionel2" id="numeroProfessionel2" value="${unMedecin.numeroProfessionel}">
                                        <input type="hidden" name="numeroProfessionel" id="numeroProfessionel" value="${unMedecin.numeroProfessionel}">  
                                    </td>
                                </tr>

                                <tr>
                                    <td><label for="facturation">Facturation : </label></td>
                                    <td>${unMedecin.facturation}</td>
                                    <td><input type="text" name="facturation" id="facturation" value="${unMedecin.facturation}">
                                    </td>
                                </tr>

                                <tr>
                                    <td><label for="coordonnees">Coordonnées : </label></td>
                                    <td>${unMedecin.coordonnees}</td>
                                    <td><input type="text" name="coordonnees" id="coordonnees" value="${unMedecin.coordonnees}">
                                    </td>
                                </tr>

                                <tr>
                                    <td><label for="password">Mot de passe:</label></td>
                                    <td>${unMedecin.motDePasse}</td>
                                    <td><input type="text" name="password" id="password" value="${unMedecin.motDePasse}">
                                    </td>

                                </tr>
                                <tr>
                                    <td><label for="idClinique">Clinique où médecin<br> est employé : </label></td>
                                            <c:if test = "${unMedecin.idCliniqueEmploi != 0}">
                                        <td>${cliniqueTest.chercherCliniqueParId(unMedecin.idCliniqueEmploi).nom}</td>
                                    </c:if>

                                    <c:if test = "${unMedecin.idCliniqueEmploi == 0}">
                                        <td>Aucun</td>
                                    </c:if>

                                    <td><select id="idClinique" name="idClinique">
                                            <option value = "0"
                                                    <c:if test = "${unMedecin.idCliniqueEmploi == 0}">
                                                        selected="selected" 
                                                    </c:if>>Aucun</option>
                                            <c:forEach var="uneClinique" items="${sessionScope.listeCliniques}" >
                                                <option value="${uneClinique.id}"
                                                        <c:if test="${uneClinique.id == unMedecin.idCliniqueEmploi}"> 
                                                            selected="selected"
                                                        </c:if>>${uneClinique.nom}</option>
                                            </c:forEach>
                                        </select>
                                    </td>

                                </tr>
                            </table>


                            <br><br><br>

                            <input type="submit" style="display:inline;"  class="btn btn-primary btn-lg" value="Sauvegarder"  id="submits">
                        </form>
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <form style="display:inline;" action="pageAdminMedecins.jsp" method="post">
                            <input style="width:100px;" type="submit" value="Annuler">
                        </form>

                    </c:if>
                </c:when>


                <c:when test="${requestScope.typeAction == 'supprimer'}">
                    <style>
                        th {
                            text-align: left;
                            width: 500px;
                        }

                        tr tr td {
                            text-align: left;
                            padding-left: 5%;
                            width: 25%;
                        }

                        td input {
                            width: 100px;
                            margin-right: 15px;
                        }
                    </style>
                    <div id=ls>
                        <h1 id="etatMedecin">Supression d'un médecin</h1>

                    </div> <br>


                    <c:if test = "${not empty requestScope.unMedecin}">
                        </br></br>
                        <div>
                            <H1 style="margin-right: 50%">Médecin: </H1>
                            <table style="border: 1px solid black;border-radius: 10px;width:60%;margin: auto;background-color: white">
                                <tr>
                                    <td rowspan="2"><img src="imageWeb2/patient_icon.png" alt="Trulli" width="125" height="125"></td>
                                    <td rowspan="2"><table>
                                            <tr>
                                                <th>Nom:</th>
                                                <td>${unMedecin.nom}</td>
                                                <th>Numero de professionel:</th>
                                                <td>${unMedecin.numeroProfessionel}</td>
                                            </tr>
                                            <tr>
                                                <th>Prenom:</th>
                                                <td>${unMedecin.prenom}</td>
                                                <th>Spécialitée:</th>
                                                <td>${unMedecin.specialite}</td>
                                            </tr>
                                            <tr>
                                                <th>Facturation:</br></th>
                                                <td>${unMedecin.facturation} $</td>
                                                <th>Coordonnées:</th>
                                                <td>${unMedecin.coordonnees}</td>
                                            </tr>
                                            <tr>
                                                <th>Clinique où médecin est employé:</th>
                                                    <c:if test = "${unMedecin.idCliniqueEmploi != 0}">
                                                    <td>${cliniqueTest.chercherCliniqueParId(unMedecin.idCliniqueEmploi).nom}</td>
                                                </c:if>

                                                <c:if test = "${unMedecin.idCliniqueEmploi == 0}">
                                                    <td>Aucun</td>
                                                </c:if> 

                                            </tr>
                                        </table>
                                    </td>

                            </table>
                            </br>
                            <h2 style="text-align:center"> Voulez vous vraiment supprimer ce médecin ?</h2></br>
                        </div>
                        <form style="display:inline;" action="administrateurController" method="post">
                            <input type="hidden" name="supprimerMedecin" value="${unMedecin.numeroProfessionel}">
                            <input style="width:100px;" type="submit" value="Supprimer">
                        </form> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

                        <form style="display:inline;" action="pageAdminMedecins.jsp" method="post">
                            <input style="width:100px;" type="submit" value="Annuler">
                        </form>

                    </c:if>
                </c:when>
            </c:choose>
    </body>


    <jsp:include page="pied.jsp" />
    <script src="javaScript/formValidation.js"></script>

</html>
