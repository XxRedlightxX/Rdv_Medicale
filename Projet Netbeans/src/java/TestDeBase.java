
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
        //testFindAll();
        testCreate();

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
    
}
