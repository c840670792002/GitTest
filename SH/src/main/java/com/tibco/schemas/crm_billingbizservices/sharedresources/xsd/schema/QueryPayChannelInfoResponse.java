
package com.tibco.schemas.crm_billingbizservices.sharedresources.xsd.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.tibco.schemas.crm_billing.sharedresources.xsd.base.imported.schema.PayChannelInfo;
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
 *         &lt;element name="payChannel" type="{http://www.tibco.com/schemas/CRM-Billing/SharedResources/XSD/Base/Imported/Schema.xsd}PayChannelInfo" minOccurs="0"/>
 *         &lt;element name="status" type="{http://www.tibco.com/schemas/CRM-BillingBizServices/SharedResources/XSD/Schema.xsd}ProcessStatus" minOccurs="0"/>
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
    "payChannel",
    "status"
})
@XmlRootElement(name = "queryPayChannelInfoResponse")
public class QueryPayChannelInfoResponse {

    @XmlElement(required = true)
    protected ReturnHeader returnHeader;
    protected PayChannelInfo payChannel;
    protected ProcessStatus status;

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
     * Gets the value of the payChannel property.
     * 
     * @return
     *     possible object is
     *     {@link PayChannelInfo }
     *     
     */
    public PayChannelInfo getPayChannel() {
        return payChannel;
    }

    /**
     * Sets the value of the payChannel property.
     * 
     * @param value
     *     allowed object is
     *     {@link PayChannelInfo }
     *     
     */
    public void setPayChannel(PayChannelInfo value) {
        this.payChannel = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link ProcessStatus }
     *     
     */
    public ProcessStatus getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProcessStatus }
     *     
     */
    public void setStatus(ProcessStatus value) {
        this.status = value;
    }

}
