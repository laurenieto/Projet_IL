
package org.netbeans.xml.schema.clientreply;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.netbeans.xml.schema.clientreply package. 
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

    private final static QName _ClientReply_QNAME = new QName("http://xml.netbeans.org/schema/ClientReply", "ClientReply");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.netbeans.xml.schema.clientreply
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ClientReplyType }
     * 
     */
    public ClientReplyType createClientReplyType() {
        return new ClientReplyType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ClientReplyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xml.netbeans.org/schema/ClientReply", name = "ClientReply")
    public JAXBElement<ClientReplyType> createClientReply(ClientReplyType value) {
        return new JAXBElement<ClientReplyType>(_ClientReply_QNAME, ClientReplyType.class, null, value);
    }

}
