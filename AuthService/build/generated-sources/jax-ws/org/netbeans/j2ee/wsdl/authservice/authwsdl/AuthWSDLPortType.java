
package org.netbeans.j2ee.wsdl.authservice.authwsdl;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import org.netbeans.xml.schema.authreply.AuthReplyType;
import org.netbeans.xml.schema.authrequest.AuthRequestType;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.3.3-hudson-757-SNAPSHOT
 * Generated source version: 2.1
 * 
 */
@WebService(name = "AuthWSDLPortType", targetNamespace = "http://j2ee.netbeans.org/wsdl/AuthService/AuthWSDL")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
    org.netbeans.xml.schema.authreply.ObjectFactory.class,
    org.netbeans.xml.schema.authrequest.ObjectFactory.class
})
public interface AuthWSDLPortType {


    /**
     * 
     * @param userInfo
     * @return
     *     returns org.netbeans.xml.schema.authreply.AuthReplyType
     */
    @WebMethod(operationName = "AuthWSDLOperation", action = "AuthWSDLOperation_action")
    @WebResult(name = "AuthReply", targetNamespace = "http://xml.netbeans.org/schema/AuthReply", partName = "isInDB")
    public AuthReplyType authWSDLOperation(
        @WebParam(name = "AuthRequest", targetNamespace = "http://xml.netbeans.org/schema/AuthRequest", partName = "userInfo")
        AuthRequestType userInfo);

}