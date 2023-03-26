package com.medic.dao.patient;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.medic.dao.medecin.MedecinImplDao;
import com.medic.dao.patient.PatientDao;
import com.medic.entities.Medecin;
import com.medic.entities.Patient;
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
public class PatientImplDao implements PatientDao {

    private static final String SQL_SELECT_PATIENT = "select * from patients";
    private static final String SQL_SELECT_BY_ID_PATIENT = "select * from patients where idpatient =?";
    private static final String SQL_INSERT_PATIENT = "insert into patients(idpatient, nom, prenom, assurance, numSeq_assurance, naissance, sexe, password,medecin_idmedecin) value(?,?,?,?,?,?,?,?,?)";
    private static final String SQL_UPDATE_PATIENT = "UPDATE patients SET idpatient=?,nom=?,prenom =?,assurance=?,numSeq_assurance=?,naissance=?,sexe=?,password=?,medecin_idmedecin=? WHERE idpatient=?";
    private static final String SQL_CONNEXION_PATIENT_NUMERO_PASSWORD = "SELECT * from patients where assurance = ? and password = ?";
    private static final String SQL_SELECT_BY_NOM = "SELECT * FROM patients where nom = ?";
    private static final String SQL_SELECT_BY_PRENOM = "SELECT * FROM patients where prenom = ?";
    private static final String SQL_SELECT_ASSURANCE = "SELECT * FROM patients where assurance = ?";
    private static final String SQL_SELECT_BY_NAISSANCE = "SELECT * FROM patients where naissance = ?";
    private static final String SQL_SELECT_BY_SEXE = "SELECT * FROM patients where sexe = ?";
    private static final String SQL_DELETE_PATIENT_PAR_ID = "delete from patients where idpatient = ?";
    private static final String SQL_SELECT_MAX_ID_PATIENT = "SELECT max(idpatient) FROM patients";
    

    @Override
    public List<Patient> findAll() {
        List<Patient> listePatient = null;
        try {

            //Initialise la requête préparée basée sur la connexion
            // la requête SQL passé en argument pour construire l'objet preparedStatement
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_PATIENT);
            System.out.println(" result : " + ps.toString());
            //On execute la requête et on récupère les résultats dans la requête 
            // dans ResultSet
            ResultSet result = ps.executeQuery();

            listePatient = new ArrayList<>();
            //// la méthode next() pour se déplacer sur l'enregistrement suivant
            //on parcours ligne par ligne les résultas retournés
            while (result.next()) {
                Patient patient = new Patient();

                //medecin.setNumeroProfessionel(result.getInt("idmedecin"));
                patient.setId(result.getInt("idpatient"));
                patient.setNom(result.getString("nom"));
                patient.setPrenom(result.getString("prenom"));
                patient.setNumeroAssuranceMaladie(result.getString("assurance"));
                patient.setNumeroSequentiel(result.getInt("numSeq_assurance"));
                patient.setDateNaissance(result.getString("naissance"));
                patient.setSexe(result.getString("sexe"));
                patient.setMotDePasse(result.getString("password"));
                patient.setIdMedecinFamille(result.getInt("medecin_idmedecin"));
                listePatient.add(patient);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PatientImplDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Fermeture de toutes les ressources ouvertes
        ConnexionBD.closeConnection();
        return listePatient;
    }

    @Override
    public Patient findByIdPatient(int id) {
        Patient patient = null;
        try {

            // Initilise la requete préparé de la basé sur la connexion
            // la requete SQL passé en argument pour construire l'objet PreparedStatement
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_BY_ID_PATIENT);
            // on initialise la propriete nom du l'ulisateur avec sa premiere valeur
            ps.setInt(1, id);

            // on execute la requete  et on recupere les resultats dans la requete
            ResultSet result = ps.executeQuery();
            System.out.println(ps);
            //initilisation de la listeUtilisateur
            while (result.next()) {
                patient = new Patient();
                patient.setId(result.getInt("idpatient"));
                patient.setNom(result.getString("nom"));
                patient.setPrenom(result.getString("prenom"));
                patient.setNumeroAssuranceMaladie(result.getString("assurance"));
                patient.setNumeroSequentiel(result.getInt("numSeq_assurance"));
                patient.setDateNaissance(result.getString("naissance"));
                patient.setSexe(result.getString("sexe"));
                patient.setMotDePasse(result.getString("password"));
                patient.setIdMedecinFamille(result.getInt("medecin_idmedecin"));

            }
            ConnexionBD.closeConnection();

        } catch (SQLException ex) {
            Logger.getLogger(MedecinImplDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return patient;

    }

    @Override
    public List<Patient> findByName(String nom) {
        List<Patient> listePatient = null;
        try {

            // Initilise la requete préparé de la basé sur la connexion
            // la requete SQL passé en argument pour construire l'objet PreparedStatement
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_BY_NOM);
            // on initialise la propriete nom du l'ulisateur avec sa premiere valeur
            ps.setString(1, nom);

            // on execute la requete  et on recupere les resultats dans la requete
            ResultSet result = ps.executeQuery();

            //initilisation de la listeUtilisateur
            listePatient = new ArrayList<>();
            while (result.next()) {
                Patient patient = new Patient();
                patient.setId(result.getInt("idpatient"));
                patient.setNom(result.getString("nom"));
                patient.setPrenom(result.getString("prenom"));
                patient.setNumeroAssuranceMaladie(result.getString("assurance"));
                patient.setNumeroSequentiel(result.getInt("numSeq_assurance"));
                patient.setDateNaissance(result.getString("naissance"));
                patient.setSexe(result.getString("sexe"));
                patient.setMotDePasse(result.getString("password"));
                patient.setIdMedecinFamille(result.getInt("medecin_idmedecin"));

                listePatient.add(patient);

            }
            ConnexionBD.closeConnection();

        } catch (SQLException ex) {
            Logger.getLogger(MedecinImplDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listePatient;
    }

    @Override
    public List<Patient> findByFirstName(String prenom) {
        List<Patient> listePatient = null;
        try {

            // Initilise la requete préparé de la basé sur la connexion
            // la requete SQL passé en argument pour construire l'objet PreparedStatement
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_BY_PRENOM);
            // on initialise la propriete nom du l'ulisateur avec sa premiere valeur
            ps.setString(1, prenom);

            // on execute la requete  et on recupere les resultats dans la requete
            ResultSet result = ps.executeQuery();

            //initilisation de la listeUtilisateur
            listePatient = new ArrayList<>();
            while (result.next()) {
                Patient patient = new Patient();
                patient.setId(result.getInt("idpatient"));
                patient.setNom(result.getString("nom"));
                patient.setPrenom(result.getString("prenom"));
                patient.setNumeroAssuranceMaladie(result.getString("assurance"));
                patient.setNumeroSequentiel(result.getInt("numSeq_assurance"));
                patient.setDateNaissance(result.getString("naissance"));
                patient.setSexe(result.getString("sexe"));
                patient.setMotDePasse(result.getString("password"));
                patient.setIdMedecinFamille(result.getInt("medecin_idmedecin"));
                listePatient.add(patient);

            }
            ConnexionBD.closeConnection();

        } catch (SQLException ex) {
            Logger.getLogger(MedecinImplDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listePatient;
    }

    @Override
    public Patient findByAssuranceMaladie(String assuranceMaladie) {
        Patient patient = null;
        try {

            // Initilise la requete préparé de la basé sur la connexion
            // la requete SQL passé en argument pour construire l'objet PreparedStatement
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_ASSURANCE);
            // on initialise la propriete nom du l'ulisateur avec sa premiere valeur
            ps.setString(1, assuranceMaladie);

            // on execute la requete  et on recupere les resultats dans la requete
            ResultSet result = ps.executeQuery();

            //initilisation de la listeUtilisateur
            while (result.next()) {
                patient = new Patient();
                patient.setId(result.getInt("idpatient"));
                patient.setNom(result.getString("nom"));
                patient.setPrenom(result.getString("prenom"));
                patient.setNumeroAssuranceMaladie(result.getString("assurance"));
                patient.setNumeroSequentiel(result.getInt("numSeq_assurance"));
                patient.setDateNaissance(result.getString("naissance"));
                patient.setSexe(result.getString("sexe"));
                patient.setMotDePasse(result.getString("password"));
                patient.setIdMedecinFamille(result.getInt("medecin_idmedecin"));

            }
            ConnexionBD.closeConnection();

        } catch (SQLException ex) {
            Logger.getLogger(MedecinImplDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return patient;
    }

    @Override
    public List<Patient> findBydateNaissance(String dateNaissance) {
        List<Patient> listePatient = null;
        try {

            // Initilise la requete préparé de la basé sur la connexion
            // la requete SQL passé en argument pour construire l'objet PreparedStatement
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_BY_NAISSANCE);
            // on initialise la propriete nom du l'ulisateur avec sa premiere valeur
            ps.setString(1, dateNaissance);

            // on execute la requete  et on recupere les resultats dans la requete
            ResultSet result = ps.executeQuery();

            //initilisation de la listeUtilisateur
            listePatient = new ArrayList<>();
            while (result.next()) {
                Patient patient = new Patient();
                patient.setId(result.getInt("idpatient"));
                patient.setNom(result.getString("nom"));
                patient.setPrenom(result.getString("prenom"));
                patient.setNumeroAssuranceMaladie(result.getString("assurance"));
                patient.setNumeroSequentiel(result.getInt("numSeq_assurance"));
                patient.setDateNaissance(result.getString("naissance"));
                patient.setSexe(result.getString("sexe"));
                patient.setMotDePasse(result.getString("password"));
                patient.setIdMedecinFamille(result.getInt("medecin_idmedecin"));
                listePatient.add(patient);

            }
            ConnexionBD.closeConnection();

        } catch (SQLException ex) {
            Logger.getLogger(MedecinImplDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listePatient;
    }

    @Override
    public List<Patient> findBySexe(String sexe) {
        List<Patient> listePatient = null;
        try {

            // Initilise la requete préparé de la basé sur la connexion
            // la requete SQL passé en argument pour construire l'objet PreparedStatement
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_BY_SEXE);
            // on initialise la propriete nom du l'ulisateur avec sa premiere valeur
            ps.setString(1, sexe);

            // on execute la requete  et on recupere les resultats dans la requete
            ResultSet result = ps.executeQuery();

            //initilisation de la listeUtilisateur
            listePatient = new ArrayList<>();
            while (result.next()) {
                Patient patient = new Patient();
                patient.setId(result.getInt("idpatient"));
                patient.setNom(result.getString("nom"));
                patient.setPrenom(result.getString("prenom"));
                patient.setNumeroAssuranceMaladie(result.getString("assurance"));
                patient.setNumeroSequentiel(result.getInt("numSeq_assurance"));
                patient.setDateNaissance(result.getString("naissance"));
                patient.setSexe(result.getString("sexe"));
                patient.setMotDePasse(result.getString("password"));
                patient.setIdMedecinFamille(result.getInt("medecin_idmedecin"));
                listePatient.add(patient);

            }
            ConnexionBD.closeConnection();

        } catch (SQLException ex) {
            Logger.getLogger(MedecinImplDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listePatient;
    }

    @Override
    public boolean create(Patient patient, int idMedecin) {
        boolean retour = false;
        Medecin medecin = null;
        int nbLigne = 0;

        Connection conn = null;
        MedecinImplDao medecinDao = new MedecinImplDao();

        try {
            medecin = medecinDao.findByIdMedecin(idMedecin);
            conn = ConnexionBD.getConnection();
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_INSERT_PATIENT);
            //   Insérer les données dans la table parente, utilisateurs
            ps.setInt(1, patient.getId());
            ps.setString(2, patient.getNom());
            ps.setString(3, patient.getPrenom());
            ps.setString(4, patient.getNumeroAssuranceMaladie());
            ps.setInt(5, patient.getNumeroSequentiel());
            ps.setString(6, patient.getDateNaissance());
            ps.setString(7, patient.getSexe());
            ps.setString(8, patient.getMotDePasse());
            ps.setString(8, patient.getMotDePasse());
            ps.setInt(9, medecin.getNumeroProfessionel());

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
            Logger.getLogger(PatientImplDao.class.getName()).log(Level.SEVERE, null, e);
        }

//		System.out.println("nb ligne " + nbLigne);
        if (nbLigne > 0) {
            retour = true;
        }
        ConnexionBD.closeConnection();
        return retour;
    }

    @Override
    public boolean delete(int id) {
        boolean retour = false;
        int nbLigne = 0;
        PreparedStatement ps;
        try {
            // Désactiver les contraintes de clé étrangère
            ps = ConnexionBD.getConnection().prepareStatement(SQL_DELETE_PATIENT_PAR_ID);
            ps.setInt(1, id);

            nbLigne = ps.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            Logger.getLogger(PatientImplDao.class.getName()).log(Level.SEVERE, null, e);
        }

        if (nbLigne > 0) {
            retour = true;
        }
        ConnexionBD.closeConnection();
        return retour;
    }

    @Override
    public boolean update(Patient patient, int idMedecin,int idFindPatient) {
        boolean retour = false;
        int nbLigne = 0;
        PreparedStatement ps;

        try {

            ps = ConnexionBD.getConnection().prepareStatement(SQL_UPDATE_PATIENT);
            
            ps.setInt(1, patient.getId());
            ps.setString(2, patient.getNom());
            ps.setString(3, patient.getPrenom());
            ps.setString(4, patient.getNumeroAssuranceMaladie());
            ps.setInt(5, patient.getNumeroSequentiel());
            ps.setString(6, patient.getDateNaissance());
            ps.setString(7, patient.getSexe());        
            ps.setString(8, patient.getMotDePasse());     
            ps.setInt(9,idMedecin);
            ps.setInt(10,idFindPatient);

            nbLigne = ps.executeUpdate();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            Logger.getLogger(MedecinImplDao.class.getName()).log(Level.SEVERE, null, e);
        }

//		System.out.println("nb ligne " + nbLigne);
        if (nbLigne > 0) {
            retour = true;
        }
        ConnexionBD.closeConnection();
        return retour;
    }

    @Override
    public Patient existByNumeroMotPasse(String numero, String motPasse) {
        Patient patient = null;
        try {

            //Initialise la requête préparée basée sur la connexion
            // la requête SQL passé en argument pour construire l'objet preparedStatement
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_CONNEXION_PATIENT_NUMERO_PASSWORD);
            // on initialise la propriété email du bean avec sa premiere valeur
            ps.setString(1, numero);
            ps.setString(2, motPasse);
            //On execute la requête et on récupère les résultats dans la requête 
            // dans ResultSet
            ResultSet result = ps.executeQuery();

            //// la méthode next() pour se déplacer sur l'enregistrement suivant
            //on parcours ligne par ligne les résultas retournés
            while (result.next()) {
                patient = new Patient();

                patient.setId(result.getInt("idpatient"));
                patient.setNom(result.getString("nom"));
                patient.setPrenom(result.getString("prenom"));
                patient.setNumeroAssuranceMaladie(result.getString("assurance"));
                patient.setNumeroSequentiel(result.getInt("numSeq_assurance"));
                patient.setDateNaissance(result.getString("naissance"));
                patient.setSexe(result.getString("sexe"));
                patient.setMotDePasse(result.getString("password"));
                patient.setIdMedecinFamille(result.getInt("medecin_idmedecin"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(PatientImplDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Fermeture de toutes les ressources ouvertes
        ConnexionBD.closeConnection();
        return patient;
    }

    @Override
    public int findMaxIdPatient() {
        Integer idMaximal = null;
        try {

            // Initilise la requete préparé de la basé sur la connexion
            // la requete SQL passé en argument pour construire l'objet PreparedStatement
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_MAX_ID_PATIENT);
            // on initialise la propriete nom du l'ulisateur avec sa premiere valeur

            // on execute la requete  et on recupere les resultats dans la requete
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                idMaximal = result.getInt("max(idpatient)");
            }
            
            System.out.println(idMaximal);
            ConnexionBD.closeConnection();

        } catch (SQLException ex) {
            Logger.getLogger(MedecinImplDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return idMaximal;
    }

}
