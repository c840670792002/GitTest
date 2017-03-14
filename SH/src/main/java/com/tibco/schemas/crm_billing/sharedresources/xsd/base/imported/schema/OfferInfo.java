
package com.tibco.schemas.crm_billing.sharedresources.xsd.base.imported.schema;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for OfferInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OfferInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="agreementNo" type="{http://www.tibco.com/schemas/CRM-Billing/SharedResources/XSD/Base/Imported/Schema.xsd}AgreementNoInfo" minOccurs="0"/>
 *         &lt;element name="businessEntityNo" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="cm9AgrPromoMasterList" type="{http://www.tibco.com/schemas/CRM-Billing/SharedResources/XSD/Base/Imported/Schema.xsd}ArrayOfCm9AgrPromoMaster" minOccurs="0"/>
 *         &lt;element name="currency" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="description" type="{http://www.tibco.com/schemas/CRM-Billing/SharedResources/XSD/Base/Imported/Schema.xsd}Description" minOccurs="0"/>
 *         &lt;element name="discountPlan" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="l9FutureExpirationDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="l9OrigEffDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="maxInstancesAllowed" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="offerCharge" type="{http://www.tibco.com/schemas/CRM-Billing/SharedResources/XSD/Base/Imported/Schema.xsd}Money" minOccurs="0"/>
 *         &lt;element name="offerCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="offerDiscount" type="{http://www.tibco.com/schemas/CRM-Billing/SharedResources/XSD/Base/Imported/Schema.xsd}OfferDiscountInfo" minOccurs="0"/>
 *         &lt;element name="offerInstanceId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="offerName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="offerType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="parameterList" type="{http://www.tibco.com/schemas/CRM-Billing/SharedResources/XSD/Base/Imported/Schema.xsd}ArrayOfParameterInfo" minOccurs="0"/>
 *         &lt;element name="productType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="serviceLevel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="spcode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="validDuration" type="{http://www.tibco.com/schemas/CRM-Billing/SharedResources/XSD/Base/Imported/Schema.xsd}ValidTimePeriod" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OfferInfo", propOrder = {
    "agreementNo",
    "businessEntityNo",
    "cm9AgrPromoMasterList",
    "currency",
    "description",
    "discountPlan",
    "l9FutureExpirationDate",
    "l9OrigEffDate",
    "maxInstancesAllowed",
    "offerCharge",
    "offerCode",
    "offerDiscount",
    "offerInstanceId",
    "offerName",
    "offerType",
    "parameterList",
    "productType",
    "serviceLevel",
    "spcode",
    "validDuration"
})
public class OfferInfo {

    @XmlElementRef(name = "agreementNo", namespace = "http://www.tibco.com/schemas/CRM-Billing/SharedResources/XSD/Base/Imported/Schema.xsd", type = JAXBElement.class)
    protected JAXBElement<AgreementNoInfo> agreementNo;
    @XmlElementRef(name = "businessEntityNo", namespace = "http://www.tibco.com/schemas/CRM-Billing/SharedResources/XSD/Base/Imported/Schema.xsd", type = JAXBElement.class)
    protected JAXBElement<Integer> businessEntityNo;
    @XmlElementRef(name = "cm9AgrPromoMasterList", namespace = "http://www.tibco.com/schemas/CRM-Billing/SharedResources/XSD/Base/Imported/Schema.xsd", type = JAXBElement.class)
    protected JAXBElement<ArrayOfCm9AgrPromoMaster> cm9AgrPromoMasterList;
    @XmlElementRef(name = "currency", namespace = "http://www.tibco.com/schemas/CRM-Billing/SharedResources/XSD/Base/Imported/Schema.xsd", type = JAXBElement.class)
    protected JAXBElement<String> currency;
    @XmlElementRef(name = "description", namespace = "http://www.tibco.com/schemas/CRM-Billing/SharedResources/XSD/Base/Imported/Schema.xsd", type = JAXBElement.class)
    protected JAXBElement<Description> description;
    @XmlElementRef(name = "discountPlan", namespace = "http://www.tibco.com/schemas/CRM-Billing/SharedResources/XSD/Base/Imported/Schema.xsd", type = JAXBElement.class)
    protected JAXBElement<String> discountPlan;
    @XmlElementRef(name = "l9FutureExpirationDate", namespace = "http://www.tibco.com/schemas/CRM-Billing/SharedResources/XSD/Base/Imported/Schema.xsd", type = JAXBElement.class)
    protected JAXBElement<XMLGregorianCalendar> l9FutureExpirationDate;
    @XmlElementRef(name = "l9OrigEffDate", namespace = "http://www.tibco.com/schemas/CRM-Billing/SharedResources/XSD/Base/Imported/Schema.xsd", type = JAXBElement.class)
    protected JAXBElement<XMLGregorianCalendar> l9OrigEffDate;
    @XmlElementRef(name = "maxInstancesAllowed", namespace = "http://www.tibco.com/schemas/CRM-Billing/SharedResources/XSD/Base/Imported/Schema.xsd", type = JAXBElement.class)
    protected JAXBElement<Integer> maxInstancesAllowed;
    @XmlElementRef(name = "offerCharge", namespace = "http://www.tibco.com/schemas/CRM-Billing/SharedResources/XSD/Base/Imported/Schema.xsd", type = JAXBElement.class)
    protected JAXBElement<Money> offerCharge;
    @XmlElementRef(name = "offerCode", namespace = "http://www.tibco.com/schemas/CRM-Billing/SharedResources/XSD/Base/Imported/Schema.xsd", type = JAXBElement.class)
    protected JAXBElement<String> offerCode;
    @XmlElementRef(name = "offerDiscount", namespace = "http://www.tibco.com/schemas/CRM-Billing/SharedResources/XSD/Base/Imported/Schema.xsd", type = JAXBElement.class)
    protected JAXBElement<OfferDiscountInfo> offerDiscount;
    @XmlElementRef(name = "offerInstanceId", namespace = "http://www.tibco.com/schemas/CRM-Billing/SharedResources/XSD/Base/Imported/Schema.xsd", type = JAXBElement.class)
    protected JAXBElement<String> offerInstanceId;
    @XmlElementRef(name = "offerName", namespace = "http://www.tibco.com/schemas/CRM-Billing/SharedResources/XSD/Base/Imported/Schema.xsd", type = JAXBElement.class)
    protected JAXBElement<String> offerName;
    @XmlElementRef(name = "offerType", namespace = "http://www.tibco.com/schemas/CRM-Billing/SharedResources/XSD/Base/Imported/Schema.xsd", type = JAXBElement.class)
    protected JAXBElement<String> offerType;
    @XmlElementRef(name = "parameterList", namespace = "http://www.tibco.com/schemas/CRM-Billing/SharedResources/XSD/Base/Imported/Schema.xsd", type = JAXBElement.class)
    protected JAXBElement<ArrayOfParameterInfo> parameterList;
    @XmlElementRef(name = "productType", namespace = "http://www.tibco.com/schemas/CRM-Billing/SharedResources/XSD/Base/Imported/Schema.xsd", type = JAXBElement.class)
    protected JAXBElement<String> productType;
    @XmlElementRef(name = "serviceLevel", namespace = "http://www.tibco.com/schemas/CRM-Billing/SharedResources/XSD/Base/Imported/Schema.xsd", type = JAXBElement.class)
    protected JAXBElement<String> serviceLevel;
    @XmlElementRef(name = "spcode", namespace = "http://www.tibco.com/schemas/CRM-Billing/SharedResources/XSD/Base/Imported/Schema.xsd", type = JAXBElement.class)
    protected JAXBElement<String> spcode;
    @XmlElementRef(name = "validDuration", namespace = "http://www.tibco.com/schemas/CRM-Billing/SharedResources/XSD/Base/Imported/Schema.xsd", type = JAXBElement.class)
    protected JAXBElement<ValidTimePeriod> validDuration;

    /**
     * Gets the value of the agreementNo property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link AgreementNoInfo }{@code >}
     *     
     */
    public JAXBElement<AgreementNoInfo> getAgreementNo() {
        return agreementNo;
    }

    /**
     * Sets the value of the agreementNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link AgreementNoInfo }{@code >}
     *     
     */
    public void setAgreementNo(JAXBElement<AgreementNoInfo> value) {
        this.agreementNo = value;
    }

    /**
     * Gets the value of the businessEntityNo property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public JAXBElement<Integer> getBusinessEntityNo() {
        return businessEntityNo;
    }

    /**
     * Sets the value of the businessEntityNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public void setBusinessEntityNo(JAXBElement<Integer> value) {
        this.businessEntityNo = value;
    }

    /**
     * Gets the value of the cm9AgrPromoMasterList property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfCm9AgrPromoMaster }{@code >}
     *     
     */
    public JAXBElement<ArrayOfCm9AgrPromoMaster> getCm9AgrPromoMasterList() {
        return cm9AgrPromoMasterList;
    }

    /**
     * Sets the value of the cm9AgrPromoMasterList property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfCm9AgrPromoMaster }{@code >}
     *     
     */
    public void setCm9AgrPromoMasterList(JAXBElement<ArrayOfCm9AgrPromoMaster> value) {
        this.cm9AgrPromoMasterList = value;
    }

    /**
     * Gets the value of the currency property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCurrency() {
        return currency;
    }

    /**
     * Sets the value of the currency property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCurrency(JAXBElement<String> value) {
        this.currency = value;
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
     * Gets the value of the discountPlan property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDiscountPlan() {
        return discountPlan;
    }

    /**
     * Sets the value of the discountPlan property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDiscountPlan(JAXBElement<String> value) {
        this.discountPlan = value;
    }

    /**
     * Gets the value of the l9FutureExpirationDate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getL9FutureExpirationDate() {
        return l9FutureExpirationDate;
    }

    /**
     * Sets the value of the l9FutureExpirationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setL9FutureExpirationDate(JAXBElement<XMLGregorianCalendar> value) {
        this.l9FutureExpirationDate = value;
    }

    /**
     * Gets the value of the l9OrigEffDate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getL9OrigEffDate() {
        return l9OrigEffDate;
    }

    /**
     * Sets the value of the l9OrigEffDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setL9OrigEffDate(JAXBElement<XMLGregorianCalendar> value) {
        this.l9OrigEffDate = value;
    }

    /**
     * Gets the value of the maxInstancesAllowed property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public JAXBElement<Integer> getMaxInstancesAllowed() {
        return maxInstancesAllowed;
    }

    /**
     * Sets the value of the maxInstancesAllowed property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public void setMaxInstancesAllowed(JAXBElement<Integer> value) {
        this.maxInstancesAllowed = value;
    }

    /**
     * Gets the value of the offerCharge property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Money }{@code >}
     *     
     */
    public JAXBElement<Money> getOfferCharge() {
        return offerCharge;
    }

    /**
     * Sets the value of the offerCharge property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Money }{@code >}
     *     
     */
    public void setOfferCharge(JAXBElement<Money> value) {
        this.offerCharge = value;
    }

    /**
     * Gets the value of the offerCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOfferCode() {
        return offerCode;
    }

    /**
     * Sets the value of the offerCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOfferCode(JAXBElement<String> value) {
        this.offerCode = value;
    }

    /**
     * Gets the value of the offerDiscount property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link OfferDiscountInfo }{@code >}
     *     
     */
    public JAXBElement<OfferDiscountInfo> getOfferDiscount() {
        return offerDiscount;
    }

    /**
     * Sets the value of the offerDiscount property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link OfferDiscountInfo }{@code >}
     *     
     */
    public void setOfferDiscount(JAXBElement<OfferDiscountInfo> value) {
        this.offerDiscount = value;
    }

    /**
     * Gets the value of the offerInstanceId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOfferInstanceId() {
        return offerInstanceId;
    }

    /**
     * Sets the value of the offerInstanceId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOfferInstanceId(JAXBElement<String> value) {
        this.offerInstanceId = value;
    }

    /**
     * Gets the value of the offerName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOfferName() {
        return offerName;
    }

    /**
     * Sets the value of the offerName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOfferName(JAXBElement<String> value) {
        this.offerName = value;
    }

    /**
     * Gets the value of the offerType property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOfferType() {
        return offerType;
    }

    /**
     * Sets the value of the offerType property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOfferType(JAXBElement<String> value) {
        this.offerType = value;
    }

    /**
     * Gets the value of the parameterList property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfParameterInfo }{@code >}
     *     
     */
    public JAXBElement<ArrayOfParameterInfo> getParameterList() {
        return parameterList;
    }

    /**
     * Sets the value of the parameterList property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfParameterInfo }{@code >}
     *     
     */
    public void setParameterList(JAXBElement<ArrayOfParameterInfo> value) {
        this.parameterList = value;
    }

    /**
     * Gets the value of the productType property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getProductType() {
        return productType;
    }

    /**
     * Sets the value of the productType property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setProductType(JAXBElement<String> value) {
        this.productType = value;
    }

    /**
     * Gets the value of the serviceLevel property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getServiceLevel() {
        return serviceLevel;
    }

    /**
     * Sets the value of the serviceLevel property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setServiceLevel(JAXBElement<String> value) {
        this.serviceLevel = value;
    }

    /**
     * Gets the value of the spcode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSpcode() {
        return spcode;
    }

    /**
     * Sets the value of the spcode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSpcode(JAXBElement<String> value) {
        this.spcode = value;
    }

    /**
     * Gets the value of the validDuration property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ValidTimePeriod }{@code >}
     *     
     */
    public JAXBElement<ValidTimePeriod> getValidDuration() {
        return validDuration;
    }

    /**
     * Sets the value of the validDuration property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ValidTimePeriod }{@code >}
     *     
     */
    public void setValidDuration(JAXBElement<ValidTimePeriod> value) {
        this.validDuration = value;
    }

}
