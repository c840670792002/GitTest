
package com.tibco.schemas.crm_billingbizservices.sharedresources.xsd.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.tibco.schemas.crm_billing.sharedresources.xsd.base.imported.schema.QueryOfferResult;
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
 *         &lt;element name="queryOfferResult" type="{http://www.tibco.com/schemas/CRM-Billing/SharedResources/XSD/Base/Imported/Schema.xsd}QueryOfferResult"/>
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
    "queryOfferResult"
})
@XmlRootElement(name = "queryOfferListResponse")
public class QueryOfferListResponse {

    @XmlElement(required = true)
    protected ReturnHeader returnHeader;
    @XmlElement(required = true)
    protected QueryOfferResult queryOfferResult;

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
     * Gets the value of the queryOfferResult property.
     * 
     * @return
     *     possible object is
     *     {@link QueryOfferResult }
     *     
     */
    public QueryOfferResult getQueryOfferResult() {
        return queryOfferResult;
    }

    /**
     * Sets the value of the queryOfferResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link QueryOfferResult }
     *     
     */
    public void setQueryOfferResult(QueryOfferResult value) {
        this.queryOfferResult = value;
    }

}
