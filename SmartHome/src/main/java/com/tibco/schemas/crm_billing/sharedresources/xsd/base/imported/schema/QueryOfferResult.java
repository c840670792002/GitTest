
package com.tibco.schemas.crm_billing.sharedresources.xsd.base.imported.schema;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for QueryOfferResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="QueryOfferResult">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.tibco.com/schemas/CRM-Billing/SharedResources/XSD/Base/Imported/Schema.xsd}AbstractProcessResult">
 *       &lt;sequence>
 *         &lt;element name="beInfo" type="{http://www.tibco.com/schemas/CRM-Billing/SharedResources/XSD/Base/Imported/Schema.xsd}BusinessEntityInfo" minOccurs="0"/>
 *         &lt;element name="offerList" type="{http://www.tibco.com/schemas/CRM-Billing/SharedResources/XSD/Base/Imported/Schema.xsd}ArrayOfOfferInfo" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "QueryOfferResult", propOrder = {
    "beInfo",
    "offerList"
})
public class QueryOfferResult
    extends AbstractProcessResult
{

    @XmlElementRef(name = "beInfo", namespace = "http://www.tibco.com/schemas/CRM-Billing/SharedResources/XSD/Base/Imported/Schema.xsd", type = JAXBElement.class)
    protected JAXBElement<BusinessEntityInfo> beInfo;
    @XmlElementRef(name = "offerList", namespace = "http://www.tibco.com/schemas/CRM-Billing/SharedResources/XSD/Base/Imported/Schema.xsd", type = JAXBElement.class)
    protected JAXBElement<ArrayOfOfferInfo> offerList;

    /**
     * Gets the value of the beInfo property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BusinessEntityInfo }{@code >}
     *     
     */
    public JAXBElement<BusinessEntityInfo> getBeInfo() {
        return beInfo;
    }

    /**
     * Sets the value of the beInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BusinessEntityInfo }{@code >}
     *     
     */
    public void setBeInfo(JAXBElement<BusinessEntityInfo> value) {
        this.beInfo = value;
    }

    /**
     * Gets the value of the offerList property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfOfferInfo }{@code >}
     *     
     */
    public JAXBElement<ArrayOfOfferInfo> getOfferList() {
        return offerList;
    }

    /**
     * Sets the value of the offerList property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfOfferInfo }{@code >}
     *     
     */
    public void setOfferList(JAXBElement<ArrayOfOfferInfo> value) {
        this.offerList = value;
    }

}
