
package com.tibco.schemas.crm_billing.sharedresources.xsd.base.imported.schema;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Cm9AgrPromoMaster complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Cm9AgrPromoMaster">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="bonusCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="l9PromtionId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="promoSeqNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="removeWithPromo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Cm9AgrPromoMaster", propOrder = {
    "bonusCode",
    "l9PromtionId",
    "promoSeqNo",
    "removeWithPromo"
})
public class Cm9AgrPromoMaster {

    @XmlElementRef(name = "bonusCode", namespace = "http://www.tibco.com/schemas/CRM-Billing/SharedResources/XSD/Base/Imported/Schema.xsd", type = JAXBElement.class)
    protected JAXBElement<String> bonusCode;
    @XmlElementRef(name = "l9PromtionId", namespace = "http://www.tibco.com/schemas/CRM-Billing/SharedResources/XSD/Base/Imported/Schema.xsd", type = JAXBElement.class)
    protected JAXBElement<String> l9PromtionId;
    @XmlElementRef(name = "promoSeqNo", namespace = "http://www.tibco.com/schemas/CRM-Billing/SharedResources/XSD/Base/Imported/Schema.xsd", type = JAXBElement.class)
    protected JAXBElement<String> promoSeqNo;
    @XmlElementRef(name = "removeWithPromo", namespace = "http://www.tibco.com/schemas/CRM-Billing/SharedResources/XSD/Base/Imported/Schema.xsd", type = JAXBElement.class)
    protected JAXBElement<String> removeWithPromo;

    /**
     * Gets the value of the bonusCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getBonusCode() {
        return bonusCode;
    }

    /**
     * Sets the value of the bonusCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setBonusCode(JAXBElement<String> value) {
        this.bonusCode = value;
    }

    /**
     * Gets the value of the l9PromtionId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getL9PromtionId() {
        return l9PromtionId;
    }

    /**
     * Sets the value of the l9PromtionId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setL9PromtionId(JAXBElement<String> value) {
        this.l9PromtionId = value;
    }

    /**
     * Gets the value of the promoSeqNo property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPromoSeqNo() {
        return promoSeqNo;
    }

    /**
     * Sets the value of the promoSeqNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPromoSeqNo(JAXBElement<String> value) {
        this.promoSeqNo = value;
    }

    /**
     * Gets the value of the removeWithPromo property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getRemoveWithPromo() {
        return removeWithPromo;
    }

    /**
     * Sets the value of the removeWithPromo property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setRemoveWithPromo(JAXBElement<String> value) {
        this.removeWithPromo = value;
    }

}
