
package org.netbeans.xml.schema.loginreply;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.netbeans.xml.schema.loginreply package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _LoginReply_QNAME = new QName("http://xml.netbeans.org/schema/LoginReply", "LoginReply");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.netbeans.xml.schema.loginreply
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link LoginReplyType }
     * 
     */
    public LoginReplyType createLoginReplyType() {
        return new LoginReplyType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoginReplyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xml.netbeans.org/schema/LoginReply", name = "LoginReply")
    public JAXBElement<LoginReplyType> createLoginReply(LoginReplyType value) {
        return new JAXBElement<LoginReplyType>(_LoginReply_QNAME, LoginReplyType.class, null, value);
    }

}
