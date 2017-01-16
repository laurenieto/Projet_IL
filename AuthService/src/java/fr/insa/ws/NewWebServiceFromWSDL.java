/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.insa.ws;

import javax.ejb.Stateless;
import javax.jws.WebService;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.netbeans.j2ee.wsdl.authservice.authwsdl.AuthWSDLPortType;
/**
 *
 * @author laure
 */
@WebService(serviceName = "AuthWSDLService", portName = "AuthWSDLPort", endpointInterface = "org.netbeans.j2ee.wsdl.authservice.authwsdl.AuthWSDLPortType", targetNamespace = "http://j2ee.netbeans.org/wsdl/AuthService/AuthWSDL", wsdlLocation = "META-INF/wsdl/NewWebServiceFromWSDL/AuthWSDLWrapper.wsdl")
@Stateless
public class NewWebServiceFromWSDL implements AuthWSDLPortType {

    public org.netbeans.xml.schema.authreply.AuthReplyType authWSDLOperation(org.netbeans.xml.schema.authrequest.AuthRequestType userInfo) {
        Connection con= null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String driverName = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/testdatabase";
        String user = "root";
        String password = "salope1";
        boolean rep = false;
        try {
            String username = userInfo.getPassword();
            String pwd = userInfo.getUsername();
            String sql_str = "SELECT username, password FROM student WHERE username= '"+username+ "' AND password='" + pwd + "'";
            Class.forName(driverName);
            con = DriverManager.getConnection(url, user, password);

            ps = con.prepareStatement(sql_str);

            rs = ps.executeQuery();

            int rowcount = 0;

            if (rs.last()) {
              rowcount = rs.getRow();
              rs.beforeFirst(); // not rs.first() because the rs.next() below will move on, missing the first element
            }

            if (rowcount != 0){
                rep=true;

            }
        }
        catch (Exception ex) {System.out.print(ex);}
        org.netbeans.xml.schema.authreply.AuthReplyType reply = new org.netbeans.xml.schema.authreply.AuthReplyType();
        reply.setIsInDBReply(rep);
        return reply;
    }

}
