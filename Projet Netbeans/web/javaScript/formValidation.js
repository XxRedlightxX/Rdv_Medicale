/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function () {

    $("#signupForm").validate(
            {

                rules: {

                    nom: "required",
                    prenom: "required",
                    assuranceMaladie: "required",
                    numeroSeq: {
                        required: true,
                        digits: true,
                        maxlength: 2
                    },
                    dateNaissance: "required",
                    sexe: "required",

                    password: "required",
                    passwordConfirm: {
                        required: true,
                        equalTo: "#password"
                    },
                    medecinDeFamille: "required",
                    specialite: "required",
                    facturation: {
                        required: true,
                        number: true
                    },
                    numeroProfessionel: {
                        required: true,
                        digits: true
                    },
                    coordonnees:"required"
                    

                },
                messages: {
                    prenom: "</br>Veuillez saisir votre prenom",
                    nom: "</br>Veuillez saisir votre nom",
                    assuranceMaladie: "</br>Veuillez saisir votre numéro d'assurance maladie",
                    numeroSeq: {
                        required: "</br>Veuillez saisir le numéro séquentiel de votre carte",
                        digits: "</br>Le numéro séquentiel doit être un chiffre entier",
                        maxlength: "</br>Le numéro séquentiel doit être de deux charactères maximal"
                    },
                    dateNaissance: "</br>Veuillez indiquer votre date de naissance",
                    sexe: "</br>Veuillez indiquer votre sexe",
                    password: "</br>Veuillez choisir un mot de passe",
                    passwordConfirm: {
                        required: "</br>Veuillez confirmer votre mot de passe",
                        equalTo: "</br>Veuillez saisir le meme mot de passe que précédent"
                    },
                    medecinDeFamille: "</br>Veuillez indiquer votre médecin de famille",
                    specialite: "</br>Veuillez indiquer votre spécialité",         
                    facturation: {
                        required: "</br>Veuillez indiquer votre facturation",
                        number: "</br>La facturation doit être un nombre"
                    },
                    numeroProfessionel: {
                        required: "</br>Veuillez indiquer votre numéro de professionel",
                        digits: "</br>Le numéro de professionel doit être composé seulement de chiffres"
                    },
                    coordonnees:"</br>Veuillez indiquer vos coordonnées"
                },
                errorPlacement: function (error, element) {
                    if (element.attr("name") === "sexe" ) {
                        error.insertAfter("#labelgenderF");
                    } else {
                        error.insertAfter(element);
                    }
                }

            });


    //La méthode on() attache un ou plusieurs gestionnaires d'événements
    //pour pour les éléments sélectionnés
    //ici on v disactive le bouton submit si le formulaire
    // n'est pas valide
    $('input').on('blur', function () {
        //verifi si le formulaire est valide
        if ($("#signupForm").valid()) {
            // Activer le bouton submit : ajoutez propriété disabled a  false
            $('#submit').prop('disabled', false);
        } else {
            //Desactiver le bouton submit: met la proprieté disabled à disabled
            $('#submit').prop('disabled', 'disabled');
        }
    });

});

//une méthode qui permet de verifier si le champ mot de passe correspond au pattern spécifié
//	jQuery.validator.addMethod(
//			  "password",
//			  function(value){
//				  return  /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[a-zA-Z\d]{8,}$/.test(value) ;
//			  },
//			  '</br>Le mot de passe doit contenir : au moins une lettre minuscule,au moins une lettre majuscule, au moins un chiffre,au moins huit caractères ' 
//		     
//			  
//	);








