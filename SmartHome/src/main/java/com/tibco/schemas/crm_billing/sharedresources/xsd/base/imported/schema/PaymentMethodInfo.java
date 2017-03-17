
package com.tibco.schemas.crm_billing.sharedresources.xsd.base.imported.schema;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for PaymentMethodInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PaymentMethodInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="paymentMethod" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="recurringFrequency" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="recurringFrequencyValue" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="recurringAmount" type="{http://www.tibco.com/schemas/CRM-Billing/SharedResources/XSD/Base/Imported/Schema.xsd}Money" minOccurs="0"/>
 *         &lt;element name="issueDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="paymentType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="bankCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="bankAccountNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="bankAccountType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="bankBranchNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="creditCardType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="creditCardNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="creditCardExpirationDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="pin" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="paymentMeansOwnerDetails" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PaymentMethodInfo", propOrder = {
    "paymentMethod",
    "recurringFrequency",
    "recurringFrequencyValue",
    "recurringAmount",
    "issueDate",
    "paymentType",
    "bankCode",
    "bankAccountNo",
    "bankAccountType",
    "bankBranchNo",
    "creditCardType",
    "creditCardNo",
    "creditCardExpirationDate",
    "pin",
    "paymentMeansOwnerDetails"
})
public class PaymentMethodInfo {

    @XmlElementRef(name = "paymentMethod", namespace = "http://www.tibco.com/schemas/CRM-Billing/SharedResources/XSD/Base/Imported/Schema.xsd", type = JAXBElement.class)
    protected JAXBElement<String> paymentMethod;
    @XmlElementRef(name = "recurringFrequency", namespace = "http://www.tibco.com/schemas/CRM-Billing/SharedResources/XSD/Base/Imported/Schema.xsd", type = JAXBElement.class)
    protected JAXBElement<String> recurringFrequency;
    @XmlElementRef(name = "recurringFrequencyValue", namespace = "http://www.tibco.com/schemas/CRM-Billing/SharedResources/XSD/Base/Imported/Schema.xsd", type = JAXBElement.class)
    protected JAXBElement<Integer> recurringFrequencyValue;
    @XmlElementRef(name = "recurringAmount", namespace = "http://www.tibco.com/schemas/CRM-Billing/SharedResources/XSD/Base/Imported/Schema.xsd", type = JAXBElement.class)
    protected JAXBElement<Money> recurringAmount;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar issueDate;
    @XmlElementRef(name = "paymentType", namespace = "http://www.tibco.com/schemas/CRM-Billing/SharedResources/XSD/Base/Imported/Schema.xsd", type = JAXBElement.class)
    protected JAXBElement<String> paymentType;
    @XmlElementRef(name = "bankCode", namespace = "http://www.tibco.com/schemas/CRM-Billing/SharedResources/XSD/Base/Imported/Schema.xsd", type = JAXBElement.class)
    protected JAXBElement<String> bankCode;
    @XmlElementRef(name = "bankAccountNo", namespace = "http://www.tibco.com/schemas/CRM-Billing/SharedResources/XSD/Base/Imported/Schema.xsd", type = JAXBElement.class)
    protected JAXBElement<String> bankAccountNo;
    @XmlElementRef(name = "bankAccountType", namespace = "http://www.tibco.com/schemas/CRM-Billing/SharedResources/XSD/Base/Imported/Schema.xsd", type = JAXBElement.class)
    protected JAXBElement<String> bankAccountType;
    @XmlElementRef(name = "bankBranchNo", namespace = "http://www.tibco.com/schemas/CRM-Billing/SharedResources/XSD/Base/Imported/Schema.xsd", type = JAXBElement.class)
    protected JAXBElement<String> bankBranchNo;
    @XmlElementRef(name = "creditCardType", namespace = "http://www.tibco.com/schemas/CRM-Billing/SharedResources/XSD/Base/Imported/Schema.xsd", type = JAXBElement.class)
    protected JAXBElement<String> creditCardType;
    @XmlElementRef(name = "creditCardNo", namespace = "http://www.tibco.com/schemas/CRM-Billing/SharedResources/XSD/Base/Imported/Schema.xsd", type = JAXBElement.class)
    protected JAXBElement<String> creditCardNo;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar creditCardExpirationDate;
    @XmlElementRef(name = "pin", namespace = "http://www.tibco.com/schemas/CRM-Billing/SharedResources/XSD/Base/Imported/Schema.xsd", type = JAXBElement.class)
    protected JAXBElement<String> pin;
    @XmlElementRef(name = "paymentMeansOwnerDetails", namespace = "http://www.tibco.com/schemas/CRM-Billing/SharedResources/XSD/Base/Imported/Schema.xsd", type = JAXBElement.class)
    protected JAXBElement<String> paymentMeansOwnerDetails;

    /**
     * Gets the value of the paymentMethod property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPaymentMethod() {
        return paymentMethod;
    }

    /**
     * Sets the value of the paymentMethod property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPaymentMethod(JAXBElement<String> value) {
        this.paymentMethod = value;
    }

    /**
     * Gets the value of the recurringFrequency property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getRecurringFrequency() {
        return recurringFrequency;
    }

    /**
     * Sets the value of the recurringFrequency property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setRecurringFrequency(JAXBElement<String> value) {
        this.recurringFrequency = value;
    }

    /**
     * Gets the value of the recurringFrequencyValue property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public JAXBElement<Integer> getRecurringFrequencyValue() {
        return recurringFrequencyValue;
    }

    /**
     * Sets the value of the recurringFrequencyValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public void setRecurringFrequencyValue(JAXBElement<Integer> value) {
        this.recurringFrequencyValue = value;
    }

    /**
     * Gets the value of the recurringAmount property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Money }{@code >}
     *     
     */
    public JAXBElement<Money> getRecurringAmount() {
        return recurringAmount;
    }

    /**
     * Sets the value of the recurringAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Money }{@code >}
     *     
     */
    public void setRecurringAmount(JAXBElement<Money> value) {
        this.recurringAmount = value;
    }

    /**
     * Gets the value of the issueDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getIssueDate() {
        return issueDate;
    }

    /**
     * Sets the value of the issueDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setIssueDate(XMLGregorianCalendar value) {
        this.issueDate = value;
    }

    /**
     * Gets the value of the paymentType property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPaymentType() {
        return paymentType;
    }

    /**
     * Sets the value of the paymentType property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPaymentType(JAXBElement<String> value) {
        this.paymentType = value;
    }

    /**
     * Gets the value of the bankCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getBankCode() {
        return bankCode;
    }

    /**
     * Sets the value of the bankCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setBankCode(JAXBElement<String> value) {
        this.bankCode = value;
    }

    /**
     * Gets the value of the bankAccountNo property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getBankAccountNo() {
        return bankAccountNo;
    }

    /**
     * Sets the value of the bankAccountNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setBankAccountNo(JAXBElement<String> value) {
        this.bankAccountNo = value;
    }

    /**
     * Gets the value of the bankAccountType property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getBankAccountType() {
        return bankAccountType;
    }

    /**
     * Sets the value of the bankAccountType property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setBankAccountType(JAXBElement<String> value) {
        this.bankAccountType = value;
    }

    /**
     * Gets the value of the bankBranchNo property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getBankBranchNo() {
        return bankBranchNo;
    }

    /**
     * Sets the value of the bankBranchNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setBankBranchNo(JAXBElement<String> value) {
        this.bankBranchNo = value;
    }

    /**
     * Gets the value of the creditCardType property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCreditCardType() {
        return creditCardType;
    }

    /**
     * Sets the value of the creditCardType property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCreditCardType(JAXBElement<String> value) {
        this.creditCardType = value;
    }

    /**
     * Gets the value of the creditCardNo property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCreditCardNo() {
        return creditCardNo;
    }

    /**
     * Sets the value of the creditCardNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCreditCardNo(JAXBElement<String> value) {
        this.creditCardNo = value;
    }

    /**
     * Gets the value of the creditCardExpirationDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCreditCardExpirationDate() {
        return creditCardExpirationDate;
    }

    /**
     * Sets the value of the creditCardExpirationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCreditCardExpirationDate(XMLGregorianCalendar value) {
        this.creditCardExpirationDate = value;
    }

    /**
     * Gets the value of the pin property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPin() {
        return pin;
    }

    /**
     * Sets the value of the pin property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPin(JAXBElement<String> value) {
        this.pin = value;
    }

    /**
     * Gets the value of the paymentMeansOwnerDetails property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPaymentMeansOwnerDetails() {
        return paymentMeansOwnerDetails;
    }

    /**
     * Sets the value of the paymentMeansOwnerDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPaymentMeansOwnerDetails(JAXBElement<String> value) {
        this.paymentMeansOwnerDetails = value;
    }

}
