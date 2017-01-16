/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.insa.docs;
import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;

/**
 *
 * @author laure
 */
public class ConnectToDB {

    public static Connection connect() throws SQLException{
       
            Connection con = null;
            
            String driverName = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/testdatabase";
            String user = "root";
            String password = "salope1";
            boolean rep = false;
             try {
            Class.forName(driverName);
            con = DriverManager.getConnection(url, user, password);

        } catch (ClassNotFoundException ex) {
        }
        return con;
    }
    
}
