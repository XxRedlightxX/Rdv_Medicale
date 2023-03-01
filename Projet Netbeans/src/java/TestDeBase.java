
import com.medic.dao.clinique.CliniqueImpDao;
import com.medic.dao.medecin.MedecinImpDao;
import com.medic.entities.Clinique;
import com.medic.entities.Medecin;
import com.medic.entities.Patient;
import com.medic.singleton.ConnexionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author 1482910
 */
public class TestDeBase {

    public static void main(String[] args) throws SQLException {

        //testfindById();
        //testfindByName();
        //testfindByCoordonnees();
        //-------------------------------
        //testFindAll();
        //testCreate();
        //testFindById();
       //testFindByName();
       testUpdate();

    }

    public static void testfindById() {
        System.out.println("findById");
        Scanner lectureClavier = new Scanner(System.in);
        String id = "";
        CliniqueImpDao instance = new CliniqueImpDao();
        System.out.println("Entrez le Id de la clinique : ");
        id = lectureClavier.next();
        int test;
        test = Integer.parseInt(id);
        Clinique result = instance.findById(test);
        System.out.println(result.toString());

    }

    public static void testfindByName() {
        System.out.println("findByName");
        Scanner lectureClavier = new Scanner(System.in);
        String nom = "";
        CliniqueImpDao instance = new CliniqueImpDao();
        System.out.println("Entrez le nom de la clinique : ");
        nom = lectureClavier.nextLine();
        Clinique result = instance.findByName(nom);
        System.out.println(result.toString());

    }
    
    public static void testfindByCoordonnees() {
        System.out.println("findByName");
        Scanner lectureClavier = new Scanner(System.in);
        String coordonnees = "";
        CliniqueImpDao instance = new CliniqueImpDao();
        System.out.println("Entrez les coordonnees de la clinique : ");
        coordonnees = lectureClavier.nextLine();
        Clinique result = instance.findByCoordonnes(coordonnees);
        System.out.println(result.toString());

    }
    
    
    //Medecin--------------------------------------------------------------------------
    public static void testFindAll() {
        System.out.println("findAll");
        MedecinImpDao instance = new MedecinImpDao();
        // List<Utilisateur> expResult = null;
        List<Medecin> result = instance.findAll();
        // assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //System.out.println(result.get(0).toString());
        for (Medecin medecin : result) {
            System.out.println(medecin.toString());
        }
    
    }
    
    
    public static void testCreate() {
        System.out.println("create");
        Medecin medecin = null;
        MedecinImpDao instance = new MedecinImpDao();
        Scanner lectureClavier = new Scanner(System.in);
        System.out.println("Entrez nom medecin ");
        String nom = lectureClavier.next();
        System.out.println("Entrez le prenom du medecin");
        String prenom= lectureClavier.next();
        

        System.out.println("Entrez la specialite : ");
        String specialite = lectureClavier.next();
        System.out.println("Entrez la facturation : ");
        float facturation = lectureClavier.nextFloat();
        System.out.println("Entrez le mot de passe :");
        String password = lectureClavier.next();
        
        medecin = new Medecin(  nom,  prenom,  specialite, facturation,password);
     
        boolean result = instance.create(medecin);
        if (result) {
            System.out.println("insertion reussite");
        } else {
            System.out.println("insertion echec ");
        }
    }
    
    public static void testFindById() {
        System.out.println("findById");
        int id = 0;
        MedecinImpDao instance = new MedecinImpDao();
        System.out.println("Entrez l'id du medecin : ");
        Scanner lectureClavier = new Scanner(System.in);
        id = lectureClavier.nextInt();
        Medecin result = instance.findById(id);
        System.out.println(result.toString());

    }
    
    
    public static void testFindByName() {
        System.out.println("findByName");
        String nom = "";
        MedecinImpDao instance = new MedecinImpDao();
        System.out.println("Entrez le nom de l'utilisateur : ");
        Scanner lectureClavier = new Scanner(System.in);
        nom = lectureClavier.next();
        Medecin result = instance.findByName(nom);
        System.out.println(result.toString());

    }
    
    public static void testUpdate() {
        System.out.println("update");
        Medecin medecin = null;
        MedecinImpDao instance = new MedecinImpDao();
        Scanner lectureClavier = new Scanner(System.in);
        System.out.println("Entrez l'ide du medecin à mettre à jour : ");
        int id = lectureClavier.nextInt();
        medecin = instance.findById(id);
        
        System.out.println("Change ID  : ");
        int idmedecin = lectureClavier.nextInt();
        medecin.setNumeroProfessionel(idmedecin);
        
        System.out.println("Entrez le nom : ");
        String nom = lectureClavier.next();
        medecin.setNom(nom);
        
        System.out.println("Entrez le prenom : ");
        String prenom = lectureClavier.next();
        medecin.setPrenom(prenom);
        
        System.out.println("Entrez la specialite de l'utilisateur :");
        String specialite = lectureClavier.next();
        medecin.setSpecialite(specialite);
        
        System.out.println("Entrez sa facture  :");
        float facture = lectureClavier.nextFloat();
        medecin.setFacturation(facture);

        System.out.println("Entrez son mot de passe :");
        String password = lectureClavier.next();
        medecin.setMotDePasse(password);
        
        // utilisateur = new Utilisateur(email, active, nom, prenom, password, photo);
        boolean result = instance.update(medecin);
        if (result) {
            System.out.println("L'utilisateur est mis à jour ");
        } else {
            System.out.println("Echec de mis à jour ");
        }

    }
    
    
    
    
    
    
    
}
