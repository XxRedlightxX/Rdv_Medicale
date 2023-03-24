/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.medic.dao.administrateur;

import com.medic.entities.Administrateur;
import com.medic.singleton.ConnexionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hundl
 */
public class AdministrateurImplDao implements AdministrateurDao {

    private static final String SQL_CONNEXION_ADMINISTRATEUR = "SELECT * from administrateur where nomUtilisateur = ? and password = ?";

    @Override
    public Administrateur existByNumeroMotPasse(String username, String motPasse) {
        Administrateur admin = null;
        try {

            //Initialise la requête préparée basée sur la connexion
            // la requête SQL passé en argument pour construire l'objet preparedStatement
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_CONNEXION_ADMINISTRATEUR);
            // on initialise la propriété email du bean avec sa premiere valeur
            ps.setString(1, username);
            ps.setString(2, motPasse);
            //On execute la requête et on récupère les résultats dans la requête 
            // dans ResultSet
            ResultSet result = ps.executeQuery();

            //// la méthode next() pour se déplacer sur l'enregistrement suivant
            //on parcours ligne par ligne les résultas retournés
            while (result.next()) {
                admin = new Administrateur();

                admin.setId(result.getInt("idadministrateur"));
                admin.setUsername(result.getString("nomUtilisateur"));
                admin.setMotDePasse(result.getString("password"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(AdministrateurImplDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Fermeture de toutes les ressources ouvertes
        ConnexionBD.closeConnection();
        return admin;

    }

}
