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
 * @author laure
 */

@Path("addCourseToLearning")
public class AddCourseToLearningResource {
    @Context
    private UriInfo context;

    /** Creates a new instance of AddCourseToLearningResource */
    public AddCourseToLearningResource() {
    }

    /**
     * Retrieves representation of an instance of fr.insa.docs.AddCourseToLearningResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/xml")
    public String getXml() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of AddCourseToLearningResource
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("text/plain")
     public String insertCourse(@QueryParam("id_student") String id_student, @QueryParam("id_univ") String id_univ, @QueryParam("id_course") String id_course) {
        PreparedStatement ps = null;

        try {
            int id_st_int = Integer.parseInt(id_student);
            int id_univ_int = Integer.parseInt(id_univ);
            int id_course_int = Integer.parseInt(id_course);
            String sql_str = "INSERT INTO student_courses VALUES (" + id_course_int + "," + id_st_int + ", "+ id_univ_int+")";

            Connection con = ConnectToDB.connect();
            ps = con.prepareStatement(sql_str);

            ps.executeUpdate();
            return String.valueOf("ok");
        } catch (SQLException ex) {
            Logger.getLogger(ApplyResource.class.getName()).log(Level.SEVERE, null, ex);
            return ex.toString();
        }

    }
}
