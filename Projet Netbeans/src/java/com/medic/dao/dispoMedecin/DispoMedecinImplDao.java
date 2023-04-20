/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.medic.dao.dispoMedecin;

import com.medic.entities.DispoMedecin;
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
 * @author hundl
 */
public class DispoMedecinImplDao implements DispoMedecinDao {
    private static final String SQL_FIND_DISPOS = "select * from disponibilites_medecin";
    private static final String SQL_SELECT_BY_ID_DISPO = "select * from disponibilites_medecin where iddisponibilites_medecin =?";
    private static final String SQL_SELECT_BY_ID_MEDECIN = "SELECT * FROM disponibilites_medecin where idMedecinDispo = ?";
    private static final String SQL_SELECT_BY_DATE = "SELECT * FROM disponibilites_medecin where dateDispo = ?";
    private static final String SQL_DISPO_EXISTE = "SELECT * FROM disponibilites_medecin where dateDispo = ? and idMedecinDispo = ?";
    private static final String SQL_INSERT_DISPO = "INSERT INTO disponibilites_medecin (iddisponibilites_medecin, idMedecinDispo, dateDispo, heureDispoDebut,heureDispoFin) VALUES (?, ?,?, ? , ?)";
    private static final String SQL_DELETE_DISPO = "delete from disponibilites_medecin where iddisponibilites_medecin = ?";
    private static final String SQL_SELECT_MAX_ID_DISPO = "SELECT max(iddisponibilites_medecin) FROM disponibilites_medecin";
    private static final String SQL_UPDATE_DISPO = "UPDATE disponibilites_medecin SET dateDispo = ?, heureDispoDebut = ?, heureDispoFin = ? WHERE (iddisponibilites_medecin = ?)";

    @Override
    public List<DispoMedecin> findAll() {
        List<DispoMedecin> listeDispo = null;
        try {

            //Initialise la requête préparée basée sur la connexion
            // la requête SQL passé en argument pour construire l'objet preparedStatement
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_FIND_DISPOS);
            //On execute la requête et on récupère les résultats dans la requête 
            // dans ResultSet
            ResultSet result = ps.executeQuery();

            listeDispo = new ArrayList<>();
            //// la méthode next() pour se déplacer sur l'enregistrement suivant
            //on parcours ligne par ligne les résultas retournés
            while (result.next()) {
                DispoMedecin dispo = new DispoMedecin();
                dispo.setIdDispoMedecin(result.getInt("iddisponibilites_medecin"));
                dispo.setIdMedecinDispo(result.getInt("idMedecinDispo"));
                dispo.setDateDispo(result.getString("dateDispo"));
                dispo.setHeureDispoDebut(result.getString("heureDispoDebut"));
                dispo.setHeureDispoFin(result.getString("heureDispoFin"));

                listeDispo.add(dispo);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DispoMedecinImplDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Fermeture de toutes les ressources ouvertes
        ConnexionBD.closeConnection();
        return listeDispo;
    }

    @Override
    public DispoMedecin findByIdDispo(int id) {
        DispoMedecin dispo = null;
        try {

            // Initilise la requete préparé de la basé sur la connexion
            // la requete SQL passé en argument pour construire l'objet PreparedStatement
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_BY_ID_DISPO);
            // on initialise la propriete nom du l'ulisateur avec sa premiere valeur
            ps.setInt(1, id);

            // on execute la requete  et on recupere les resultats dans la requete
            ResultSet result = ps.executeQuery();
            //initilisation de la listeUtilisateur
            while (result.next()) {
                dispo = new DispoMedecin();
                dispo.setIdDispoMedecin(result.getInt("iddisponibilites_medecin"));
                dispo.setIdMedecinDispo(result.getInt("idMedecinDispo"));
                dispo.setDateDispo(result.getString("dateDispo"));
                dispo.setHeureDispoDebut(result.getString("heureDispoDebut"));
                dispo.setHeureDispoFin(result.getString("heureDispoFin"));

            }
            ConnexionBD.closeConnection();

        } catch (SQLException ex) {
            Logger.getLogger(DispoMedecinImplDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return dispo;

    }

    @Override
    public List<DispoMedecin> findDispoByIdMedecin(int idMedecin) {
        List<DispoMedecin> listeDispo = null;
        try {

            // Initilise la requete préparé de la basé sur la connexion
            // la requete SQL passé en argument pour construire l'objet PreparedStatement
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_BY_ID_MEDECIN);
            // on initialise la propriete nom du l'ulisateur avec sa premiere valeur
            ps.setInt(1, idMedecin);

            // on execute la requete  et on recupere les resultats dans la requete
            ResultSet result = ps.executeQuery();

            //initilisation de la listeUtilisateur
            listeDispo = new ArrayList<>();
            while (result.next()) {
                DispoMedecin dispo = new DispoMedecin();
                dispo.setIdDispoMedecin(result.getInt("iddisponibilites_medecin"));
                dispo.setIdMedecinDispo(result.getInt("idMedecinDispo"));
                dispo.setDateDispo(result.getString("dateDispo"));
                dispo.setHeureDispoDebut(result.getString("heureDispoDebut"));
                dispo.setHeureDispoFin(result.getString("heureDispoFin"));

                listeDispo.add(dispo);

            }
            ConnexionBD.closeConnection();

        } catch (SQLException ex) {
            Logger.getLogger(DispoMedecinImplDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listeDispo;
    }

    @Override
    public List<DispoMedecin> findDispoByDate(String date) {
        List<DispoMedecin> listeDispo = null;
        try {

            // Initilise la requete préparé de la basé sur la connexion
            // la requete SQL passé en argument pour construire l'objet PreparedStatement
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_BY_DATE);
            // on initialise la propriete nom du l'ulisateur avec sa premiere valeur
            ps.setString(1, date);

            // on execute la requete  et on recupere les resultats dans la requete
            ResultSet result = ps.executeQuery();

            //initilisation de la listeUtilisateur
            listeDispo = new ArrayList<>();
            while (result.next()) {
                DispoMedecin dispo = new DispoMedecin();
                dispo.setIdDispoMedecin(result.getInt("iddisponibilites_medecin"));
                dispo.setIdMedecinDispo(result.getInt("idMedecinDispo"));
                dispo.setDateDispo(result.getString("dateDispo"));
                dispo.setHeureDispoDebut(result.getString("heureDispoDebut"));
                dispo.setHeureDispoFin(result.getString("heureDispoFin"));

                listeDispo.add(dispo);

            }
            ConnexionBD.closeConnection();

        } catch (SQLException ex) {
            Logger.getLogger(DispoMedecinImplDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listeDispo;
    }

    

    @Override
    public boolean create(DispoMedecin dispo) {
        boolean retour = false;
        int nbLigne = 0;
        
        Connection conn = null;
        try {
            conn = ConnexionBD.getConnection();
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_INSERT_DISPO);
            //   Insérer les données dans la table parente, utilisateurs
            ps.setInt(1, dispo.getIdDispoMedecin());
            ps.setInt(2, dispo.getIdMedecinDispo());
            ps.setString(3, dispo.getDateDispo());
            ps.setString(4, dispo.getHeureDispoDebut());
            ps.setString(5, dispo.getHeureDispoFin());         

            nbLigne = ps.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            if (conn != null) {
                try {
                    conn.rollback();
                    conn.setAutoCommit(true); // réactive l'auto-commit
                    conn.close();

                } catch (SQLException ex) {
                    // Traiter l'exception ici
                    System.out.println("Erreur dans la transaction ");
                }
            }
            Logger.getLogger(DispoMedecinImplDao.class.getName()).log(Level.SEVERE, null, e);
        }

//		System.out.println("nb ligne " + nbLigne);
        if (nbLigne > 0) {
            retour = true;
        }
        ConnexionBD.closeConnection();
        return retour;
    }



    @Override
    public boolean delete(int idDispo) {
        boolean retour = false;
        int nbLigne = 0;
        PreparedStatement ps;
        try {
            // Désactiver les contraintes de clé étrangère
            ps = ConnexionBD.getConnection().prepareStatement(SQL_DELETE_DISPO);
            ps.setInt(1, idDispo);

            nbLigne = ps.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            Logger.getLogger(DispoMedecinImplDao.class.getName()).log(Level.SEVERE, null, e);
        }

        if (nbLigne > 0) {
            retour = true;
        }
        ConnexionBD.closeConnection();
        return retour;
    }

    @Override
    public DispoMedecin dispoExistante(int idMedecin,String date) {
        DispoMedecin uneDispo = null;
        try {

            // Initilise la requete préparé de la basé sur la connexion
            // la requete SQL passé en argument pour construire l'objet PreparedStatement
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_DISPO_EXISTE);
            // on initialise la propriete nom du l'ulisateur avec sa premiere valeur
            ps.setString(1, date);
            ps.setInt(2, idMedecin);
            

            // on execute la requete  et on recupere les resultats dans la requete
            ResultSet result = ps.executeQuery();
            //initilisation de la listeUtilisateur
            while (result.next()) {
                uneDispo = new DispoMedecin();
                uneDispo.setIdDispoMedecin(result.getInt("iddisponibilites_medecin"));
                uneDispo.setIdMedecinDispo(result.getInt("idMedecinDispo"));
                uneDispo.setDateDispo(result.getString("dateDispo"));
                uneDispo.setHeureDispoDebut(result.getString("heureDispoDebut"));
                uneDispo.setHeureDispoFin(result.getString("heureDispoFin"));

            }
            ConnexionBD.closeConnection();

        } catch (SQLException ex) {
            Logger.getLogger(DispoMedecinImplDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return uneDispo;

    }

    @Override
    public int findMaxIdDispo() {
        Integer idMaximal = null;
        try {

            // Initilise la requete préparé de la basé sur la connexion
            // la requete SQL passé en argument pour construire l'objet PreparedStatement
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_MAX_ID_DISPO);
            // on initialise la propriete nom du l'ulisateur avec sa premiere valeur

            // on execute la requete  et on recupere les resultats dans la requete
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                idMaximal = result.getInt("max(iddisponibilites_medecin)");
            }
            
            ConnexionBD.closeConnection();

        } catch (SQLException ex) {
            Logger.getLogger(DispoMedecinImplDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return idMaximal;
    }

    @Override
    public boolean update(DispoMedecin dispo) {
        boolean retour = false;
        int nbLigne = 0;
        PreparedStatement ps;

        try {

            ps = ConnexionBD.getConnection().prepareStatement(SQL_UPDATE_DISPO);
            
            ps.setInt(1, dispo.getIdDispoMedecin());
            ps.setInt(2, dispo.getIdMedecinDispo());
            ps.setString(3, dispo.getDateDispo());
            ps.setString(4, dispo.getHeureDispoDebut());
            ps.setString(5, dispo.getHeureDispoFin());     


            nbLigne = ps.executeUpdate();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            Logger.getLogger(DispoMedecinImplDao.class.getName()).log(Level.SEVERE, null, e);
        }

//		System.out.println("nb ligne " + nbLigne);
        if (nbLigne > 0) {
            retour = true;
        }
        ConnexionBD.closeConnection();
        return retour;
    }
    
}
