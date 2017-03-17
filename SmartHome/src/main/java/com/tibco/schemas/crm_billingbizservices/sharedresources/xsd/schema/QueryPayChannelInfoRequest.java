
package com.tibco.schemas.crm_billingbizservices.sharedresources.xsd.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.tibco.schemas.crm_billing.sharedresources.xsd.base.imported.schema.BusinessEntityInfo;
import com.tibco.schemas.crm_billing.sharedresources.xsd.base.imported.schema.PayChannelNoInfo;
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
 *         &lt;element name="beInfo" type="{http://www.tibco.com/schemas/CRM-Billing/SharedResources/XSD/Base/Imported/Schema.xsd}BusinessEntityInfo"/>
 *         &lt;element name="payChannelNo" type="{http://www.tibco.com/schemas/CRM-Billing/SharedResources/XSD/Base/Imported/Schema.xsd}PayChannelNoInfo"/>
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
    "beInfo",
    "payChannelNo"
})
@XmlRootElement(name = "queryPayChannelInfoRequest")
public class QueryPayChannelInfoRequest {

    @XmlElement(required = true)
    protected AuthInfo authInfo;
    @XmlElement(required = true)
    protected TransactionInfo transInfo;
    @XmlElement(required = true)
    protected BusinessEntityInfo beInfo;
    @XmlElement(required = true)
    protected PayChannelNoInfo payChannelNo;

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
     *     {@link TransactionInfo }
     *     
     */
    public TransactionInfo getTransInfo() {
        return transInfo;
    }

    /**
     * Sets the value of the transInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link TransactionInfo }
     *     
     */
    public void setTransInfo(TransactionInfo value) {
        this.transInfo = value;
    }

    /**
     * Gets the value of the beInfo property.
     * 
     * @return
     *     possible object is
     *     {@link BusinessEntityInfo }
     *     
     */
    public BusinessEntityInfo getBeInfo() {
        return beInfo;
    }

    /**
     * Sets the value of the beInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link BusinessEntityInfo }
     *     
     */
    public void setBeInfo(BusinessEntityInfo value) {
        this.beInfo = value;
    }

    /**
     * Gets the value of the payChannelNo property.
     * 
     * @return
     *     possible object is
     *     {@link PayChannelNoInfo }
     *     
     */
    public PayChannelNoInfo getPayChannelNo() {
        return payChannelNo;
    }

    /**
     * Sets the value of the payChannelNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link PayChannelNoInfo }
     *     
     */
    public void setPayChannelNo(PayChannelNoInfo value) {
        this.payChannelNo = value;
    }

}
