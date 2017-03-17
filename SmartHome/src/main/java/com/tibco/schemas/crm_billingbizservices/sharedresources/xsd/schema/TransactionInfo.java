
package com.tibco.schemas.crm_billingbizservices.sharedresources.xsd.schema;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TransactionInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TransactionInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="transChannelId">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="16"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="transSubChannel" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="10"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="transUserId">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="32"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="transBpId">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="36"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="transPath">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="256"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TransactionInfo", propOrder = {
    "transChannelId",
    "transSubChannel",
    "transUserId",
    "transBpId",
    "transPath"
})
public class TransactionInfo {

    @XmlElement(required = true)
    protected String transChannelId;
    @XmlElementRef(name = "transSubChannel", namespace = "http://www.tibco.com/schemas/CRM-BillingBizServices/SharedResources/XSD/Schema.xsd", type = JAXBElement.class)
    protected JAXBElement<String> transSubChannel;
    @XmlElement(required = true)
    protected String transUserId;
    @XmlElement(required = true)
    protected String transBpId;
    @XmlElement(required = true)
    protected String transPath;

    /**
     * Gets the value of the transChannelId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransChannelId() {
        return transChannelId;
    }

    /**
     * Sets the value of the transChannelId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransChannelId(String value) {
        this.transChannelId = value;
    }

    /**
     * Gets the value of the transSubChannel property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTransSubChannel() {
        return transSubChannel;
    }

    /**
     * Sets the value of the transSubChannel property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTransSubChannel(JAXBElement<String> value) {
        this.transSubChannel = value;
    }

    /**
     * Gets the value of the transUserId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransUserId() {
        return transUserId;
    }

    /**
     * Sets the value of the transUserId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransUserId(String value) {
        this.transUserId = value;
    }

    /**
     * Gets the value of the transBpId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransBpId() {
        return transBpId;
    }

    /**
     * Sets the value of the transBpId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransBpId(String value) {
        this.transBpId = value;
    }

    /**
     * Gets the value of the transPath property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransPath() {
        return transPath;
    }

    /**
     * Sets the value of the transPath property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransPath(String value) {
        this.transPath = value;
    }

}
