
package com.tibco.schemas.crm_billing.sharedresources.xsd.base.imported.schema;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for PaymentInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PaymentInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="IsPayByFocusedMethod">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;length value="1"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="IsPaymentBasic" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="TotalAmount" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="PaymentDetailInfos" type="{http://www.tibco.com/schemas/CRM-Billing/SharedResources/XSD/Base/Imported/Schema.xsd}PaymentDetailInfos" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="operatorId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="activityType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="storeNum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="externalSysKey" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="unHotline" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="nonCollection" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="paymentDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PaymentInfo", propOrder = {
    "isPayByFocusedMethod",
    "isPaymentBasic",
    "totalAmount",
    "paymentDetailInfos",
    "operatorId",
    "activityType",
    "storeNum",
    "externalSysKey",
    "unHotline",
    "nonCollection",
    "paymentDate"
})
public class PaymentInfo {

    @XmlElement(name = "IsPayByFocusedMethod", required = true)
    protected String isPayByFocusedMethod;
    @XmlElement(name = "IsPaymentBasic", required = true)
    protected String isPaymentBasic;
    @XmlElement(name = "TotalAmount")
    protected double totalAmount;
    @XmlElement(name = "PaymentDetailInfos")
    protected List<PaymentDetailInfos> paymentDetailInfos;
    protected String operatorId;
    @XmlElement(required = true)
    protected String activityType;
    protected String storeNum;
    protected String externalSysKey;
    @XmlElement(required = true)
    protected String unHotline;
    @XmlElement(required = true)
    protected String nonCollection;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar paymentDate;

    /**
     * Gets the value of the isPayByFocusedMethod property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsPayByFocusedMethod() {
        return isPayByFocusedMethod;
    }

    /**
     * Sets the value of the isPayByFocusedMethod property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsPayByFocusedMethod(String value) {
        this.isPayByFocusedMethod = value;
    }

    /**
     * Gets the value of the isPaymentBasic property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsPaymentBasic() {
        return isPaymentBasic;
    }

    /**
     * Sets the value of the isPaymentBasic property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsPaymentBasic(String value) {
        this.isPaymentBasic = value;
    }

    /**
     * Gets the value of the totalAmount property.
     * 
     */
    public double getTotalAmount() {
        return totalAmount;
    }

    /**
     * Sets the value of the totalAmount property.
     * 
     */
    public void setTotalAmount(double value) {
        this.totalAmount = value;
    }

    /**
     * Gets the value of the paymentDetailInfos property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the paymentDetailInfos property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPaymentDetailInfos().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PaymentDetailInfos }
     * 
     * 
     */
    public List<PaymentDetailInfos> getPaymentDetailInfos() {
        if (paymentDetailInfos == null) {
            paymentDetailInfos = new ArrayList<PaymentDetailInfos>();
        }
        return this.paymentDetailInfos;
    }

    /**
     * Gets the value of the operatorId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOperatorId() {
        return operatorId;
    }

    /**
     * Sets the value of the operatorId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOperatorId(String value) {
        this.operatorId = value;
    }

    /**
     * Gets the value of the activityType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getActivityType() {
        return activityType;
    }

    /**
     * Sets the value of the activityType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setActivityType(String value) {
        this.activityType = value;
    }

    /**
     * Gets the value of the storeNum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStoreNum() {
        return storeNum;
    }

    /**
     * Sets the value of the storeNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStoreNum(String value) {
        this.storeNum = value;
    }

    /**
     * Gets the value of the externalSysKey property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExternalSysKey() {
        return externalSysKey;
    }

    /**
     * Sets the value of the externalSysKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExternalSysKey(String value) {
        this.externalSysKey = value;
    }

    /**
     * Gets the value of the unHotline property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUnHotline() {
        return unHotline;
    }

    /**
     * Sets the value of the unHotline property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUnHotline(String value) {
        this.unHotline = value;
    }

    /**
     * Gets the value of the nonCollection property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNonCollection() {
        return nonCollection;
    }

    /**
     * Sets the value of the nonCollection property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNonCollection(String value) {
        this.nonCollection = value;
    }

    /**
     * Gets the value of the paymentDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getPaymentDate() {
        return paymentDate;
    }

    /**
     * Sets the value of the paymentDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setPaymentDate(XMLGregorianCalendar value) {
        this.paymentDate = value;
    }

}
