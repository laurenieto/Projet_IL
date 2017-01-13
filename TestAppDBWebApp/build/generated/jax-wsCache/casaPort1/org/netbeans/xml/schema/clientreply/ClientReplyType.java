
package org.netbeans.xml.schema.clientreply;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ClientReplyType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ClientReplyType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="isInDBReplyClient" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ClientReplyType", propOrder = {
    "isInDBReplyClient"
})
public class ClientReplyType {

    protected boolean isInDBReplyClient;

    /**
     * Gets the value of the isInDBReplyClient property.
     * 
     */
    public boolean isIsInDBReplyClient() {
        return isInDBReplyClient;
    }

    /**
     * Sets the value of the isInDBReplyClient property.
     * 
     */
    public void setIsInDBReplyClient(boolean value) {
        this.isInDBReplyClient = value;
    }

}
