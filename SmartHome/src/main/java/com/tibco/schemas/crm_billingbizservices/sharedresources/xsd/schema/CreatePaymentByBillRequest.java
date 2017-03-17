
package com.tibco.schemas.crm_billingbizservices.sharedresources.xsd.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.tibco.schemas.crm_billing.sharedresources.xsd.base.imported.schema.BankInfo;
import com.tibco.schemas.crm_billing.sharedresources.xsd.base.imported.schema.PaymentInfo;
import tw.com.fet.itsoa.schemas.common_domain.sharedresources.xsd.base.schema.AuthInfo;


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
 *         &lt;element name="authInfo" type="{http://www.fet.com.tw/ITSOA/schemas/Common-Domain/SharedResources/XSD/Base/Schema.xsd2}AuthInfo"/>
 *         &lt;element name="transInfo" type="{http://www.tibco.com/schemas/CRM-BillingBizServices/SharedResources/XSD/Schema.xsd}TransactionInfo"/>
 *         &lt;element name="PaymentInfo" type="{http://www.tibco.com/schemas/CRM-Billing/SharedResources/XSD/Base/Imported/Schema.xsd}PaymentInfo"/>
 *         &lt;element name="BankInfo" type="{http://www.tibco.com/schemas/CRM-Billing/SharedResources/XSD/Base/Imported/Schema.xsd}BankInfo"/>
 *         &lt;element name="TransactionInfo" type="{http://www.tibco.com/schemas/CRM-Billing/SharedResources/XSD/Base/Imported/Schema.xsd}TransactionInfo"/>
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
    "authInfo",
    "transInfo",
    "paymentInfo",
    "bankInfo",
    "transactionInfo"
})
@XmlRootElement(name = "createPaymentByBillRequest")
public class CreatePaymentByBillRequest {

    @XmlElement(required = true)
    protected AuthInfo authInfo;
    @XmlElement(required = true)
    protected com.tibco.schemas.crm_billingbizservices.sharedresources.xsd.schema.TransactionInfo transInfo;
    @XmlElement(name = "PaymentInfo", required = true)
    protected PaymentInfo paymentInfo;
    @XmlElement(name = "BankInfo", required = true)
    protected BankInfo bankInfo;
    @XmlElement(name = "TransactionInfo", required = true)
    protected com.tibco.schemas.crm_billing.sharedresources.xsd.base.imported.schema.TransactionInfo transactionInfo;

    /**
     * Gets the value of the authInfo property.
     * 
     * @return
     *     possible object is
     *     {@link AuthInfo }
     *     
     */
    public AuthInfo getAuthInfo() {
        return authInfo;
    }

    /**
     * Sets the value of the authInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link AuthInfo }
     *     
     */
    public void setAuthInfo(AuthInfo value) {
        this.authInfo = value;
    }

    /**
     * Gets the value of the transInfo property.
     * 
     * @return
     *     possible object is
     *     {@link com.tibco.schemas.crm_billingbizservices.sharedresources.xsd.schema.TransactionInfo }
     *     
     */
    public com.tibco.schemas.crm_billingbizservices.sharedresources.xsd.schema.TransactionInfo getTransInfo() {
        return transInfo;
    }

    /**
     * Sets the value of the transInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link com.tibco.schemas.crm_billingbizservices.sharedresources.xsd.schema.TransactionInfo }
     *     
     */
    public void setTransInfo(com.tibco.schemas.crm_billingbizservices.sharedresources.xsd.schema.TransactionInfo value) {
        this.transInfo = value;
    }

    /**
     * Gets the value of the paymentInfo property.
     * 
     * @return
     *     possible object is
     *     {@link PaymentInfo }
     *     
     */
    public PaymentInfo getPaymentInfo() {
        return paymentInfo;
    }

    /**
     * Sets the value of the paymentInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentInfo }
     *     
     */
    public void setPaymentInfo(PaymentInfo value) {
        this.paymentInfo = value;
    }

    /**
     * Gets the value of the bankInfo property.
     * 
     * @return
     *     possible object is
     *     {@link BankInfo }
     *     
     */
    public BankInfo getBankInfo() {
        return bankInfo;
    }

    /**
     * Sets the value of the bankInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link BankInfo }
     *     
     */
    public void setBankInfo(BankInfo value) {
        this.bankInfo = value;
    }

    /**
     * Gets the value of the transactionInfo property.
     * 
     * @return
     *     possible object is
     *     {@link com.tibco.schemas.crm_billing.sharedresources.xsd.base.imported.schema.TransactionInfo }
     *     
     */
    public com.tibco.schemas.crm_billing.sharedresources.xsd.base.imported.schema.TransactionInfo getTransactionInfo() {
        return transactionInfo;
    }

    /**
     * Sets the value of the transactionInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link com.tibco.schemas.crm_billing.sharedresources.xsd.base.imported.schema.TransactionInfo }
     *     
     */
    public void setTransactionInfo(com.tibco.schemas.crm_billing.sharedresources.xsd.base.imported.schema.TransactionInfo value) {
        this.transactionInfo = value;
    }

}
