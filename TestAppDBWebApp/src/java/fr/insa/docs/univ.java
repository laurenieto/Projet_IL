/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.insa.docs;
import univ.list.fr.testrequete;

import java.sql.ResultSet;
import java.sql.SQLException;
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
 * @author Lilian
 */

@Path("univ")
public class univ {
    @Context
    private UriInfo context;

    /** Creates a new instance of univ */
    public univ() {
    }

    /**
     * Retrieves representation of an instance of univ.list.fr.univ
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("text/plain")
    public String getUniv(@QueryParam("name") String name) throws SQLException {

       int size= 0;

       ResultSet rs = null;
       String resultat = "";

       if (name == null) {
           rs = testrequete.envoi_requete("SELECT * FROM university");
       }
       else {
           rs = testrequete.envoi_requete("SELECT * FROM university WHERE univName LIKE '%"+name+"%'");
       }

       while (rs.next()){
           size++ ;
           resultat=(resultat+rs.getString("id_university")+"="+rs.getString("univName")+"="+rs.getString("country")+"="+rs.getString("city")+"="+rs.getString("address")+"="+rs.getString("email")+"="+rs.getString("telephone")+"="+rs.getString("nbPlaces")+"=");
       }

           return size+"="+resultat;

    }

    /**
     * PUT method for updating or creating an instance of univ
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }
}