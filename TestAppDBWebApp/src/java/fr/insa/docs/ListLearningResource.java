/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.insa.docs;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import univ.list.fr.testrequete;
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
 * This service allows to list the learning of a student for an university,
 * giving the id of both.
 */

@Path("listLearning")
public class ListLearningResource {
    @Context
    private UriInfo context;

    /** Creates a new instance of ListLearningResource */
    public ListLearningResource() {
    }

    /**
     * Retrieves representation of an instance of fr.insa.docs.ListLearningResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("text/plain")
    public String getLearning(@QueryParam("id_univ") String id_univ, @QueryParam("id_student") String id_student) throws SQLException {
       int size= 0;
   
       ResultSet rs = null;
       String resultat = "";
       int id_univ_int = Integer.parseInt(id_univ);
       int id_student_int = Integer.parseInt(id_student);
       rs = testrequete.envoi_requete("SELECT co.id_course, co.courseName, co.nbHours FROM courses co, student_courses st_c WHERE st_c.student_id ="+ id_student_int+ " and st_c.university_id="+ id_univ_int+" and co.id_course = st_c.courses_id");

       while (rs.next()){
           size++ ;
           resultat=(resultat+rs.getString("co.id_course")+"="+rs.getString("co.courseName")+"="+rs.getString("co.nbHours")+"=");
       }

           return size+"="+resultat;

    }

    /**
     * PUT method for updating or creating an instance of ListLearningResource
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/xml")
    public void putXml(String content) {
    }
}
