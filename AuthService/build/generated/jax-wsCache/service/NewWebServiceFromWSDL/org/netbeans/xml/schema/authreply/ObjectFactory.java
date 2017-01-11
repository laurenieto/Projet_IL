
package org.netbeans.xml.schema.authreply;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.netbeans.xml.schema.authreply package. 
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

    private final static QName _AuthReply_QNAME = new QName("http://xml.netbeans.org/schema/AuthReply", "AuthReply");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.netbeans.xml.schema.authreply
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AuthReplyType }
     * 
     */
    public AuthReplyType createAuthReplyType() {
        return new AuthReplyType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AuthReplyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xml.netbeans.org/schema/AuthReply", name = "AuthReply")
    public JAXBElement<AuthReplyType> createAuthReply(AuthReplyType value) {
        return new JAXBElement<AuthReplyType>(_AuthReply_QNAME, AuthReplyType.class, null, value);
    }

}
