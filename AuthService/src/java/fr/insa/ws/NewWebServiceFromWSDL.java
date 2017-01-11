/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.insa.ws;
import org.netbeans.j2ee.wsdl.authservice.authwsdl.AuthWSDLPortType;
import javax.ejb.Stateless;
import javax.jws.WebService;

/**
 *
 * @author laure
 */
@WebService(serviceName = "AuthWSDLService", portName = "AuthWSDLPort", endpointInterface = "org.netbeans.j2ee.wsdl.authservice.authwsdl.AuthWSDLPortType", targetNamespace = "http://j2ee.netbeans.org/wsdl/AuthService/AuthWSDL", wsdlLocation = "META-INF/wsdl/NewWebServiceFromWSDL/AuthWSDLWrapper.wsdl")
@Stateless
public class NewWebServiceFromWSDL implements AuthWSDLPortType{

    public org.netbeans.xml.schema.authreply.AuthReplyType getAuthOperation(org.netbeans.xml.schema.authrequest.AuthRequestType userInfo) {
        //TODO implement this method
        String pwd = userInfo.getPassword();
        org.netbeans.xml.schema.authreply.AuthReplyType reply = new org.netbeans.xml.schema.authreply.AuthReplyType();
        reply.setIsInDBReply(false);
        return reply;
    }
}
