/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.medic.dao.rendezVous;

import com.medic.entities.RendezVous;
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
public class RendezVousImplDao implements RendezVousDao {

    private static final String SQL_SELECT_RENDEZVOUS = "SELECT * FROM `rendez-vous`";
    private static final String SQL_SELECT_RENDEZVOUS_PAR_ID = "SELECT * FROM `rendez-vous` where `idrendez-vous` = ?";
    private static final String SQL_SELECT_RENDEZVOUS_PAR_PATIENT_ID = "SELECT * FROM `rendez-vous` where idPatientRv = ?";
    private static final String SQL_SELECT_RENDEZVOUS_PAR_MEDECIN_ID = "SELECT * FROM `rendez-vous` where idMedecinRv = ?";
    private static final String SQL_SELECT_MAX_ID_RENDEZVOUS = "SELECT max(`idrendez-vous`) FROM `rendez-vous`";
    private static final String SQL_INSERT_RENDEZVOUS = "INSERT INTO `rendez-vous` (`idrendez-vous`, idPatientRv, idMedecinRv, dateRv, heureRv, raisonConsult, descriptionConsult) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE_RENDEZVOUS = "UPDATE `rendez-vous` SET idPatientRv = ?, idMedecinRv = ?, dateRv = ?, heureRv = ?, raisonConsult = ?, descriptionConsult = ? WHERE (`idrendez-vous` = ?)";
    private static final String SQL_DELETE_RENDEZVOUS = "delete FROM `rendez-vous` where `idrendez-vous` = ?";
    private static final String SQL_VERIFIER_RENDEZVOUS_PRIS = "SELECT * FROM `rendez-vous` where idMedecinRv = ? and dateRv = ? and heureRv = ?";
    
    @Override
    public List<RendezVous> findAll() {
        List<RendezVous> listeRendezVous = null;
        try {

            //Initialise la requête préparée basée sur la connexion
            // la requête SQL passé en argument pour construire l'objet preparedStatement
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_RENDEZVOUS);
            //On execute la requête et on récupère les résultats dans la requête 
            // dans ResultSet
            ResultSet result = ps.executeQuery();

            listeRendezVous = new ArrayList<>();
            //// la méthode next() pour se déplacer sur l'enregistrement suivant
            //on parcours ligne par ligne les résultas retournés
            while (result.next()) {
                RendezVous unRendezVous = new RendezVous();

                //medecin.setNumeroProfessionel(result.getInt("idmedecin"));
                unRendezVous.setIdRendezVous(result.getInt("idrendez-vous"));
                unRendezVous.setIdPatientRv(result.getInt("idPatientRv"));
                unRendezVous.setIdMedecinRv(result.getInt("idMedecinRv"));
                unRendezVous.setDateRv(result.getString("dateRv"));
                unRendezVous.setHeureRv(result.getString("heureRv"));
                unRendezVous.setRaisonConsult(result.getString("raisonConsult"));
                unRendezVous.setRaisonConsult(result.getString("descriptionConsult"));
                
                listeRendezVous.add(unRendezVous);
            }
        } catch (SQLException ex) {
            Logger.getLogger(RendezVousImplDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Fermeture de toutes les ressources ouvertes
        ConnexionBD.closeConnection();
        return listeRendezVous;
    }

    @Override
    public RendezVous findByIdRv(int id) {
        RendezVous unRendezVous = null;
        try {

            // Initilise la requete préparé de la basé sur la connexion
            // la requete SQL passé en argument pour construire l'objet PreparedStatement
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_RENDEZVOUS_PAR_ID);
            // on initialise la propriete nom du l'ulisateur avec sa premiere valeur
            ps.setInt(1, id);

            // on execute la requete  et on recupere les resultats dans la requete
            ResultSet result = ps.executeQuery();
            //initilisation de la listeUtilisateur
            while (result.next()) {
                unRendezVous = new RendezVous();
                unRendezVous.setIdRendezVous(result.getInt("idrendez-vous"));
                unRendezVous.setIdPatientRv(result.getInt("idPatientRv"));
                unRendezVous.setIdMedecinRv(result.getInt("idMedecinRv"));
                unRendezVous.setDateRv(result.getString("dateRv"));
                unRendezVous.setHeureRv(result.getString("heureRv"));
                unRendezVous.setRaisonConsult(result.getString("raisonConsult"));
                unRendezVous.setRaisonConsult(result.getString("descriptionConsult"));

            }
            ConnexionBD.closeConnection();

        } catch (SQLException ex) {
            Logger.getLogger(RendezVousImplDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return unRendezVous;
    }

    @Override
    public List<RendezVous> findByIdPatient(int idPatient) {
        List<RendezVous> listeRendezVous = null;
        try {

            // Initilise la requete préparé de la basé sur la connexion
            // la requete SQL passé en argument pour construire l'objet PreparedStatement
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_RENDEZVOUS_PAR_PATIENT_ID);
            // on initialise la propriete nom du l'ulisateur avec sa premiere valeur
            ps.setInt(1, idPatient);

            // on execute la requete  et on recupere les resultats dans la requete
            ResultSet result = ps.executeQuery();

            //initilisation de la listeUtilisateur
            listeRendezVous = new ArrayList<>();
            while (result.next()) {
                RendezVous unRendezVous = new RendezVous();
                unRendezVous.setIdRendezVous(result.getInt("idrendez-vous"));
                unRendezVous.setIdPatientRv(result.getInt("idPatientRv"));
                unRendezVous.setIdMedecinRv(result.getInt("idMedecinRv"));
                unRendezVous.setDateRv(result.getString("dateRv"));
                unRendezVous.setHeureRv(result.getString("heureRv"));
                unRendezVous.setRaisonConsult(result.getString("raisonConsult"));
                unRendezVous.setRaisonConsult(result.getString("descriptionConsult"));
                
                listeRendezVous.add(unRendezVous);

            }
            ConnexionBD.closeConnection();

        } catch (SQLException ex) {
            Logger.getLogger(RendezVousImplDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listeRendezVous;
    }

    @Override
    public List<RendezVous> findByIdMedecin(int idMedecin) {
        List<RendezVous> listeRendezVous = null;
        try {

            // Initilise la requete préparé de la basé sur la connexion
            // la requete SQL passé en argument pour construire l'objet PreparedStatement
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_RENDEZVOUS_PAR_MEDECIN_ID);
            // on initialise la propriete nom du l'ulisateur avec sa premiere valeur
            ps.setInt(1, idMedecin);

            // on execute la requete  et on recupere les resultats dans la requete
            ResultSet result = ps.executeQuery();

            //initilisation de la listeUtilisateur
            listeRendezVous = new ArrayList<>();
            while (result.next()) {
                RendezVous unRendezVous = new RendezVous();
                unRendezVous.setIdRendezVous(result.getInt("idrendez-vous"));
                unRendezVous.setIdPatientRv(result.getInt("idPatientRv"));
                unRendezVous.setIdMedecinRv(result.getInt("idMedecinRv"));
                unRendezVous.setDateRv(result.getString("dateRv"));
                unRendezVous.setHeureRv(result.getString("heureRv"));
                unRendezVous.setRaisonConsult(result.getString("raisonConsult"));
                unRendezVous.setRaisonConsult(result.getString("descriptionConsult"));
                
                listeRendezVous.add(unRendezVous);

            }
            ConnexionBD.closeConnection();

        } catch (SQLException ex) {
            Logger.getLogger(RendezVousImplDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listeRendezVous;
    }

    @Override
    public int findMaxIdRv() {
        Integer idMaximal = null;
        try {

            // Initilise la requete préparé de la basé sur la connexion
            // la requete SQL passé en argument pour construire l'objet PreparedStatement
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_MAX_ID_RENDEZVOUS);
            // on initialise la propriete nom du l'ulisateur avec sa premiere valeur

            // on execute la requete  et on recupere les resultats dans la requete
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                idMaximal = result.getInt("max(`idrendez-vous`)");
            }
            
            ConnexionBD.closeConnection();

        } catch (SQLException ex) {
            Logger.getLogger(RendezVousImplDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return idMaximal;
    }

    @Override
    public boolean create(RendezVous rendezVous) {
        boolean retour = false;
        int nbLigne = 0;
        
        Connection conn = null;
        try {
            conn = ConnexionBD.getConnection();
            
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_INSERT_RENDEZVOUS);
            conn.setAutoCommit(false);
            //   Insérer les données dans la table parente, utilisateurs
            ps.setInt(1, rendezVous.getIdRendezVous());
            ps.setInt(2, rendezVous.getIdPatientRv());
            ps.setInt(3, rendezVous.getIdMedecinRv());
            ps.setString(4, rendezVous.getDateRv());
            ps.setString(5, rendezVous.getHeureRv());
            ps.setString(6, rendezVous.getRaisonConsult());
            ps.setString(7, rendezVous.getDescriptionConsult());

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
            Logger.getLogger(RendezVousImplDao.class.getName()).log(Level.SEVERE, null, e);
        }

//		System.out.println("nb ligne " + nbLigne);
        if (nbLigne > 0) {
            retour = true;
        }
        ConnexionBD.closeConnection();
        return retour;
    }

    @Override
    public boolean update(RendezVous rendezVous) {
        boolean retour = false;
        int nbLigne = 0;
        PreparedStatement ps;

        try {

            ps = ConnexionBD.getConnection().prepareStatement(SQL_UPDATE_RENDEZVOUS);
            
            
            ps.setInt(1, rendezVous.getIdPatientRv());
            ps.setInt(2, rendezVous.getIdMedecinRv());
            ps.setString(3, rendezVous.getDateRv());
            ps.setString(4, rendezVous.getHeureRv());
            ps.setString(5, rendezVous.getRaisonConsult());
            ps.setString(6, rendezVous.getDescriptionConsult());   
            ps.setInt(7, rendezVous.getIdRendezVous());

            nbLigne = ps.executeUpdate();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            Logger.getLogger(RendezVousImplDao.class.getName()).log(Level.SEVERE, null, e);
        }

//		System.out.println("nb ligne " + nbLigne);
        if (nbLigne > 0) {
            retour = true;
        }
        ConnexionBD.closeConnection();
        return retour;
    }

    @Override
    public boolean delete(int idRv) {
        boolean retour = false;
        int nbLigne = 0;
        PreparedStatement ps;
        try {
            // Désactiver les contraintes de clé étrangère
            ps = ConnexionBD.getConnection().prepareStatement(SQL_DELETE_RENDEZVOUS);
            ps.setInt(1, idRv);

            nbLigne = ps.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            Logger.getLogger(RendezVousImplDao.class.getName()).log(Level.SEVERE, null, e);
        }

        if (nbLigne > 0) {
            retour = true;
        }
        ConnexionBD.closeConnection();
        return retour;
    }

    @Override
    public RendezVous verifierRendezVousPris(int idMedecin, String date, String heure) {
        RendezVous unRendezVous = null;
        try {

            // Initilise la requete préparé de la basé sur la connexion
            // la requete SQL passé en argument pour construire l'objet PreparedStatement
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_VERIFIER_RENDEZVOUS_PRIS);
            // on initialise la propriete nom du l'ulisateur avec sa premiere valeur
            ps.setInt(1, idMedecin);
            ps.setString(2, date);
            ps.setString(3, heure);

            // on execute la requete  et on recupere les resultats dans la requete
            ResultSet result = ps.executeQuery();
            //initilisation de la listeUtilisateur
            while (result.next()) {
                unRendezVous = new RendezVous();
                unRendezVous.setIdRendezVous(result.getInt("idrendez-vous"));
                unRendezVous.setIdPatientRv(result.getInt("idPatientRv"));
                unRendezVous.setIdMedecinRv(result.getInt("idMedecinRv"));
                unRendezVous.setDateRv(result.getString("dateRv"));
                unRendezVous.setHeureRv(result.getString("heureRv"));
                unRendezVous.setRaisonConsult(result.getString("raisonConsult"));
                unRendezVous.setRaisonConsult(result.getString("descriptionConsult"));

            }
            ConnexionBD.closeConnection();

        } catch (SQLException ex) {
            Logger.getLogger(RendezVousImplDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return unRendezVous;
    }

}
