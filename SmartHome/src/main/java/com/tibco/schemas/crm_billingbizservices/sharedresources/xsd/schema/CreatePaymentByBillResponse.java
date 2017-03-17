
package com.tibco.schemas.crm_billingbizservices.sharedresources.xsd.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import tw.com.fet.itsoa.schemas.common_domain.sharedresources.xsd.base.schema.ReturnHeader;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="returnHeader" type="{http://www.fet.com.tw/ITSOA/schemas/Common-Domain/SharedResources/XSD/Base/Schema.xsd2}ReturnHeader"/>
 *         &lt;element name="barcodeSeq" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sMessage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sRespCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sReturnCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="transactionId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "returnHeader",
    "barcodeSeq",
    "sMessage",
    "sRespCode",
    "sReturnCode",
    "transactionId"
})
@XmlRootElement(name = "createPaymentByBillResponse")
public class CreatePaymentByBillResponse {

    @XmlElement(required = true)
    protected ReturnHeader returnHeader;
    protected String barcodeSeq;
    protected String sMessage;
    protected String sRespCode;
    protected String sReturnCode;
    protected String transactionId;

    /**
     * Gets the value of the returnHeader property.
     * 
     * @return
     *     possible object is
     *     {@link ReturnHeader }
     *     
     */
    public ReturnHeader getReturnHeader() {
        return returnHeader;
    }

    /**
     * Sets the value of the returnHeader property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReturnHeader }
     *     
     */
    public void setReturnHeader(ReturnHeader value) {
        this.returnHeader = value;
    }

    /**
     * Gets the value of the barcodeSeq property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBarcodeSeq() {
        return barcodeSeq;
    }

    /**
     * Sets the value of the barcodeSeq property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBarcodeSeq(String value) {
        this.barcodeSeq = value;
    }

    /**
     * Gets the value of the sMessage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSMessage() {
        return sMessage;
    }

    /**
     * Sets the value of the sMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSMessage(String value) {
        this.sMessage = value;
    }

    /**
     * Gets the value of the sRespCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSRespCode() {
        return sRespCode;
    }

    /**
     * Sets the value of the sRespCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSRespCode(String value) {
        this.sRespCode = value;
    }

    /**
     * Gets the value of the sReturnCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSReturnCode() {
        return sReturnCode;
    }

    /**
     * Sets the value of the sReturnCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSReturnCode(String value) {
        this.sReturnCode = value;
    }

    /**
     * Gets the value of the transactionId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransactionId() {
        return transactionId;
    }

    /**
     * Sets the value of the transactionId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransactionId(String value) {
        this.transactionId = value;
    }

}
