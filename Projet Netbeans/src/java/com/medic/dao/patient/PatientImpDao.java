package com.medic.dao.patient;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */





import com.medic.dao.medecin.MedecinImpDao;
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
public class PatientImpDao implements PatientDao {

    private static final String SQL_SELECT_PATIENT = "select * from patients";
    private static final String SQL_SELECT_BY_ID_PATIENT = "select * from patients where idpatient =?";
    private static final String SQL_INSERT_PATIENT = "insert into patients(idpatient, nom, prenom, assurance, numSeq_assurance, naissance, sexe, password) value(?,?,?,?,?,?,?,?)";
    private static final String SQL_UPDATE_PATIENT = "update patients set nom =?,prenom = ?, assurance =?, numSeq_assurance=?, naissance=?, naissance=?,sexe=?,pasword=? where idmedecin= ?";

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
                patient.setNom(result.getString("idpatient"));
                patient.setPrenom(result.getString("nom"));
                patient.setNumeroAssuranceMaladie(result.getString("assurance"));
                patient.setNumeroSequentiel(result.getInt("numSeq_assurance"));
                patient.setDateNaissance(result.getString("naissance"));
                patient.setMotDePasse(result.getString("password"));
                listePatient.add(patient);
            };
        } catch (SQLException ex) {
            Logger.getLogger(PatientImpDao.class.getName()).log(Level.SEVERE, null, ex);
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

            //initilisation de la listeUtilisateur
            while (result.next()) {
                patient = new Patient ();
                patient.setId(result.getInt("idpatient"));
                patient.setNom(result.getString("nom"));
                patient.setPrenom(result.getString("prenom"));
                patient.setNumeroAssuranceMaladie(result.getString("assurance"));
                patient.setNumeroSequentiel(result.getInt
        ("numSeq_assurance"));
                patient.setDateNaissance(result.getString("naissance"));
                patient.setSexe(result.getString("sexe"));
                patient.setMotDePasse(result.getString("password"));
                
                
                 patient.setMotDePasse(result.getString("password"));
                
                
                
                

            }
            ConnexionBD.closeConnection();

        } catch (SQLException ex) {
            Logger.getLogger(MedecinImpDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return patient;
        
    }

    @Override
    public Patient findByName(String nom) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Patient findByFirstName(String prenom) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Patient findByAssuranceMaladie(String assuranceMaladie) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Patient findBynumeroSequentiel(String numeroSequentiel) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Patient findBydateNaissance(String dateNaissance) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Patient findBySexe(String sexe) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean create(Patient patient) {
        boolean retour = false;
        int nbLigne = 0;
        PreparedStatement ps;

        try {
            ps = ConnexionBD.getConnection().prepareStatement(SQL_INSERT_PATIENT);
            //   Insérer les données dans la table parente, utilisateurs
            ps.setInt(1, patient.getId());
            ps.setString(2, patient.getNom());
            ps.setString(3, patient.getPrenom());
            ps.setString(4, patient.getNumeroAssuranceMaladie());
            ps.setInt(5, patient.getNumeroSequentiel());
            ps.setString(6, patient.getDateNaissance());

            ps.setString(7, patient.getSexe());
            ps.setString(8, patient.getMotDePasse());
            nbLigne = ps.executeUpdate();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            Logger.getLogger(PatientImpDao.class.getName()).log(Level.SEVERE, null, e);
        }

//		System.out.println("nb ligne " + nbLigne);
        if (nbLigne > 0) {
            retour = true;
        }
        ConnexionBD.closeConnection();
        return retour;
    }

//    @Override
//    public boolean update(Patient patient) {
//         boolean retour = false;
//        int nbLigne = 0;
//        PreparedStatement ps;
//
//        try {
//
//            ps = ConnexionBD.getConnection().prepareStatement();
//           
//            ps.setString(1, patient.getNom());
//            ps.setString(2, patient.getPrenom());
//            ps.setString(3, patient.getSpecialite());
//            ps.setFloat(4, patient.getFacturation());
//            ps.setString(5, patient.getMotDePasse());
//            ps.setInt(6, patient.getNumeroProfessionel());
//
//            nbLigne = ps.executeUpdate();
//
//        } catch (SQLException e) {
//            // TODO Auto-generated catch block
//            Logger.getLogger(MedecinImpDao.class.getName()).log(Level.SEVERE, null, e);
//        }
//
////		System.out.println("nb ligne " + nbLigne);
//        if (nbLigne > 0) {
//            retour = true;
//        }
//        ConnexionBD.closeConnection();
//        return retour;
//    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean update(Patient patient) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

 
   




}
