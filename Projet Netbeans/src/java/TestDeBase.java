
import com.medic.singleton.ConnexionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
       
        //testCreate_Utilisateur_String();
        //testFindAll();
        //testCreate_Utilisateur();
        //testFindByName();
        //testFindAllRole();
        //testFindByEmail();
        //testExistsByEmailAndPassword();
        //testFindAllByNameRole();
        System.out.println("tset");
        PreparedStatement ps = ConnexionBD.getConnection().prepareStatement("select* from test");
        ResultSet result = ps.executeQuery();
        while (result.next()) {
                System.out.println(result);
            }
            ConnexionBD.closeConnection();
        
    }
}
