/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.insa.docs;

import univ.list.fr.testrequete;
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
 * this allow to list the information of the students who applied to an university,
 * giving the id of the university. 
 *
 */

@Path("ListStudentWhoApplied")
public class ListStudentWhoAppliedResource {
    @Context
    private UriInfo context;

    /** Creates a new instance of ListStudentWhoAppliedResource */
    public ListStudentWhoAppliedResource() {
    }

    /**
     * Retrieves representation of an instance of fr.insa.docs.ListStudentWhoAppliedResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("text/plain")
    public String getStudentWhoApplied(@QueryParam("id_univ") String id_univ) {
        //TODO return proper representation object
        ResultSet rs = null;
        String resultat="";
        int size= 0;
        int id_univ_st = Integer.parseInt(id_univ);
        try {

            String sql_str = "SELECT s.id_student, s.username, s.password, s.firstnam, s.surname, s.email, s.telephone, s.yearAtINSA, s.INSAspeciality FROM student_university s_u , student s, university univ  WHERE s_u.university_id = univ.id_university and s.id_student = s_u.student_id and univ.id_university = '"+id_univ_st+"'";

            rs = testrequete.envoi_requete(sql_str);
            while (rs.next()){
                size++ ;
                resultat = resultat+rs.getString("s.id_student")+"="+rs.getString("s.username")+"="+rs.getString("s.password")+"="+rs.getString("S.firstnam")+"="+rs.getString("s.surname")+"="+rs.getString("s.email")+"="+rs.getString("s.telephone")+"="+rs.getString("s.yearAtINSA")+"="+rs.getString("s.INSAspeciality")+"=";
            }
        } catch (SQLException ex) {
            Logger.getLogger(ApplyResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        return size+"="+resultat;
    }

    /**
     * PUT method for updating or creating an instance of ListStudentWhoAppliedResource
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/xml")
    public void putXml(String content) {
    }
}
