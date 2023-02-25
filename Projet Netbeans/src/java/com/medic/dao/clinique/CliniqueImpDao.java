package com.medic.dao.clinique;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import com.medic.dao.clinique.CliniqueDao;
import com.medic.entities.Clinique;
import com.medic.singleton.ConnexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 1482910
 */
public class CliniqueImpDao implements CliniqueDao {

    private static final String SQL_SELECT_CLINIQUES = "select * from clinique";
    private static final String SQL_SELECT_BY_ID = "select * from clinique where idclinique =?";
    private static final String SQL_SELECT_BY_NAME = "select * from clinique where nom = ?";
    private static final String SQL_SELECT_BY_COORDONNEES = "select * from clinique where coordonnees = ?";
   

    @Override
    public List<Clinique> findAll() {
        List<Clinique> listeClinique = null;
        try {
            // Initilise la requete préparé de la basé sur la connexion
            // la requete SQL passé en argument pour construire l'objet PreparedStatement
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_CLINIQUES);
            // on execute la requete  et on recupere les resultats dans la requete
            ResultSet result = ps.executeQuery();

            //initilisation de la listeUtilisateur
            listeClinique = new ArrayList();
            while (result.next()) {
                Clinique clinique = new Clinique();
                clinique.setId(result.getInt("idclinique"));
                clinique.setNom(result.getString("nom"));
                clinique.setCoordonnées(result.getString("coordonnees"));

                listeClinique.add(clinique);
            }
            ConnexionBD.closeConnection();

        } catch (SQLException ex) {
            Logger.getLogger(CliniqueImpDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listeClinique;
    }

    @Override
    public Clinique findById(int id) {
        Clinique clinique = null;
        try {

            // Initilise la requete préparé de la basé sur la connexion
            // la requete SQL passé en argument pour construire l'objet PreparedStatement
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_BY_ID);
            // on initialise la propriete nom du l'ulisateur avec sa premiere valeur
            ps.setInt(1, id);

            // on execute la requete  et on recupere les resultats dans la requete
            ResultSet result = ps.executeQuery();

            //initilisation de la listeUtilisateur
            while (result.next()) {
                clinique = new Clinique();
                clinique.setId(result.getInt("idclinique"));
                clinique.setNom(result.getString("nom"));
                clinique.setCoordonnées(result.getString("coordonnees"));

            }
            ConnexionBD.closeConnection();

        } catch (SQLException ex) {
            Logger.getLogger(CliniqueImpDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return clinique;
    }

    @Override
    public Clinique findByName(String nom) {
        Clinique clinique = null;
        try {

            // Initilise la requete préparé de la basé sur la connexion
            // la requete SQL passé en argument pour construire l'objet PreparedStatement
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_BY_NAME);
            // on initialise la propriete nom du l'ulisateur avec sa premiere valeur
            ps.setString(1, nom);

            // on execute la requete  et on recupere les resultats dans la requete
            ResultSet result = ps.executeQuery();

            //initilisation de la listeUtilisateur
            while (result.next()) {
                clinique = new Clinique();
                clinique.setId(result.getInt("idclinique"));
                clinique.setNom(result.getString("nom"));
                clinique.setCoordonnées(result.getString("coordonnees"));

            }
            ConnexionBD.closeConnection();

        } catch (SQLException ex) {
            Logger.getLogger(CliniqueImpDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return clinique;
    }

    @Override
    public Clinique findByCoordonnes(String coordonnees) {
        Clinique clinique = null;
        try {

            // Initilise la requete préparé de la basé sur la connexion
            // la requete SQL passé en argument pour construire l'objet PreparedStatement
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_BY_COORDONNEES);
            // on initialise la propriete nom du l'ulisateur avec sa premiere valeur
            ps.setString(1, coordonnees);
            // on execute la requete  et on recupere les resultats dans la requete
            ResultSet result = ps.executeQuery();

            //initilisation de la listeUtilisateur
            while (result.next()) {
                clinique = new Clinique();
                clinique.setId(result.getInt("idclinique"));
                clinique.setNom(result.getString("nom"));
                clinique.setCoordonnées(result.getString("coordonnees"));

            }
            ConnexionBD.closeConnection();

        } catch (SQLException ex) {
            Logger.getLogger(CliniqueImpDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return clinique;
    }

    @Override
    public Clinique findByService(String service) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }



}
