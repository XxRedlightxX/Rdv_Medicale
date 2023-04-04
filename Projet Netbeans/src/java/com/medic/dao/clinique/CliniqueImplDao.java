package com.medic.dao.clinique;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import com.medic.dao.clinique.CliniqueDao;
import com.medic.entities.Clinique;
import com.medic.entities.Medecin;
import com.medic.entities.Patient;
import com.medic.entities.ServicesClinique;
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
public class CliniqueImplDao implements CliniqueDao {

    private static final String SQL_SELECT_CLINIQUES = "select * from clinique";
    private static final String SQL_SELECT_BY_ID = "select * from clinique where idclinique =?";
    private static final String SQL_SELECT_BY_NAME = "select * from clinique where nom = ?";
    private static final String SQL_SELECT_BY_COORDONNEES = "select * from clinique where coordonnees = ?";
    private static final String SQL_SELECT_BY_SERVICES ="select * from clinique as c join clinique_has_services as cs on c.idclinique = cs.clinique_idclinique join services as s on s.idservice = cs.services_idservice where s.nom = ?;";
    private static final String SQL_SELECT_ALLSERVICES = "select s.idservice,s.nom,s.description from services as s join clinique_has_services as cs on s.idservice = cs.services_idservice join clinique as c on c.idclinique = cs.clinique_idclinique where c.nom = ?;";
    private static final String SQL_SELECT_ALLMEDECINS = "select m.idmedecin,m.nom,m.prenom,m.specialite,m.facturation,m.password from medecin as m join clinique as c on m.clinique_idclinique = c.idclinique where c.nom= ?;";
    private static final String SQL_SELECT_ALLPATIENTS = "select p.idpatient,p.nom,p.prenom,p.assurance,p.numSeq_assurance,p.naissance,p.sexe,p.password from patients as p join medecin as m on p.medecin_idmedecin = m.idmedecin join clinique as c on c.idclinique = m.clinique_idclinique where c.nom = ?;";
    private static final String SQL_INSERT_CLINIQUE = "insert into clinique(idclinique,nom,coordonnees) value(?,?,?)";
    private static final String SQL_UPDATE_CLINIQUE = "update clinique set idclinique =?,nom=?, coordonnees=? where idclinique= ?";
    private static final String SQL_DELETE_CLINIQUE = "delete from clinique where idclinique = ?";
    private static final String SQL_DELETE_ID_CLINIQUE_DES_MEDECINS = "UPDATE medecin SET clinique_idclinique = NULL WHERE (clinique_idclinique = ?)";
    private static final String SQL_SELECT_MAX_ID_CLINIQUE = "SELECT max(idclinique) FROM clinique";


            
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
                clinique.setCoordonnees(result.getString("coordonnees"));

                listeClinique.add(clinique);
            }
            ConnexionBD.closeConnection();

        } catch (SQLException ex) {
            Logger.getLogger(CliniqueImplDao.class.getName()).log(Level.SEVERE, null, ex);
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
                clinique.setCoordonnees(result.getString("coordonnees"));

            }
            ConnexionBD.closeConnection();

        } catch (SQLException ex) {
            Logger.getLogger(CliniqueImplDao.class.getName()).log(Level.SEVERE, null, ex);
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
                clinique.setCoordonnees(result.getString("coordonnees"));

            }
            ConnexionBD.closeConnection();

        } catch (SQLException ex) {
            Logger.getLogger(CliniqueImplDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return clinique;
    }

    @Override
    public List<Clinique> findByCoordonnes(String coordonnees) {
        List<Clinique> listeClinique = null;
        try {

            // Initilise la requete préparé de la basé sur la connexion
            // la requete SQL passé en argument pour construire l'objet PreparedStatement
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_BY_COORDONNEES);
            // on initialise la propriete nom du l'ulisateur avec sa premiere valeur
            ps.setString(1, coordonnees);
            // on execute la requete  et on recupere les resultats dans la requete
            ResultSet result = ps.executeQuery();
            listeClinique = new ArrayList<>();
            //initilisation de la listeUtilisateur
            while (result.next()) {
                Clinique clinique = new Clinique();
                clinique.setId(result.getInt("idclinique"));
                clinique.setNom(result.getString("nom"));
                clinique.setCoordonnees(result.getString("coordonnees"));
                listeClinique.add(clinique);

            }
            ConnexionBD.closeConnection();

        } catch (SQLException ex) {
            Logger.getLogger(CliniqueImplDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listeClinique;
    }

    @Override
    public List<Clinique> findByService(String service) {
        List<Clinique> listeClinique = null;
        try {
            // Initilise la requete préparé de la basé sur la connexion
            // la requete SQL passé en argument pour construire l'objet PreparedStatement
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_BY_SERVICES);
            // on execute la requete  et on recupere les resultats dans la requete
            ps.setString(1, service);
            ResultSet result = ps.executeQuery();

            //initilisation de la listeUtilisateur
            listeClinique = new ArrayList();
            while (result.next()) {
                Clinique clinique = new Clinique();
                clinique.setId(result.getInt("idclinique"));
                clinique.setNom(result.getString("nom"));
                clinique.setCoordonnees(result.getString("coordonnees"));

                listeClinique.add(clinique);
            }
            ConnexionBD.closeConnection();

        } catch (SQLException ex) {
            Logger.getLogger(CliniqueImplDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listeClinique;
    }

    @Override
    public List<ServicesClinique> findAllServicesClinique(String nom) {
        List<ServicesClinique> listeServices = null;
        try {
            // Initilise la requete préparé de la basé sur la connexion
            // la requete SQL passé en argument pour construire l'objet PreparedStatement
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_ALLSERVICES);
            // on execute la requete  et on recupere les resultats dans la requete
            ps.setString(1, nom);
            ResultSet result = ps.executeQuery();

            //initilisation de la listeUtilisateur
            listeServices = new ArrayList();
            while (result.next()) {
                ServicesClinique services = new ServicesClinique();
                services.setId(result.getInt("idservice"));
                services.setNom(result.getString("nom"));
                services.setDescription(result.getString("description"));

                listeServices.add(services);
            }
            ConnexionBD.closeConnection();

        } catch (SQLException ex) {
            Logger.getLogger(CliniqueImplDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listeServices;
    }

    @Override
    public List<Medecin> findAllMedecinsClinique(String nom) {
        List<Medecin> listeMedecins = null;
        try {
            // Initilise la requete préparé de la basé sur la connexion
            // la requete SQL passé en argument pour construire l'objet PreparedStatement
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_ALLMEDECINS);
            // on execute la requete  et on recupere les resultats dans la requete
            ps.setString(1, nom);
            ResultSet result = ps.executeQuery();

            //initilisation de la listeUtilisateur
            listeMedecins = new ArrayList();
            while (result.next()) {
                Medecin medecin = new Medecin();
                medecin.setNumeroProfessionel(result.getInt("idmedecin"));
                medecin.setNom(result.getString("nom"));
                medecin.setPrenom(result.getString("prenom"));
                medecin.setSpecialite(result.getString("specialite"));
                medecin.setFacturation(result.getFloat("facturation"));
                medecin.setMotDePasse(result.getString("password"));


                listeMedecins.add(medecin);
            }
            ConnexionBD.closeConnection();

        } catch (SQLException ex) {
            Logger.getLogger(CliniqueImplDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listeMedecins;
    }

    @Override
    public List<Patient> findAllPatientsClinique(String nom) {
        List<Patient> listePatients = null;
        try {
            // Initilise la requete préparé de la basé sur la connexion
            // la requete SQL passé en argument pour construire l'objet PreparedStatement
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_ALLPATIENTS);
            // on execute la requete  et on recupere les resultats dans la requete
            ps.setString(1, nom);
            ResultSet result = ps.executeQuery();

            //initilisation de la listeUtilisateur
            listePatients = new ArrayList();
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
                listePatients.add(patient);
            }
            ConnexionBD.closeConnection();

        } catch (SQLException ex) {
            Logger.getLogger(CliniqueImplDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listePatients;
    }

    @Override
    public boolean create(Clinique clinique) {
        boolean retour = false;
        int nbLigne = 0;
        Connection conn = null;

        try {
            // obtenir la connexion à la bd
            conn = ConnexionBD.getConnection();
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_INSERT_CLINIQUE);
            conn.setAutoCommit(false);
            ps.setInt(1, clinique.getId());
            ps.setString(2, clinique.getNom());
            ps.setString(3, clinique.getCoordonnees());
      
            
            nbLigne = ps.executeUpdate();

            // enregistre les changements en base de données
            conn.commit();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            // Si une erreur se produit, annuler les changements en effectuant un rollback
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

            Logger.getLogger(CliniqueImplDao.class.getName()).log(Level.SEVERE, null, e);
        }
//		System.out.println("nb ligne " + nbLigne);
        if (nbLigne > 0) {
            retour = true;
        }
        ConnexionBD.closeConnection();
        return retour;
    }

    @Override
    public boolean update(Clinique clinique,int idFindClinique) {
        boolean retour = false;
        int nbLigne = 0;
        PreparedStatement ps;

        try {

            ps = ConnexionBD.getConnection().prepareStatement(SQL_UPDATE_CLINIQUE);

            ps.setInt(1, clinique.getId());
            ps.setString(2, clinique.getNom());
            ps.setString(3, clinique.getCoordonnees());
            ps.setInt(4, idFindClinique);

            nbLigne = ps.executeUpdate();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            Logger.getLogger(CliniqueImplDao.class.getName()).log(Level.SEVERE, null, e);
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
        PreparedStatement ps1;
        try {
            // Désactiver les contraintes de clé étrangère
            ps1 = ConnexionBD.getConnection().prepareStatement(SQL_DELETE_ID_CLINIQUE_DES_MEDECINS);
            ps1.setInt(1, id);
            ps1.executeUpdate();
            ps = ConnexionBD.getConnection().prepareStatement(SQL_DELETE_CLINIQUE);
            ps.setInt(1, id);

            nbLigne = ps.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            Logger.getLogger(CliniqueImplDao.class.getName()).log(Level.SEVERE, null, e);
        }

        if (nbLigne > 0) {
            retour = true;
        }
        ConnexionBD.closeConnection();
        return retour;
    }
    @Override
    public int findMaxIdClinique() {
        Integer idMaximal = null;
        try {

            // Initilise la requete préparé de la basé sur la connexion
            // la requete SQL passé en argument pour construire l'objet PreparedStatement
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_MAX_ID_CLINIQUE);
            // on initialise la propriete nom du l'ulisateur avec sa premiere valeur

            // on execute la requete  et on recupere les resultats dans la requete
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                idMaximal = result.getInt("max(idclinique)");
            }
              
            ConnexionBD.closeConnection();

        } catch (SQLException ex) {
            Logger.getLogger(CliniqueImplDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return idMaximal;
    }
    



}
