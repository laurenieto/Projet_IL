/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.insa.docs;

import java.sql.ResultSet;
import java.sql.SQLException;
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
 * @author laure
 */

@Path("listCourse")
public class ListCourseResource {
    @Context
    private UriInfo context;

    /** Creates a new instance of ListCourseResource */
    public ListCourseResource() {
    }

    /**
     * Retrieves representation of an instance of fr.insa.docs.ListCourseResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("text/plain")
    public String getXml(@QueryParam("id_univ") String id_univ) throws SQLException {
      int size= 0;

       ResultSet rs = null;
       String resultat = "";
       int id_univ_int = Integer.parseInt(id_univ);
       rs = testrequete.envoi_requete("SELECT co.id_course, co.courseName, co.nbHours FROM courses co, university u WHERE u.id_university="+id_univ_int + " and u.id_university = co.id_course");

       while (rs.next()){
           size++ ;
           resultat=(resultat+rs.getString("id_course")+"="+rs.getString("courseName")+"="+rs.getString("nbHours")+"=");
       }

           return size+"="+resultat;

    }


    /**
     * PUT method for updating or creating an instance of ListCourseResource
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/xml")
    public void putXml(String content) {
    }
}
