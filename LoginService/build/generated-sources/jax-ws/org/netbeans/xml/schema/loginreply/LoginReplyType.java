
package org.netbeans.xml.schema.loginreply;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for LoginReplyType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LoginReplyType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="isInDB" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LoginReplyType", propOrder = {
    "isInDB"
})
public class LoginReplyType {

    protected boolean isInDB;

    /**
     * Gets the value of the isInDB property.
     * 
     */
    public boolean isIsInDB() {
        return isInDB;
    }

    /**
     * Sets the value of the isInDB property.
     * 
     */
    public void setIsInDB(boolean value) {
        this.isInDB = value;
    }

}
