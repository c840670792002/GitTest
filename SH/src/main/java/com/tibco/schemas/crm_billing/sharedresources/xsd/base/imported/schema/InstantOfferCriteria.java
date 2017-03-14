
package com.tibco.schemas.crm_billing.sharedresources.xsd.base.imported.schema;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for InstantOfferCriteria complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="InstantOfferCriteria">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ouId" type="{http://www.tibco.com/schemas/CRM-Billing/SharedResources/XSD/Base/Imported/Schema.xsd}UnitNoInfo" minOccurs="0"/>
 *         &lt;element name="queryDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="subscriberNo" type="{http://www.tibco.com/schemas/CRM-Billing/SharedResources/XSD/Base/Imported/Schema.xsd}SubscriberNoInfo" minOccurs="0"/>
 *         &lt;element name="withHistory" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InstantOfferCriteria", propOrder = {
    "ouId",
    "queryDate",
    "subscriberNo",
    "withHistory"
})
public class InstantOfferCriteria {

    @XmlElementRef(name = "ouId", namespace = "http://www.tibco.com/schemas/CRM-Billing/SharedResources/XSD/Base/Imported/Schema.xsd", type = JAXBElement.class)
    protected JAXBElement<UnitNoInfo> ouId;
    @XmlElementRef(name = "queryDate", namespace = "http://www.tibco.com/schemas/CRM-Billing/SharedResources/XSD/Base/Imported/Schema.xsd", type = JAXBElement.class)
    protected JAXBElement<XMLGregorianCalendar> queryDate;
    @XmlElementRef(name = "subscriberNo", namespace = "http://www.tibco.com/schemas/CRM-Billing/SharedResources/XSD/Base/Imported/Schema.xsd", type = JAXBElement.class)
    protected JAXBElement<SubscriberNoInfo> subscriberNo;
    @XmlElementRef(name = "withHistory", namespace = "http://www.tibco.com/schemas/CRM-Billing/SharedResources/XSD/Base/Imported/Schema.xsd", type = JAXBElement.class)
    protected JAXBElement<Boolean> withHistory;

    /**
     * Gets the value of the ouId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link UnitNoInfo }{@code >}
     *     
     */
    public JAXBElement<UnitNoInfo> getOuId() {
        return ouId;
    }

    /**
     * Sets the value of the ouId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link UnitNoInfo }{@code >}
     *     
     */
    public void setOuId(JAXBElement<UnitNoInfo> value) {
        this.ouId = value;
    }

    /**
     * Gets the value of the queryDate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getQueryDate() {
        return queryDate;
    }

    /**
     * Sets the value of the queryDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setQueryDate(JAXBElement<XMLGregorianCalendar> value) {
        this.queryDate = value;
    }

    /**
     * Gets the value of the subscriberNo property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link SubscriberNoInfo }{@code >}
     *     
     */
    public JAXBElement<SubscriberNoInfo> getSubscriberNo() {
        return subscriberNo;
    }

    /**
     * Sets the value of the subscriberNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link SubscriberNoInfo }{@code >}
     *     
     */
    public void setSubscriberNo(JAXBElement<SubscriberNoInfo> value) {
        this.subscriberNo = value;
    }

    /**
     * Gets the value of the withHistory property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public JAXBElement<Boolean> getWithHistory() {
        return withHistory;
    }

    /**
     * Sets the value of the withHistory property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public void setWithHistory(JAXBElement<Boolean> value) {
        this.withHistory = value;
    }

}
