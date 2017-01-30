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
import javax.ws.rs.QueryParam;;

/**
 * REST Web Service
 *
 * @author
 * This allow to list the informations of a student giving its id.
 */

@Path("listStudent")
public class ListStudentResource {
    @Context
    private UriInfo context;

    /** Creates a new instance of ListStudentResource */
    public ListStudentResource() {
    }

    /**
     * Retrieves representation of an instance of fr.insa.docs.ListStudentResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("text/plain")
    public String getInfoUser(@QueryParam("id_student") String id_student){
        PreparedStatement ps = null;
        ResultSet rs = null;
        int id_student_st = Integer.parseInt(id_student);
        String res="";
        try {
            String sql_str = "SELECT firstnam, surname FROM student WHERE id_student="+id_student_st;

            Connection con = ConnectToDB.connect();

            ps = con.prepareStatement(sql_str);

            rs = ps.executeQuery();

            while (rs.next()){

                res = (res + rs.getString("firstnam")+" " + rs.getString("surname"));
            }


        } catch (SQLException ex) {
            Logger.getLogger(ApplyResource.class.getName()).log(Level.SEVERE, null, ex);
            res = ex.toString();
        }
        return res;
    }
    @PUT
    @Consumes("application/xml")
    public void putXml(String content) {
    }
}
