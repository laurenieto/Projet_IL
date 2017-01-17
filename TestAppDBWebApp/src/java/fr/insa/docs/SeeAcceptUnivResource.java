/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.insa.docs;
import univ.list.fr.testrequete;
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
        ResultSet rs = null;
        String resultat="";
        int size= 0;
        int id_st = Integer.parseInt(id_student);
        try {

            String sql_str = "SELECT s.university_id, univ.univName, univ.city, univ.country, univ.email, univ.telephone, univ.address, univ.nbPlaces FROM student_university s, university univ  WHERE s.univResponse=1 and s.university_id = univ.id_university and s.student_id='"+id_st+"'";

            rs = testrequete.envoi_requete(sql_str);
            while (rs.next()){
                size++ ;
                resultat = resultat+rs.getString("s.university_id")+"="+rs.getString("univ.univName")+"="+rs.getString("univ.country")+"="+rs.getString("univ.city")+"="+rs.getString("univ.address")+"="+rs.getString("univ.email")+"="+rs.getString("univ.telephone")+"="+rs.getString("univ.nbPlaces")+"=";
            }
        } catch (SQLException ex) {
            Logger.getLogger(ApplyResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        return size+"="+resultat;
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
