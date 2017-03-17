
package com.tibco.schemas.crm_billing.sharedresources.xsd.base.imported.schema;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for PayChannelInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PayChannelInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="payChannelNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="paymentCategory" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="description" type="{http://www.tibco.com/schemas/CRM-Billing/SharedResources/XSD/Base/Imported/Schema.xsd}Description" minOccurs="0"/>
 *         &lt;element name="benNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pcnNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="l9EncryptSubRocId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="l9BirthDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="customerAccountNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="customerBillingArrangement" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="customerNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="l9ccInfoUpdateDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="paymentMethod" type="{http://www.tibco.com/schemas/CRM-Billing/SharedResources/XSD/Base/Imported/Schema.xsd}PaymentMethodInfo" minOccurs="0"/>
 *         &lt;element name="payChannelStatus" type="{http://www.tibco.com/schemas/CRM-Billing/SharedResources/XSD/Base/Imported/Schema.xsd}PayChannelStatusInfo" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PayChannelInfo", propOrder = {
    "payChannelNo",
    "paymentCategory",
    "description",
    "benNumber",
    "pcnNumber",
    "l9EncryptSubRocId",
    "l9BirthDate",
    "customerAccountNo",
    "customerBillingArrangement",
    "customerNo",
    "l9CcInfoUpdateDate",
    "paymentMethod",
    "payChannelStatus"
})
public class PayChannelInfo {

    @XmlElementRef(name = "payChannelNo", namespace = "http://www.tibco.com/schemas/CRM-Billing/SharedResources/XSD/Base/Imported/Schema.xsd", type = JAXBElement.class)
    protected JAXBElement<String> payChannelNo;
    @XmlElementRef(name = "paymentCategory", namespace = "http://www.tibco.com/schemas/CRM-Billing/SharedResources/XSD/Base/Imported/Schema.xsd", type = JAXBElement.class)
    protected JAXBElement<String> paymentCategory;
    @XmlElementRef(name = "description", namespace = "http://www.tibco.com/schemas/CRM-Billing/SharedResources/XSD/Base/Imported/Schema.xsd", type = JAXBElement.class)
    protected JAXBElement<Description> description;
    @XmlElementRef(name = "benNumber", namespace = "http://www.tibco.com/schemas/CRM-Billing/SharedResources/XSD/Base/Imported/Schema.xsd", type = JAXBElement.class)
    protected JAXBElement<String> benNumber;
    @XmlElementRef(name = "pcnNumber", namespace = "http://www.tibco.com/schemas/CRM-Billing/SharedResources/XSD/Base/Imported/Schema.xsd", type = JAXBElement.class)
    protected JAXBElement<String> pcnNumber;
    @XmlElementRef(name = "l9EncryptSubRocId", namespace = "http://www.tibco.com/schemas/CRM-Billing/SharedResources/XSD/Base/Imported/Schema.xsd", type = JAXBElement.class)
    protected JAXBElement<String> l9EncryptSubRocId;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar l9BirthDate;
    @XmlElementRef(name = "customerAccountNo", namespace = "http://www.tibco.com/schemas/CRM-Billing/SharedResources/XSD/Base/Imported/Schema.xsd", type = JAXBElement.class)
    protected JAXBElement<String> customerAccountNo;
    @XmlElementRef(name = "customerBillingArrangement", namespace = "http://www.tibco.com/schemas/CRM-Billing/SharedResources/XSD/Base/Imported/Schema.xsd", type = JAXBElement.class)
    protected JAXBElement<String> customerBillingArrangement;
    @XmlElementRef(name = "customerNo", namespace = "http://www.tibco.com/schemas/CRM-Billing/SharedResources/XSD/Base/Imported/Schema.xsd", type = JAXBElement.class)
    protected JAXBElement<String> customerNo;
    @XmlElement(name = "l9ccInfoUpdateDate")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar l9CcInfoUpdateDate;
    @XmlElementRef(name = "paymentMethod", namespace = "http://www.tibco.com/schemas/CRM-Billing/SharedResources/XSD/Base/Imported/Schema.xsd", type = JAXBElement.class)
    protected JAXBElement<PaymentMethodInfo> paymentMethod;
    @XmlElementRef(name = "payChannelStatus", namespace = "http://www.tibco.com/schemas/CRM-Billing/SharedResources/XSD/Base/Imported/Schema.xsd", type = JAXBElement.class)
    protected JAXBElement<PayChannelStatusInfo> payChannelStatus;

    /**
     * Gets the value of the payChannelNo property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPayChannelNo() {
        return payChannelNo;
    }

    /**
     * Sets the value of the payChannelNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPayChannelNo(JAXBElement<String> value) {
        this.payChannelNo = value;
    }

    /**
     * Gets the value of the paymentCategory property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPaymentCategory() {
        return paymentCategory;
    }

    /**
     * Sets the value of the paymentCategory property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPaymentCategory(JAXBElement<String> value) {
        this.paymentCategory = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Description }{@code >}
     *     
     */
    public JAXBElement<Description> getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Description }{@code >}
     *     
     */
    public void setDescription(JAXBElement<Description> value) {
        this.description = value;
    }

    /**
     * Gets the value of the benNumber property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getBenNumber() {
        return benNumber;
    }

    /**
     * Sets the value of the benNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setBenNumber(JAXBElement<String> value) {
        this.benNumber = value;
    }

    /**
     * Gets the value of the pcnNumber property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPcnNumber() {
        return pcnNumber;
    }

    /**
     * Sets the value of the pcnNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPcnNumber(JAXBElement<String> value) {
        this.pcnNumber = value;
    }

    /**
     * Gets the value of the l9EncryptSubRocId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getL9EncryptSubRocId() {
        return l9EncryptSubRocId;
    }

    /**
     * Sets the value of the l9EncryptSubRocId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setL9EncryptSubRocId(JAXBElement<String> value) {
        this.l9EncryptSubRocId = value;
    }

    /**
     * Gets the value of the l9BirthDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getL9BirthDate() {
        return l9BirthDate;
    }

    /**
     * Sets the value of the l9BirthDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setL9BirthDate(XMLGregorianCalendar value) {
        this.l9BirthDate = value;
    }

    /**
     * Gets the value of the customerAccountNo property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCustomerAccountNo() {
        return customerAccountNo;
    }

    /**
     * Sets the value of the customerAccountNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCustomerAccountNo(JAXBElement<String> value) {
        this.customerAccountNo = value;
    }

    /**
     * Gets the value of the customerBillingArrangement property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCustomerBillingArrangement() {
        return customerBillingArrangement;
    }

    /**
     * Sets the value of the customerBillingArrangement property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCustomerBillingArrangement(JAXBElement<String> value) {
        this.customerBillingArrangement = value;
    }

    /**
     * Gets the value of the customerNo property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCustomerNo() {
        return customerNo;
    }

    /**
     * Sets the value of the customerNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCustomerNo(JAXBElement<String> value) {
        this.customerNo = value;
    }

    /**
     * Gets the value of the l9CcInfoUpdateDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getL9CcInfoUpdateDate() {
        return l9CcInfoUpdateDate;
    }

    /**
     * Sets the value of the l9CcInfoUpdateDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setL9CcInfoUpdateDate(XMLGregorianCalendar value) {
        this.l9CcInfoUpdateDate = value;
    }

    /**
     * Gets the value of the paymentMethod property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link PaymentMethodInfo }{@code >}
     *     
     */
    public JAXBElement<PaymentMethodInfo> getPaymentMethod() {
        return paymentMethod;
    }

    /**
     * Sets the value of the paymentMethod property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link PaymentMethodInfo }{@code >}
     *     
     */
    public void setPaymentMethod(JAXBElement<PaymentMethodInfo> value) {
        this.paymentMethod = value;
    }

    /**
     * Gets the value of the payChannelStatus property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link PayChannelStatusInfo }{@code >}
     *     
     */
    public JAXBElement<PayChannelStatusInfo> getPayChannelStatus() {
        return payChannelStatus;
    }

    /**
     * Sets the value of the payChannelStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link PayChannelStatusInfo }{@code >}
     *     
     */
    public void setPayChannelStatus(JAXBElement<PayChannelStatusInfo> value) {
        this.payChannelStatus = value;
    }

}
