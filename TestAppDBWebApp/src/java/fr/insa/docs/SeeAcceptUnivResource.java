/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.insa.docs;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
 * @author laure
 */

@Path("seeAcceptUniv")
public class SeeAcceptUnivResource {
    @Context
    private UriInfo context;

    /** Creates a new instance of SeeAcceptUnivResource */
    public SeeAcceptUnivResource() {
    }

    /**
     * Retrieves representation of an instance of fr.insa.docs.SeeAcceptUnivResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("text/plain")
    public String getXml(@QueryParam("id_student") String id_student) {
        //TODO return proper representation object
        PreparedStatement ps = null;
        ResultSet rs = null;
        String res="";
        int id_st = Integer.parseInt(id_student);
        try {
          
            String sql_str = "SELECT s.university_id, univ.univName, univ.city, univ.country FROM student_university s, university univ  WHERE s.univResponse=1 and s.university_id = univ.id_university and s.student_id='"+id_st+"'";

            Connection con = ConnectToDB.connect();
         
            ps = con.prepareStatement(sql_str);

            rs = ps.executeQuery();
            while (rs.next()){
                res = rs.getString("univName")+ " in " + rs.getString("country")+", "+rs.getString("city");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ApplyResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    /**
     * PUT method for updating or creating an instance of SeeAcceptUnivResource
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/xml")
    public void putXml(String content) {
    }
}
