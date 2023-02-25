
import com.medic.dao.clinique.CliniqueImpDao;
import com.medic.entities.Clinique;
import com.medic.singleton.ConnexionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
        testfindByCoordonnees();

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
}
