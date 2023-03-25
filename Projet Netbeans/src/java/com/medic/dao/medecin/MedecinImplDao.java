package com.medic.dao.medecin;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.medic.dao.clinique.CliniqueImplDao;
import com.medic.entities.Clinique;
import com.medic.entities.Medecin;
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
public class MedecinImplDao implements MedecinDao {

    private static final String SQL_SELECT_MEDECIN = "select * from medecin";
    private static final String SQL_INSERT_MEDECIN = "insert into medecin(idmedecin,nom,prenom,specialite,facturation,password,coordonnees_medecin,clinique_idclinique) value(?,?,?,?,?,?,?,?)";
    private static final String SQL_SELECT_BY_ID_MEDECIN = "select * from medecin where idmedecin =?";
    private static final String SQL_SELECT_MEDECIN_PAR_NOM = "select * from medecin where nom = ?";
    private static final String SQL_SELECT_MEDECIN_PAR_PRENOM = "select * from medecin where prenom = ?";
    private static final String SQL_UPDATE_MEDECIN = "update medecin set nom =?,prenom = ?, specialite =?, facturation=?, password=?,coordonnees_medecin=?,clinique_idclinique=?,idmedecin=? where idmedecin= ?";
    private static final String SQL_DELETE_MEDECIN_PAR_ID = "delete from medecin where idmedecin = ?";
    private static final String SQL_CONNEXION_MEDECIN_NUMERO_PASSWORD = "SELECT * from medecin where idmedecin = ? and password =?";
    private static final String SQL_SELECT_BY_SPECIALITE = "SELECT * from medecin where specialite = ?";
    private static final String SQL_SELECT_BY_PRIX = "SELECT * from medecin where facturation = ?";
    private static final String SQL_SELECT_BY_COORDONNEES = "SELECT * from medecin where coordonnees_medecin = ?";
    private static final String SQL_SELECT_BY_CLINIQUE = "SELECT * from medecin where clinique_idclinique = ?";
    private static final String SQL_SELECT_MAX_ID_MEDECIN = "SELECT max(idmedecin) FROM medecin";

    @Override //Bug avec Le champ mot de passe ne s'insère dans la BD
    public List<Medecin> findAll() {
        List<Medecin> listeMedecin = null;
        try {

            //Initialise la requête préparée basée sur la connexion
            // la requête SQL passé en argument pour construire l'objet preparedStatement
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_MEDECIN);
            System.out.println(" result : " + ps.toString());
            //On execute la requête et on récupère les résultats dans la requête 
            // dans ResultSet
            ResultSet result = ps.executeQuery();

            listeMedecin = new ArrayList<>();
            //// la méthode next() pour se déplacer sur l'enregistrement suivant
            //on parcours ligne par ligne les résultas retournés
            while (result.next()) {
                Medecin medecin = new Medecin();

                medecin.setNumeroProfessionel(result.getInt("idmedecin"));
                medecin.setNom(result.getString("nom"));
                medecin.setPrenom(result.getString("prenom"));
                medecin.setSpecialite(result.getString("specialite"));
                medecin.setFacturation(result.getFloat("facturation"));
                medecin.setMotDePasse(result.getString("password"));
                medecin.setCoordonnees(result.getString("coordonnees_medecin"));
                medecin.setIdCliniqueEmploi(result.getString("clinique_idclinique"));
                listeMedecin.add(medecin);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MedecinImplDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Fermeture de toutes les ressources ouvertes
        ConnexionBD.closeConnection();
        return listeMedecin;
    }

    @Override
    public Medecin findByIdMedecin(int id) {
        Medecin medecin = null;
        try {

            // Initilise la requete préparé de la basé sur la connexion
            // la requete SQL passé en argument pour construire l'objet PreparedStatement
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_BY_ID_MEDECIN);
            // on initialise la propriete nom du l'ulisateur avec sa premiere valeur
            ps.setInt(1, id);

            // on execute la requete  et on recupere les resultats dans la requete
            ResultSet result = ps.executeQuery();

            //initilisation de la listeUtilisateur
            while (result.next()) {
                medecin = new Medecin();
                medecin.setNumeroProfessionel(result.getInt("idmedecin"));
                medecin.setNom(result.getString("nom"));
                medecin.setPrenom(result.getString("prenom"));
                medecin.setSpecialite(result.getString("specialite"));
                medecin.setFacturation(result.getFloat("facturation"));
                medecin.setMotDePasse(result.getString("password"));
                medecin.setCoordonnees(result.getString("coordonnees_medecin"));
                medecin.setIdCliniqueEmploi(result.getString("clinique_idclinique"));
                

            }
            ConnexionBD.closeConnection();

        } catch (SQLException ex) {
            Logger.getLogger(MedecinImplDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return medecin;

    }

    @Override
    public List<Medecin> findByName(String nom) {
        List<Medecin> listeMedecin = null;
        try {

            //Initialise la requête préparée basée sur la connexion
            // la requête SQL passé en argument pour construire l'objet preparedStatement
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_MEDECIN_PAR_NOM);
            // on initialise la propriété nom du bean avec sa premiere valeur
            ps.setString(1, nom);
            //On execute la requête et on récupère les résultats dans la requête 
            // dans ResultSet
            ResultSet result = ps.executeQuery();

            //// la méthode next() pour se déplacer sur l'enregistrement suivant
            //on parcours ligne par ligne les résultas retournés
            listeMedecin = new ArrayList<>();
            while (result.next()) {
                Medecin medecin = new Medecin();
                medecin.setNumeroProfessionel(result.getInt("idmedecin"));
                medecin.setNom(result.getString("nom"));
                medecin.setPrenom(result.getString("prenom"));
                medecin.setSpecialite(result.getString("specialite"));
                medecin.setFacturation(result.getFloat("facturation"));
                medecin.setMotDePasse(result.getString("password"));
                medecin.setCoordonnees(result.getString("coordonnees_medecin"));
                medecin.setIdCliniqueEmploi(result.getString("clinique_idclinique"));
                listeMedecin.add(medecin);

            }
        } catch (SQLException ex) {
            Logger.getLogger(MedecinImplDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Fermeture de toutes les ressources ouvertes
        ConnexionBD.closeConnection();
        return listeMedecin;
    }

    @Override
    public List<Medecin> findByFirstName(String prenom) {
        List<Medecin> listeMedecin = null;
        try {

            //Initialise la requête préparée basée sur la connexion
            // la requête SQL passé en argument pour construire l'objet preparedStatement
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_MEDECIN_PAR_PRENOM);
            // on initialise la propriété nom du bean avec sa premiere valeur
            ps.setString(1, prenom);
            //On execute la requête et on récupère les résultats dans la requête 
            // dans ResultSet
            ResultSet result = ps.executeQuery();

            //// la méthode next() pour se déplacer sur l'enregistrement suivant
            //on parcours ligne par ligne les résultas retournés
            listeMedecin = new ArrayList<>();
            while (result.next()) {
                Medecin medecin = new Medecin();
                medecin.setNumeroProfessionel(result.getInt("idmedecin"));
                medecin.setNom(result.getString("nom"));
                medecin.setPrenom(result.getString("prenom"));
                medecin.setSpecialite(result.getString("specialite"));
                medecin.setFacturation(result.getFloat("facturation"));
                medecin.setMotDePasse(result.getString("password"));
                medecin.setCoordonnees(result.getString("coordonnees_medecin"));
                medecin.setIdCliniqueEmploi(result.getString("clinique_idclinique"));
                listeMedecin.add(medecin);

            }
        } catch (SQLException ex) {
            Logger.getLogger(MedecinImplDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Fermeture de toutes les ressources ouvertes
        ConnexionBD.closeConnection();
        return listeMedecin;
    }

    @Override
    public List<Medecin> findBySpecialite(String specialite) {
        List<Medecin> listeMedecin = null;
        try {

            // Initilise la requete préparé de la basé sur la connexion
            // la requete SQL passé en argument pour construire l'objet PreparedStatement
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_BY_SPECIALITE);
            // on initialise la propriete nom du l'ulisateur avec sa premiere valeur
            ps.setString(1, specialite);

            // on execute la requete  et on recupere les resultats dans la requete
            ResultSet result = ps.executeQuery();
            listeMedecin = new ArrayList<>();
            //initilisation de la listeUtilisateur
            while (result.next()) {
                Medecin medecin = new Medecin();

                medecin.setNumeroProfessionel(result.getInt("idmedecin"));
                medecin.setNom(result.getString("nom"));
                medecin.setPrenom(result.getString("prenom"));
                medecin.setSpecialite(result.getString("specialite"));
                medecin.setFacturation(result.getFloat("facturation"));
                medecin.setMotDePasse(result.getString("password"));
                medecin.setCoordonnees(result.getString("coordonnees_medecin"));
                medecin.setIdCliniqueEmploi(result.getString("clinique_idclinique"));
                listeMedecin.add(medecin);
            }
            ConnexionBD.closeConnection();

        } catch (SQLException ex) {
            Logger.getLogger(MedecinImplDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listeMedecin;
    }

    @Override
    public List<Medecin> findByPrix(float prix) {
        List<Medecin> listeMedecin = null;
        try {

            // Initilise la requete préparé de la basé sur la connexion
            // la requete SQL passé en argument pour construire l'objet PreparedStatement
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_BY_PRIX);
            // on initialise la propriete nom du l'ulisateur avec sa premiere valeur
            ps.setFloat(1, prix);

            // on execute la requete  et on recupere les resultats dans la requete
            ResultSet result = ps.executeQuery();
            listeMedecin = new ArrayList<>();
            //initilisation de la listeUtilisateur
            while (result.next()) {
                Medecin medecin = new Medecin();

                medecin.setNumeroProfessionel(result.getInt("idmedecin"));
                medecin.setNom(result.getString("nom"));
                medecin.setPrenom(result.getString("prenom"));
                medecin.setSpecialite(result.getString("specialite"));
                medecin.setFacturation(result.getFloat("facturation"));
                medecin.setMotDePasse(result.getString("password"));
                medecin.setCoordonnees(result.getString("coordonnees_medecin"));
                medecin.setIdCliniqueEmploi(result.getString("clinique_idclinique"));
                listeMedecin.add(medecin);
            }
            ConnexionBD.closeConnection();

        } catch (SQLException ex) {
            Logger.getLogger(MedecinImplDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listeMedecin;
    }

    @Override
    public List<Medecin> findByCoordonnees(String coordonnees) {
        List<Medecin> listeMedecin = null;
        try {

            //Initialise la requête préparée basée sur la connexion
            // la requête SQL passé en argument pour construire l'objet preparedStatement
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_BY_COORDONNEES);
            // on initialise la propriété nom du bean avec sa premiere valeur
            ps.setString(1, coordonnees);
            //On execute la requête et on récupère les résultats dans la requête 
            // dans ResultSet
            ResultSet result = ps.executeQuery();

            //// la méthode next() pour se déplacer sur l'enregistrement suivant
            //on parcours ligne par ligne les résultas retournés
            listeMedecin = new ArrayList<>();
            while (result.next()) {
                Medecin medecin = new Medecin();
                medecin.setNumeroProfessionel(result.getInt("idmedecin"));
                medecin.setNom(result.getString("nom"));
                medecin.setPrenom(result.getString("prenom"));
                medecin.setSpecialite(result.getString("specialite"));
                medecin.setFacturation(result.getFloat("facturation"));
                medecin.setMotDePasse(result.getString("password"));
                medecin.setCoordonnees(result.getString("coordonnees_medecin"));
                medecin.setIdCliniqueEmploi(result.getString("clinique_idclinique"));
                listeMedecin.add(medecin);

            }
        } catch (SQLException ex) {
            Logger.getLogger(MedecinImplDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Fermeture de toutes les ressources ouvertes
        ConnexionBD.closeConnection();
        return listeMedecin;
    }

    @Override
    public List<Medecin> findByClinique(int idClinique) {
        List<Medecin> listeMedecin = null;
        try {

            // Initilise la requete préparé de la basé sur la connexion
            // la requete SQL passé en argument pour construire l'objet PreparedStatement
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_BY_CLINIQUE);
            // on initialise la propriete nom du l'ulisateur avec sa premiere valeur
            ps.setInt(1, idClinique);

            // on execute la requete  et on recupere les resultats dans la requete
            ResultSet result = ps.executeQuery();
            listeMedecin = new ArrayList<>();
            //initilisation de la listeUtilisateur
            while (result.next()) {
                Medecin medecin = new Medecin();

                medecin.setNumeroProfessionel(result.getInt("idmedecin"));
                medecin.setNom(result.getString("nom"));
                medecin.setPrenom(result.getString("prenom"));
                medecin.setSpecialite(result.getString("specialite"));
                medecin.setFacturation(result.getFloat("facturation"));
                medecin.setMotDePasse(result.getString("password"));
                medecin.setCoordonnees(result.getString("coordonnees_medecin"));
                medecin.setIdCliniqueEmploi(result.getString("clinique_idclinique"));
                listeMedecin.add(medecin);
            }
            ConnexionBD.closeConnection();

        } catch (SQLException ex) {
            Logger.getLogger(MedecinImplDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listeMedecin;
    }

    @Override
    public boolean create(Medecin medecin, int idClinique) {
        boolean retour = false;
        Clinique clinique = null;
        int nbLigne = 0;

        Connection conn = null;
        CliniqueImplDao cliniqueDao = new CliniqueImplDao();

        try {
            clinique = cliniqueDao.findById(idClinique);
            // obtenir la connexion à la bd
            conn = ConnexionBD.getConnection();
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_INSERT_MEDECIN);
            conn.setAutoCommit(false);
            ps.setInt(1, medecin.getNumeroProfessionel());
            ps.setString(2, medecin.getNom());
            ps.setString(3, medecin.getPrenom());
            ps.setString(4, medecin.getSpecialite());
            ps.setFloat(5, medecin.getFacturation());
            ps.setString(6, medecin.getMotDePasse());
            ps.setString(7, medecin.getCoordonnees());
            ps.setInt(8, clinique.getId());

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
    public boolean update(Medecin medecin, int idClinique, int idFindMedecin) {
        boolean retour = false;
        int nbLigne = 0;
        PreparedStatement ps;

        try {

            ps = ConnexionBD.getConnection().prepareStatement(SQL_UPDATE_MEDECIN);

            ps.setString(1, medecin.getNom());
            ps.setString(2, medecin.getPrenom());
            ps.setString(3, medecin.getSpecialite());
            ps.setFloat(4, medecin.getFacturation());
            ps.setString(5, medecin.getMotDePasse());
            ps.setString(6, medecin.getCoordonnees());
            ps.setInt(7, idClinique);
            ps.setInt(8, medecin.getNumeroProfessionel());
            ps.setInt(9, idFindMedecin);

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
    public boolean delete(int id) {
        boolean retour = false;
        int nbLigne = 0;
        PreparedStatement ps;
        try {
            // Désactiver les contraintes de clé étrangère
            ps = ConnexionBD.getConnection().prepareStatement(SQL_DELETE_MEDECIN_PAR_ID);
            ps.setInt(1, id);

            nbLigne = ps.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            Logger.getLogger(MedecinImplDao.class.getName()).log(Level.SEVERE, null, e);
        }

        if (nbLigne > 0) {
            retour = true;
        }
        ConnexionBD.closeConnection();
        return retour;
    }

    @Override
    public Medecin existByNumeroMotPasse(String numero, String motPasse) {
        Medecin medecin = null;
        try {

            //Initialise la requête préparée basée sur la connexion
            // la requête SQL passé en argument pour construire l'objet preparedStatement
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_CONNEXION_MEDECIN_NUMERO_PASSWORD);
            // on initialise la propriété email du bean avec sa premiere valeur
            ps.setString(1, numero);
            ps.setString(2, motPasse);
            //On execute la requête et on récupère les résultats dans la requête 
            // dans ResultSet
            ResultSet result = ps.executeQuery();

            //// la méthode next() pour se déplacer sur l'enregistrement suivant
            //on parcours ligne par ligne les résultas retournés
            while (result.next()) {
                medecin = new Medecin();
                medecin.setNumeroProfessionel(result.getInt("idmedecin"));
                medecin.setNom(result.getString("nom"));
                medecin.setPrenom(result.getString("prenom"));
                medecin.setSpecialite(result.getString("specialite"));
                medecin.setFacturation(result.getFloat("facturation"));
                medecin.setMotDePasse(result.getString("password"));
                medecin.setCoordonnees(result.getString("coordonnees_medecin"));
                medecin.setIdCliniqueEmploi(result.getString("clinique_idclinique"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(MedecinImplDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Fermeture de toutes les ressources ouvertes
        ConnexionBD.closeConnection();
        return medecin;
    }

    @Override
    public int findMaxIdMedecin() {
        Integer idMaximal = null;
        try {

            // Initilise la requete préparé de la basé sur la connexion
            // la requete SQL passé en argument pour construire l'objet PreparedStatement
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_MAX_ID_MEDECIN);
            // on initialise la propriete nom du l'ulisateur avec sa premiere valeur

            // on execute la requete  et on recupere les resultats dans la requete
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                idMaximal = result.getInt("max(idmedecin)");
            }
            
            ConnexionBD.closeConnection();

        } catch (SQLException ex) {
            Logger.getLogger(MedecinImplDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return idMaximal;
    }

}
