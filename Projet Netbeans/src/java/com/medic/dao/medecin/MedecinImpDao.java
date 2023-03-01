package com.medic.dao.medecin;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */




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
public class MedecinImpDao implements MedecinDao {

    private static final String SQL_SELECT_MEDECIN = "select * from medecin";
     private static final String SQL_INSERT_MEDECIN = "insert into medecin(nom,prenom,specialite,facturation,password) value(?,?,?,?,?)";
    private static final String SQL_SELECT_BY_ID_MEDECIN = "select * from medecin where idmedecin =?";
    private static final String SQL_SELECT_MEDECIN_PAR_NOM = "select * from medecin where nom = ?";
     private static final String SQL_UPDATE_MEDECIN = "update medecin set idmedecin =?, nom =?,prenom = ?, specialite =?, facturation=?, password=? where idmedecin= ?";
    
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
                
                //medecin.setNumeroProfessionel(result.getInt("idmedecin"));
                medecin.setNom(result.getString("nom"));
                medecin.setPrenom(result.getString("prenom"));
                medecin.setSpecialite(result.getString("specialite"));
                medecin.setFacturation(result.getFloat("facturation"));
                medecin.setMotDePasse(result.getString("password"));
                listeMedecin.add(medecin);
            };
        } catch (SQLException ex) {
            Logger.getLogger(MedecinImpDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Fermeture de toutes les ressources ouvertes
        ConnexionBD.closeConnection();
        return listeMedecin;
    }

    @Override
    public Medecin findById(int id) {
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
                medecin = new Medecin ();
                medecin.setNumeroProfessionel(result.getInt("idmedecin"));
                medecin.setNom(result.getString("nom"));
                medecin.setPrenom(result.getString("prenom"));
                medecin.setSpecialite(result.getString("specialite"));
                medecin.setFacturation(result.getFloat
        ("facturation"));
                 medecin.setMotDePasse(result.getString("password"));
                
                
                
                

            }
            ConnexionBD.closeConnection();

        } catch (SQLException ex) {
            Logger.getLogger(MedecinImpDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return medecin;
        
    }

    @Override
    public Medecin findByName(String nom) {
        Medecin medecin = null;
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
            while (result.next()) {
                medecin = new Medecin();
                medecin.setNumeroProfessionel(result.getInt("idmedecin"));
                medecin.setNom(result.getString("nom"));
                medecin.setPrenom(result.getString("prenom"));
                medecin.setSpecialite(result.getString("specialite"));
                medecin.setFacturation(result.getFloat("facturation"));
                medecin.setMotDePasse(result.getString("password"));
               
            };
        } catch (SQLException ex) {
            Logger.getLogger(MedecinImpDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Fermeture de toutes les ressources ouvertes
        ConnexionBD.closeConnection();
        return medecin;
    }

    @Override
    public Medecin findByFirstName(String prenom) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Medecin findBySpecialite(String specialite) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Medecin findByPrix(float prix) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Medecin findByCoordonnees(String coordonnees) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Medecin findByClinique(String clinique) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean create(Medecin medecin) {
        boolean retour = false;
        int nbLigne = 0;
        PreparedStatement ps;

        try {
            ps = ConnexionBD.getConnection().prepareStatement(SQL_INSERT_MEDECIN);
            //   Insérer les données dans la table parente, utilisateurs
            //ps.setInt(1, medecin.getNumeroProfessionel());
            ps.setString(1, medecin.getNom());
            ps.setString(2, medecin.getPrenom());
            ps.setString(3, medecin.getSpecialite());

            ps.setFloat(4, medecin.getFacturation());
            ps.setString(5, medecin.getMotDePasse());
            nbLigne = ps.executeUpdate();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            Logger.getLogger(MedecinImpDao.class.getName()).log(Level.SEVERE, null, e);
        }

//		System.out.println("nb ligne " + nbLigne);
        if (nbLigne > 0) {
            retour = true;
        }
        ConnexionBD.closeConnection();
        return retour;
    }

    @Override
    public boolean update(Medecin medecin) {
         boolean retour = false;
        int nbLigne = 0;
        PreparedStatement ps;

        try {

            ps = ConnexionBD.getConnection().prepareStatement(SQL_UPDATE_MEDECIN);
            ps.setInt(1, medecin.getNumeroProfessionel());
            ps.setString(2, medecin.getNom());
            ps.setString(3, medecin.getPrenom());
            ps.setString(4, medecin.getSpecialite());
            ps.setFloat(5, medecin.getFacturation());
            ps.setString(6, medecin.getMotDePasse());

            nbLigne = ps.executeUpdate();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            Logger.getLogger(MedecinImpDao.class.getName()).log(Level.SEVERE, null, e);
        }

//		System.out.println("nb ligne " + nbLigne);
        if (nbLigne > 0) {
            retour = true;
        }
        ConnexionBD.closeConnection();
        return retour;
    }
    
    
    
   




}
