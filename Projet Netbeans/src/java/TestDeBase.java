
import com.medic.dao.clinique.CliniqueImpDao;
import com.medic.dao.medecin.MedecinImpDao;
import com.medic.entities.Clinique;
import com.medic.entities.Medecin;
import com.medic.entities.Patient;
import com.medic.entities.Services;
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

        cliniqueTestAll();
        //cliniqueTestfindById();
        //cliniqueTestfindByName();
        
        //cliniqueTestfindByCoordonnees();
        //cliniqueTestfindByService();
        //cliniqueTestfindByService();
        //cliniqueTestfindAllMedecins();
        cliniqueTestfindAllPatients();

    }

    //Clinique--------------------------------------------------------------------------
    public static void cliniqueTestAll() {
        System.out.println("findAllClinique");
        CliniqueImpDao instance = new CliniqueImpDao();
        List<Clinique> result = instance.findAll();
        for (Clinique uneClinique : result) {
            System.out.println(uneClinique);
        }

    }
    public static void cliniqueTestfindById() {
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

    public static void cliniqueTestfindByName() {
        System.out.println("findByName");
        Scanner lectureClavier = new Scanner(System.in);
        String nom = "";
        CliniqueImpDao instance = new CliniqueImpDao();
        System.out.println("Entrez le nom de la clinique : ");
        nom = lectureClavier.nextLine();
        Clinique result = instance.findByName(nom);
        System.out.println(result.toString());

    }
    
    public static void cliniqueTestfindByCoordonnees() {
        System.out.println("findByCoordonnees");
        Scanner lectureClavier = new Scanner(System.in);
        String coordonnees = "";
        CliniqueImpDao instance = new CliniqueImpDao();
        System.out.println("Entrez les coordonnees de la clinique : ");
        coordonnees = lectureClavier.nextLine();
        Clinique result = instance.findByCoordonnes(coordonnees);
        System.out.println(result.toString());

    }
    
    public static void cliniqueTestfindByService() {
        List<Clinique> result;
        System.out.println("findByCoordonnees");
        Scanner lectureClavier = new Scanner(System.in);
        String coordonnees = "";
        CliniqueImpDao instance = new CliniqueImpDao();
        System.out.println("Entrez le service voulu : ");
        coordonnees = lectureClavier.nextLine();
        result = instance.findByService(coordonnees);
        for (Clinique uneClinique : result) {
            System.out.println(uneClinique);
        }

    }
    public static void cliniqueTestfindAllService() {
        List<Services> result;
        System.out.println("findByCoordonnees");
        Scanner lectureClavier = new Scanner(System.in);
        String coordonnees = "";
        CliniqueImpDao instance = new CliniqueImpDao();
        System.out.println("Entrez la clinique dont vous voulez connaitre les services : ");
        coordonnees = lectureClavier.nextLine();
        result = instance.findAllServicesClinique(coordonnees);
        for (Services unService : result) {
            System.out.println(unService);
        }
    }
    public static void cliniqueTestfindAllMedecins() {
        List<Medecin> result;
        System.out.println("findAllMedecins");
        Scanner lectureClavier = new Scanner(System.in);
        String nom = "";
        CliniqueImpDao instance = new CliniqueImpDao();
        System.out.println("Entrez la clinique dont vous voulez connaitre les medecins : ");
        nom = lectureClavier.nextLine();
        result = instance.findAllMedecinsClinique(nom);
        for (Medecin unMedecin : result) {
            System.out.println(unMedecin);
        }
    }
    public static void cliniqueTestfindAllPatients() {
        List<Patient> result;
        System.out.println("findAllPatients");
        Scanner lectureClavier = new Scanner(System.in);
        String nom = "";
        CliniqueImpDao instance = new CliniqueImpDao();
        System.out.println("Entrez la clinique dont vous voulez connaitre les patients : ");
        nom = lectureClavier.nextLine();
        result = instance.findAllPatientsClinique(nom);
        for (Patient unPatient : result) {
            System.out.println(unPatient);
        }
    }

    
}
