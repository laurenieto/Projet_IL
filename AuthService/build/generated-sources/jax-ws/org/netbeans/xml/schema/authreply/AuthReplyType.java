
package org.netbeans.xml.schema.authreply;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AuthReplyType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AuthReplyType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="isInDBReply" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AuthReplyType", propOrder = {
    "isInDBReply"
})
public class AuthReplyType {

    protected boolean isInDBReply;

    /**
     * Gets the value of the isInDBReply property.
     * 
     */
    public boolean isIsInDBReply() {
        return isInDBReply;
    }

    /**
     * Sets the value of the isInDBReply property.
     * 
     */
    public void setIsInDBReply(boolean value) {
        this.isInDBReply = value;
    }

}
