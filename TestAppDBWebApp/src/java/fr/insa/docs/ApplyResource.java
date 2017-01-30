/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.insa.docs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;


/**
 * REST Web Service
 *
 * @author
 * Put: This service allow to a student to apply to an university givin the id of both.
 *
 * Get: give the id of the student giving the username and the password, if it is in database.
 * This allows to hide the username and the password from the URL.
 *
 */

@Path("apply")
public class ApplyResource {
    @Context
    private UriInfo context;

    /** Creates a new instance of ApplyResource */
    public ApplyResource() {
    }

    /**
     * Retrieves representation of an instance of fr.insa.docs.ApplyResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("text/plain")
    /*public String getXml() {
        //TODO return proper representation object

        throw new UnsupportedOperationException();
    }
*/
    public String getUserID(@QueryParam("username") String username,@QueryParam("password") String password){
        PreparedStatement ps = null;
        ResultSet rs = null;
        int res=-1;
        try {
            String sql_str = "SELECT s.id_student FROM student s WHERE s.username='"+username+ "' and s.password='"+password+"'";
           
            Connection con = ConnectToDB.connect();
         
            ps = con.prepareStatement(sql_str);
          
            rs = ps.executeQuery();
            while (rs.next()){
               
                res = rs.getInt("id_student");
            }
        

        } catch (SQLException ex) {
            Logger.getLogger(ApplyResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        return String.valueOf(res);
    }

    /**
     * PUT method for updating or creating an instance of ApplyResource
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/xml")
    public String insertAppliance(@QueryParam("id_student") String id_student, @QueryParam("id_univ") String id_univ) {
        PreparedStatement ps = null;
  
        try {
            int id_st_int = Integer.parseInt(id_student);
            int id_univ_int = Integer.parseInt(id_univ);
            String sql_str = "INSERT INTO student_university (student_id, university_id) VALUES ("+id_st_int+ ", "+id_univ_int+")";

            Connection con = ConnectToDB.connect();
            ps = con.prepareStatement(sql_str);

            ps.executeUpdate();
            return String.valueOf(id_st_int);
        } catch (SQLException ex) {
            Logger.getLogger(ApplyResource.class.getName()).log(Level.SEVERE, null, ex);
            return ex.toString();
        }
    
    }
}
