
package com.tibco.schemas.crm_billingbizservices.sharedresources.xsd.schema;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.tibco.schemas.crm_billingbizservices.sharedresources.xsd.schema package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _TransactionInfoTransSubChannel_QNAME = new QName("http://www.tibco.com/schemas/CRM-BillingBizServices/SharedResources/XSD/Schema.xsd", "transSubChannel");
    private final static QName _ProcessStatusProcessName_QNAME = new QName("http://www.tibco.com/schemas/CRM-BillingBizServices/SharedResources/XSD/Schema.xsd", "processName");
    private final static QName _ProcessStatusErrorCode_QNAME = new QName("http://www.tibco.com/schemas/CRM-BillingBizServices/SharedResources/XSD/Schema.xsd", "errorCode");
    private final static QName _ProcessStatusStatus_QNAME = new QName("http://www.tibco.com/schemas/CRM-BillingBizServices/SharedResources/XSD/Schema.xsd", "status");
    private final static QName _ProcessStatusProcessId_QNAME = new QName("http://www.tibco.com/schemas/CRM-BillingBizServices/SharedResources/XSD/Schema.xsd", "processId");
    private final static QName _ProcessStatusCurrentTask_QNAME = new QName("http://www.tibco.com/schemas/CRM-BillingBizServices/SharedResources/XSD/Schema.xsd", "currentTask");
    private final static QName _ProcessStatusMessage_QNAME = new QName("http://www.tibco.com/schemas/CRM-BillingBizServices/SharedResources/XSD/Schema.xsd", "message");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.tibco.schemas.crm_billingbizservices.sharedresources.xsd.schema
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link QueryOfferListResponse }
     * 
     */
    public QueryOfferListResponse createQueryOfferListResponse() {
        return new QueryOfferListResponse();
    }

    /**
     * Create an instance of {@link QueryOfferListRequest }
     * 
     */
    public QueryOfferListRequest createQueryOfferListRequest() {
        return new QueryOfferListRequest();
    }

    /**
     * Create an instance of {@link TransactionInfo }
     * 
     */
    public TransactionInfo createTransactionInfo() {
        return new TransactionInfo();
    }

    /**
     * Create an instance of {@link ProcessStatus }
     * 
     */
    public ProcessStatus createProcessStatus() {
        return new ProcessStatus();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tibco.com/schemas/CRM-BillingBizServices/SharedResources/XSD/Schema.xsd", name = "transSubChannel", scope = TransactionInfo.class)
    public JAXBElement<String> createTransactionInfoTransSubChannel(String value) {
        return new JAXBElement<String>(_TransactionInfoTransSubChannel_QNAME, String.class, TransactionInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tibco.com/schemas/CRM-BillingBizServices/SharedResources/XSD/Schema.xsd", name = "processName", scope = ProcessStatus.class)
    public JAXBElement<String> createProcessStatusProcessName(String value) {
        return new JAXBElement<String>(_ProcessStatusProcessName_QNAME, String.class, ProcessStatus.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tibco.com/schemas/CRM-BillingBizServices/SharedResources/XSD/Schema.xsd", name = "errorCode", scope = ProcessStatus.class)
    public JAXBElement<String> createProcessStatusErrorCode(String value) {
        return new JAXBElement<String>(_ProcessStatusErrorCode_QNAME, String.class, ProcessStatus.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tibco.com/schemas/CRM-BillingBizServices/SharedResources/XSD/Schema.xsd", name = "status", scope = ProcessStatus.class)
    public JAXBElement<String> createProcessStatusStatus(String value) {
        return new JAXBElement<String>(_ProcessStatusStatus_QNAME, String.class, ProcessStatus.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tibco.com/schemas/CRM-BillingBizServices/SharedResources/XSD/Schema.xsd", name = "processId", scope = ProcessStatus.class)
    public JAXBElement<String> createProcessStatusProcessId(String value) {
        return new JAXBElement<String>(_ProcessStatusProcessId_QNAME, String.class, ProcessStatus.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tibco.com/schemas/CRM-BillingBizServices/SharedResources/XSD/Schema.xsd", name = "currentTask", scope = ProcessStatus.class)
    public JAXBElement<String> createProcessStatusCurrentTask(String value) {
        return new JAXBElement<String>(_ProcessStatusCurrentTask_QNAME, String.class, ProcessStatus.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tibco.com/schemas/CRM-BillingBizServices/SharedResources/XSD/Schema.xsd", name = "message", scope = ProcessStatus.class)
    public JAXBElement<String> createProcessStatusMessage(String value) {
        return new JAXBElement<String>(_ProcessStatusMessage_QNAME, String.class, ProcessStatus.class, value);
    }

}
