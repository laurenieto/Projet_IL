/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package univ.list.fr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lilian
 */
public class testrequete {

        public static ResultSet envoi_requete (String requete){
            Connection con= null;
            PreparedStatement ps = null;
            ResultSet rs = null;
         //   String retour = null;
         //   List<String> liste_results = new ArrayList<String>();

            String driverName = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/testdatabase";
            String user = "root";
            String password = "salope1";
            boolean rep = false;

            try {

                String sql_str = requete;
                Class.forName(driverName);
                con = DriverManager.getConnection(url, user, password);
                ps = con.prepareStatement(sql_str);
                rs = ps.executeQuery();

            }

            catch (Exception ex) {System.out.print(ex);}


            return rs ;

          }


}