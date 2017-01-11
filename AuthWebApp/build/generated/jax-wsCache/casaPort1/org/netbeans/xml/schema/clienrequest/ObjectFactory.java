
package org.netbeans.xml.schema.clienrequest;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.netbeans.xml.schema.clienrequest package. 
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

    private final static QName _ClientRequest_QNAME = new QName("http://xml.netbeans.org/schema/ClienRequest", "ClientRequest");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.netbeans.xml.schema.clienrequest
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ClienRequestType }
     * 
     */
    public ClienRequestType createClienRequestType() {
        return new ClienRequestType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ClienRequestType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xml.netbeans.org/schema/ClienRequest", name = "ClientRequest")
    public JAXBElement<ClienRequestType> createClientRequest(ClienRequestType value) {
        return new JAXBElement<ClienRequestType>(_ClientRequest_QNAME, ClienRequestType.class, null, value);
    }

}
