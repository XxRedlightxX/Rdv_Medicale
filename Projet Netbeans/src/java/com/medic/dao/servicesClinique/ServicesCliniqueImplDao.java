/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.medic.dao.servicesClinique;

import com.medic.dao.medecin.MedecinImplDao;
import com.medic.entities.Medecin;
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
 * @author hundl
 */
public class ServicesCliniqueImplDao implements ServicesCliniqueDao {
    private static final String SQL_SELECT_SERVICES= "select * from services";
    private static final String SQL_SELECT_BY_ID_SERVICES = "select * from services where idservice =?";
    private static final String SQL_SELECT_BY_NOM_SERVICES = "select * from services where nom =?";
    private static final String SQL_SELECT_BY_NOM_DESCRIPTION = "select * from services where description =?";
    private static final String SQL_INSERT_SERVICE = "insert into services(idservice,nom,description) value(?,?,?)";
    private static final String SQL_UPDATE_SERVICE = "update services set idservice=?, nom = ?, description =? where idservice= ?";   
    private static final String SQL_DELETE_SERVICES_PAR_ID = "delete from services where idservice = ?";
    
    @Override
    public List<ServicesClinique> findAll() {
        List<ServicesClinique> listeServices = null;
        try {

            //Initialise la requête préparée basée sur la connexion
            // la requête SQL passé en argument pour construire l'objet preparedStatement
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_SERVICES);
               System.out.println(" result : " + ps.toString());
            //On execute la requête et on récupère les résultats dans la requête 
            // dans ResultSet
            ResultSet result = ps.executeQuery();
               
            listeServices = new ArrayList<>();
            //// la méthode next() pour se déplacer sur l'enregistrement suivant
            //on parcours ligne par ligne les résultas retournés
            while (result.next()) {
                ServicesClinique services = new ServicesClinique();
                services.setId(result.getInt("idservice"));
                services.setNom(result.getString("nom"));
                services.setDescription(result.getString("description"));
    
                listeServices.add(services);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MedecinImplDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Fermeture de toutes les ressources ouvertes
        ConnexionBD.closeConnection();
        return listeServices;
    }

    @Override
    public ServicesClinique findById(int id) {
        ServicesClinique service = null;
        try {

            // Initilise la requete préparé de la basé sur la connexion
            // la requete SQL passé en argument pour construire l'objet PreparedStatement
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_BY_ID_SERVICES);
            // on initialise la propriete nom du l'ulisateur avec sa premiere valeur
            ps.setInt(1, id);

            // on execute la requete  et on recupere les resultats dans la requete
            ResultSet result = ps.executeQuery();

            //initilisation de la listeUtilisateur
            while (result.next()) {
                service = new ServicesClinique();
                service.setId(result.getInt("idservice"));
                service.setNom(result.getString("nom"));
                service.setDescription(result.getString("description"));              
            }
            ConnexionBD.closeConnection();

        } catch (SQLException ex) {
            Logger.getLogger(MedecinImplDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return service;
    }

    @Override
    public ServicesClinique findByName(String nom) {
        ServicesClinique service = null;
        try {

            //Initialise la requête préparée basée sur la connexion
            // la requête SQL passé en argument pour construire l'objet preparedStatement
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_BY_NOM_SERVICES);
            // on initialise la propriété nom du bean avec sa premiere valeur
            ps.setString(1, nom);
            //On execute la requête et on récupère les résultats dans la requête 
            // dans ResultSet
            ResultSet result = ps.executeQuery();

            //// la méthode next() pour se déplacer sur l'enregistrement suivant
            //on parcours ligne par ligne les résultas retournés
            while (result.next()) {
                service = new ServicesClinique();
                service.setId(result.getInt("idservice"));
                service.setNom(result.getString("nom"));
                service.setDescription(result.getString("description")); 
               
            }
        } catch (SQLException ex) {
            Logger.getLogger(MedecinImplDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Fermeture de toutes les ressources ouvertes
        ConnexionBD.closeConnection();
        return service;
    }

    @Override
    public ServicesClinique findByDescription(String description) {
        ServicesClinique service = null;
        try {

            //Initialise la requête préparée basée sur la connexion
            // la requête SQL passé en argument pour construire l'objet preparedStatement
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_BY_NOM_DESCRIPTION);
            // on initialise la propriété nom du bean avec sa premiere valeur
            ps.setString(1, description);
            //On execute la requête et on récupère les résultats dans la requête 
            // dans ResultSet
            ResultSet result = ps.executeQuery();

            //// la méthode next() pour se déplacer sur l'enregistrement suivant
            //on parcours ligne par ligne les résultas retournés
            while (result.next()) {
                service = new ServicesClinique();
                service.setId(result.getInt("idservice"));
                service.setNom(result.getString("nom"));
                service.setDescription(result.getString("description")); 
               
            }
        } catch (SQLException ex) {
            Logger.getLogger(MedecinImplDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Fermeture de toutes les ressources ouvertes
        ConnexionBD.closeConnection();
        return service;
    }

    @Override
    public boolean ajouterService(ServicesClinique service) {
        boolean retour = false;
        int nbLigne = 0;
        Connection conn = null;

        try {
            conn = ConnexionBD.getConnection();
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_INSERT_SERVICE);
            //   Insérer les données dans la table parente, utilisateurs
            //ps.setInt(1, medecin.getNumeroProfessionel());
            conn.setAutoCommit(false);
            ps.setInt(1, service.getId());
            ps.setString(2, service.getNom());
            ps.setString(3, service.getDescription());
            nbLigne = ps.executeUpdate();

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

            Logger.getLogger(ServicesCliniqueImplDao.class.getName()).log(Level.SEVERE, null, e);
        }
        if (nbLigne > 0) {
            retour = true;
        }
        ConnexionBD.closeConnection();
        return retour;
    }

    @Override
    public boolean update(ServicesClinique service,int idFindServiceClinique) {
        boolean retour = false;
        int nbLigne = 0;
        PreparedStatement ps;

        try {

            ps = ConnexionBD.getConnection().prepareStatement(SQL_UPDATE_SERVICE);
           
            ps.setInt(1, service.getId());
            ps.setString(2, service.getNom());
            ps.setString(3, service.getDescription());
            ps.setInt(4, idFindServiceClinique);


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
            //ps1 = ConnexionBD.getConnection().prepareStatement(SQL_DESACTIVER_CONTRAINTS);
            //ps1.executeUpdate();
            ps = ConnexionBD.getConnection().prepareStatement(SQL_DELETE_SERVICES_PAR_ID);
            ps.setInt(1, id);

            nbLigne = ps.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            Logger.getLogger(ServicesCliniqueImplDao.class.getName()).log(Level.SEVERE, null, e);
        }

        if (nbLigne > 0) {
            retour = true;
        }
        ConnexionBD.closeConnection();
        return retour;
    }

}
