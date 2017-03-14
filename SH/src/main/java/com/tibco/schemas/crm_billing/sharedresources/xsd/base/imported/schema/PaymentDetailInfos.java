
package com.tibco.schemas.crm_billing.sharedresources.xsd.base.imported.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for PaymentDetailInfos complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PaymentDetailInfos">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="accountNoInfo" type="{http://www.tibco.com/schemas/CRM-Billing/SharedResources/XSD/Base/Imported/Schema.xsd}AccountNoInfo"/>
 *         &lt;element name="invoiceNoInfo" type="{http://www.tibco.com/schemas/CRM-Billing/SharedResources/XSD/Base/Imported/Schema.xsd}InvoiceNoInfo" minOccurs="0"/>
 *         &lt;element name="invoiceDueDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="invoiceAmount" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="paymentAmount" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="depositDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="msisdn" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="businessEntity" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="paymentSource" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="billSendType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PaymentDetailInfos", propOrder = {
    "accountNoInfo",
    "invoiceNoInfo",
    "invoiceDueDate",
    "invoiceAmount",
    "paymentAmount",
    "depositDate",
    "msisdn",
    "businessEntity",
    "paymentSource",
    "billSendType"
})
public class PaymentDetailInfos {

    @XmlElement(required = true)
    protected AccountNoInfo accountNoInfo;
    protected InvoiceNoInfo invoiceNoInfo;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar invoiceDueDate;
    protected double invoiceAmount;
    protected double paymentAmount;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar depositDate;
    protected String msisdn;
    @XmlElement(required = true)
    protected String businessEntity;
    @XmlElement(required = true)
    protected String paymentSource;
    protected String billSendType;

    /**
     * Gets the value of the accountNoInfo property.
     * 
     * @return
     *     possible object is
     *     {@link AccountNoInfo }
     *     
     */
    public AccountNoInfo getAccountNoInfo() {
        return accountNoInfo;
    }

    /**
     * Sets the value of the accountNoInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link AccountNoInfo }
     *     
     */
    public void setAccountNoInfo(AccountNoInfo value) {
        this.accountNoInfo = value;
    }

    /**
     * Gets the value of the invoiceNoInfo property.
     * 
     * @return
     *     possible object is
     *     {@link InvoiceNoInfo }
     *     
     */
    public InvoiceNoInfo getInvoiceNoInfo() {
        return invoiceNoInfo;
    }

    /**
     * Sets the value of the invoiceNoInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link InvoiceNoInfo }
     *     
     */
    public void setInvoiceNoInfo(InvoiceNoInfo value) {
        this.invoiceNoInfo = value;
    }

    /**
     * Gets the value of the invoiceDueDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getInvoiceDueDate() {
        return invoiceDueDate;
    }

    /**
     * Sets the value of the invoiceDueDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setInvoiceDueDate(XMLGregorianCalendar value) {
        this.invoiceDueDate = value;
    }

    /**
     * Gets the value of the invoiceAmount property.
     * 
     */
    public double getInvoiceAmount() {
        return invoiceAmount;
    }

    /**
     * Sets the value of the invoiceAmount property.
     * 
     */
    public void setInvoiceAmount(double value) {
        this.invoiceAmount = value;
    }

    /**
     * Gets the value of the paymentAmount property.
     * 
     */
    public double getPaymentAmount() {
        return paymentAmount;
    }

    /**
     * Sets the value of the paymentAmount property.
     * 
     */
    public void setPaymentAmount(double value) {
        this.paymentAmount = value;
    }

    /**
     * Gets the value of the depositDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDepositDate() {
        return depositDate;
    }

    /**
     * Sets the value of the depositDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDepositDate(XMLGregorianCalendar value) {
        this.depositDate = value;
    }

    /**
     * Gets the value of the msisdn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMsisdn() {
        return msisdn;
    }

    /**
     * Sets the value of the msisdn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMsisdn(String value) {
        this.msisdn = value;
    }

    /**
     * Gets the value of the businessEntity property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBusinessEntity() {
        return businessEntity;
    }

    /**
     * Sets the value of the businessEntity property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBusinessEntity(String value) {
        this.businessEntity = value;
    }

    /**
     * Gets the value of the paymentSource property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaymentSource() {
        return paymentSource;
    }

    /**
     * Sets the value of the paymentSource property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaymentSource(String value) {
        this.paymentSource = value;
    }

    /**
     * Gets the value of the billSendType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBillSendType() {
        return billSendType;
    }

    /**
     * Sets the value of the billSendType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBillSendType(String value) {
        this.billSendType = value;
    }

}
