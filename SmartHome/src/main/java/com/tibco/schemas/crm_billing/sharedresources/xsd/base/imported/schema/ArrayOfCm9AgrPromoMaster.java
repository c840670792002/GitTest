
package com.tibco.schemas.crm_billing.sharedresources.xsd.base.imported.schema;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfCm9AgrPromoMaster complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfCm9AgrPromoMaster">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Cm9AgrPromoMaster" type="{http://www.tibco.com/schemas/CRM-Billing/SharedResources/XSD/Base/Imported/Schema.xsd}Cm9AgrPromoMaster" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfCm9AgrPromoMaster", propOrder = {
    "cm9AgrPromoMaster"
})
public class ArrayOfCm9AgrPromoMaster {

    @XmlElement(name = "Cm9AgrPromoMaster", nillable = true)
    protected List<Cm9AgrPromoMaster> cm9AgrPromoMaster;

    /**
     * Gets the value of the cm9AgrPromoMaster property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cm9AgrPromoMaster property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCm9AgrPromoMaster().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Cm9AgrPromoMaster }
     * 
     * 
     */
    public List<Cm9AgrPromoMaster> getCm9AgrPromoMaster() {
        if (cm9AgrPromoMaster == null) {
            cm9AgrPromoMaster = new ArrayList<Cm9AgrPromoMaster>();
        }
        return this.cm9AgrPromoMaster;
    }

}
