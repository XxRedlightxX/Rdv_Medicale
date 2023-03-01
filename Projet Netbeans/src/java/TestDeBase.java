
import com.medic.dao.clinique.CliniqueImpDao;
import com.medic.dao.medecin.MedecinImpDao;
import com.medic.dao.patient.PatientImpDao;
import com.medic.dao.services.ServicesImpDao;
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

        //testfindById();
        //testfindByName();
        //testfindByCoordonnees();
        //-------------------------------
        //testFindAll();
        //testCreate();
        //testFindById();
       //testFindByName();
       //testUpdate();
       //testDelete();
       //-----------------------
       //testFindAllPatient();
       //testfindByIdPatient();
       //testCreatePatient();
       testFindAllServices();
       

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
        
//        System.out.println("Change ID  : ");
//        int idmedecin = lectureClavier.nextInt();
//        medecin.setNumeroProfessionel(idmedecin);
        
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
        
        //medecin = new Medecin(nom, prenom, specialite, facture, password );
        boolean result = instance.update(medecin);
        if (result) {
            System.out.println("L'utilisateur est mis à jour ");
        } else {
            System.out.println("Echec de mis à jour ");
        }
    }    
    
    public static void testDelete() {
            System.out.println("delete");
            int id = 0;
            MedecinImpDao instance = new MedecinImpDao();
           System.out.println("Entrez l'ide l'utilisateur : ");
          Scanner lectureClavier = new Scanner(System.in);
           id = lectureClavier.nextInt();
           boolean result = instance.delete(id);
           if (result) {
               System.out.println("l'utilisateur dont l'id est " + id + " est supprimé de la base des données");
           } else {
              System.out.println("l'utilisateur dont l'id est " + id + " n'existe de la base des données");
           }
       }



    //Patient-----------------------------------------------------------------------------------------------------
     public static void testFindAllPatient() {
        System.out.println("findAll");
        PatientImpDao instance = new PatientImpDao();
        // List<Utilisateur> expResult = null;
        List<Patient> result = instance.findAll();
        // assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //System.out.println(result.get(0).toString());
        for (Patient patient : result) {
            System.out.println(patient.toString());
        }
     }
     
     
      public static void testfindByIdPatient() {
        System.out.println("findById");
        Scanner lectureClavier = new Scanner(System.in);
        String id = "";
        PatientImpDao instance = new PatientImpDao();
        System.out.println("Entrez le Id de la clinique : ");
        id = lectureClavier.next();
        int test;
        test = Integer.parseInt(id);
        Patient result = instance.findByIdPatient(test);
        System.out.println(result.toString());

    }
      
      public static void testCreatePatient() {
        System.out.println("create");
        Patient patient = null;
        PatientImpDao instance = new PatientImpDao();
        Scanner lectureClavier = new Scanner(System.in);
        
        System.out.println("Entrez le ID : ");
        int ID = lectureClavier.nextInt();
        System.out.println("Entrez le nom du patient : ");
        String nom = lectureClavier.next();
        System.out.println("Esdfsdntrez le prenom du medecin");
        String prenom= lectureClavier.next();
        

        System.out.println("Entrez l'assurance du patient  : ");
        String assurance = lectureClavier.next();
        
        System.out.println("Entrez le numeroSeq : ");
        int NumeroSeq = lectureClavier.nextInt();
        
        System.out.println("Entrez la date de naissance du patient :");
        String naissance = lectureClavier.next();
        
        System.out.println("Entrez le genre :");
        String sexe = lectureClavier.next();
        
        System.out.println("Entrez le mot de passe :");
        String password = lectureClavier.next();
        
        patient = new Patient(ID,nom,prenom,assurance,NumeroSeq,naissance,sexe,password);
     
        boolean result = instance.create(patient);
        if (result) {
            System.out.println("insertion reussite");
        } else {
            System.out.println("insertion echec ");
        }
        
        
    }
       //Services--------------------------------------------------------------------------
    public static void testFindAllServices() {
        System.out.println("findAllServices");
        ServicesImpDao instance = new ServicesImpDao();
        // List<Utilisateur> expResult = null;
        List<Services> result = instance.findAll();
        // assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //System.out.println(result.get(0).toString());
        for (Services unService : result) {
            System.out.println(unService.toString());
        }
    
    }
    
    
    public static void testCreateServices() {
        System.out.println("createService");
        Services service = null;
        ServicesImpDao instance = new ServicesImpDao();
        Scanner lectureClavier = new Scanner(System.in);
        System.out.println("Entrez nom service ");
        String nom = lectureClavier.next();
        System.out.println("Entrez la description du service");
        String description= lectureClavier.next();
        System.out.println("Entrez le ID du service");
        String id= lectureClavier.next();
        int test;
        test = Integer.parseInt(id);
        
        service = new Services(test,nom,description);
     
        boolean result = instance.ajouterService(service);
        if (result) {
            System.out.println("insertion reussite");
        } else {
            System.out.println("insertion echec ");
        }
    }
    
    public static void testFindByIdServices() {
        System.out.println("findByIdService");
        int id = 0;
        ServicesImpDao instance = new ServicesImpDao();
        System.out.println("Entrez l'id du service : ");
        Scanner lectureClavier = new Scanner(System.in);
        id = lectureClavier.nextInt();
        Services result = instance.findById(id);
        System.out.println(result.toString());

    }
    
    
    public static void testFindByNameServices() {
        System.out.println("findByNameServices");
        String nom = "";
        ServicesImpDao instance = new ServicesImpDao();
        System.out.println("Entrez le nom de l'utilisateur : ");
        Scanner lectureClavier = new Scanner(System.in);
        nom = lectureClavier.next();
        Services result = instance.findByName(nom);
        System.out.println(result.toString());

    }
    
    public static void testFindByDescriptionServices() {
        System.out.println("findByDescriptionServices");
        String description = "";
        ServicesImpDao instance = new ServicesImpDao();
        System.out.println("Entrez la description du service : ");
        Scanner lectureClavier = new Scanner(System.in);
        description = lectureClavier.next();
        Services result = instance.findByDescription(description);
        System.out.println(result.toString());

    }
    
    public static void testUpdateServices() {
        System.out.println("update");
        Services service = null;
        ServicesImpDao instance = new ServicesImpDao();
        Scanner lectureClavier = new Scanner(System.in);
        System.out.println("Entrez l'ide du service à mettre à jour : ");
        int id = lectureClavier.nextInt();
        service = instance.findById(id);
        
//        System.out.println("Change ID  : ");
//        int idmedecin = lectureClavier.nextInt();
//        medecin.setNumeroProfessionel(idmedecin);
        
        System.out.println("Entrez le nom : ");
        String nom = lectureClavier.next();
        service.setNom(nom);
        
        System.out.println("Entrez la description : ");
        String description = lectureClavier.next();
        service.setDescription(description);
        
     
        
        //medecin = new Medecin(nom, prenom, specialite, facture, password );
        boolean result = instance.update(service);
        if (result) {
            System.out.println("L'utilisateur est mis à jour ");
        } else {
            System.out.println("Echec de mis à jour ");
        }
    }    
    
    public static void testDeleteServices() {
            System.out.println("deleteServices");
            int id = 0;
            ServicesImpDao instance = new ServicesImpDao();
           System.out.println("Entrez l'id du service : ");
          Scanner lectureClavier = new Scanner(System.in);
           id = lectureClavier.nextInt();
           boolean result = instance.delete(id);
           if (result) {
               System.out.println("le service dont l'id est " + id + " est supprimé de la base des données");
           } else {
              System.out.println("le service dont l'id est " + id + " n'existe de la base des données");
           }
       }
      
      
     
     
     
     
     
     
     
    
    
    
    
    }
    
    
    
    
    
    
 
    
    
    

