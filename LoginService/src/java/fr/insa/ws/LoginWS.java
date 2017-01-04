/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.insa.ws;

import javax.ejb.Stateless;
import javax.jws.WebService;
import org.netbeans.j2ee.wsdl.loginservice.loginwsdl.LoginWSDLPortType;

/**
 *
 * @author laure
 */
@WebService(serviceName = "LoginWSDLService", portName = "LoginWSDLPort", endpointInterface = "org.netbeans.j2ee.wsdl.loginservice.loginwsdl.LoginWSDLPortType", targetNamespace = "http://j2ee.netbeans.org/wsdl/LoginService/LoginWSDL", wsdlLocation = "META-INF/wsdl/LoginWS/LoginWSDLWrapper.wsdl")
@Stateless
public class LoginWS implements LoginWSDLPortType{

    public org.netbeans.xml.schema.loginreply.LoginReplyType isInDBOperation(org.netbeans.xml.schema.loginrequest.LoginRequestType loginInfo) {
        //TODO implement this method
        //throw new UnsupportedOperationException("Not implemented yet.");
        org.netbeans.xml.schema.loginreply.LoginReplyType reply = new org.netbeans.xml.schema.loginreply.LoginReplyType();
        reply.setIsInDB(true);
        return reply;
    }

}
