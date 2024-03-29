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

    <body id="body">
        
        <c:choose>
            <c:when test="${requestScope.typeAction == 'ajouter'}">
                <div id=ls>
                    <h1 id="etatClinique">Ajout d'une nouvelle clinique</h1>

                </div> 
                </br>
                <div id="formuInscr">
                    <form id="signupForm" class="login" action="administrateurController" method="post">
                        <input type="hidden" name="ajouterClinique">

                        <label for="nom">Nom de la clinique : </label>
                        <input type="text" name="nom" id="nom"><br> <br>

                        <label for="coordonnees">Coordonnées : </label>
                        <input type="text" name="coordonnees" id="coordonnees"><br> <br>

                        <input type="submit"  class="btn btn-primary btn-lg" value="Ajouter la clinique"  id="submits">
                    </form>
                    <br>
                    <form style="display:inline;" action="pageAdminCliniques.jsp" method="post">
                        <input style="width:100px;" type="submit" value="Annuler">
                    </form>
                </div>

            </c:when>

            <c:when test="${requestScope.typeAction == 'modifier'}">
                <div id=ls>
                    <h1 id="etatClinique">Modifier une clinique</h1>

                </div> <br><br><br>
                <c:if test="${not empty requestScope.uneClinique}">

                    </br></br>
                    <div id="formuInscr">
                        <form style="display:inline;" id="signupForm" class="login" action="administrateurController" method="get">


                            <input type="hidden" name="modifierClinique" value="${uneClinique.id}">
                            <table style="background-color:white;margin-left:auto;margin-right:auto;">

                                <tr>
                                    <th>Informations Clinique</label></th>
                                    <th>Données courantes</th>
                                    <th>Modifications</th>
                                </tr>
                                <tr>
                                    <td><label for="nom">Nom : </label></td>
                                    <td>${uneClinique.nom}</td>
                                    <td><input type="text" name="nom" id="nom" value="${uneClinique.nom}"></td>
                                </tr>

                                <tr>
                                    <td><label for="coordonnees">Coordonnées : </label></td>
                                    <td>${uneClinique.coordonnees}</td>
                                    <td><input type="text" name="coordonnees" id="coordonnees" value="${uneClinique.coordonnees}">
                                    </td>
                                </tr>


                            </table>


                            <br><br><br>

                            <input type="submit" style="display:inline;"  class="btn btn-primary btn-lg" value="Sauvegarder"  id="submits">
                        </form>
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <form style="display:inline;" action="pageAdminCliniques.jsp" method="post">
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
                        <h1 id="etatClinique">Supression d'une clinique</h1>

                    </div> <br>


                    <c:if test = "${not empty requestScope.uneClinique}">
                        </br></br>
                        <div>
                            <H1 style="margin-right: 50%">Clinique : </H1>
                            <table style="border: 1px solid black;border-radius: 10px;width:50%;margin: auto;background-color: white">
                                <tr>
                                    <td rowspan="2"><img src="imageWeb2/clinique_icon.png" alt="Trulli" width="125" height="125"></td>
                                    <td rowspan="2"><table>
                                            <tr>
                                                <th>Nom de la clinique :</th>
                                                <td>${uneClinique.nom}</td>     
                                            </tr>
                                            <tr >
                                                <th style="width:10%">Coordonnées :</th>
                                                <td>${uneClinique.coordonnees}</td>   
                                            </tr>

                                        </table></td>
                       
                               

                                </tr>
                            </table>
                            </br>
                            <h2 style="text-align:center"> Voulez vous vraiment supprimer cette clinique ?</h2></br>
                        </div>
                        <form style="display:inline;" action="administrateurController" method="post">
                            <input type="hidden" name="supprimerClinique" value="${uneClinique.id}">
                            <input style="width:100px;" type="submit" value="Supprimer">
                        </form> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

                        <form style="display:inline;" action="pageAdminCliniques.jsp" method="post">
                            <input style="width:100px;" type="submit" value="Annuler">
                        </form>

                    </c:if>
                </c:when>
            </c:choose>
    </body>


    <jsp:include page="pied.jsp" />
    <script src="javaScript/formValidation.js"></script>

</html>
