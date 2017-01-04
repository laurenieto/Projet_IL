
package fr.insa.login;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getUserInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getUserInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="connexionParameter" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getUserInfo", propOrder = {
    "connexionParameter"
})
public class GetUserInfo {

    protected String connexionParameter;

    /**
     * Gets the value of the connexionParameter property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConnexionParameter() {
        return connexionParameter;
    }

    /**
     * Sets the value of the connexionParameter property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConnexionParameter(String value) {
        this.connexionParameter = value;
    }

}
