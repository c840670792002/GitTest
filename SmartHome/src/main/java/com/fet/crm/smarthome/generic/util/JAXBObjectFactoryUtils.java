package com.fet.crm.smarthome.generic.util;

/**
 * DOCUMENT ME!
 * 
 * @author Paul Chan
 * @version 1.0.0.0
 */
public final class JAXBObjectFactoryUtils {
    private JAXBObjectFactoryUtils() {
    }

    /**
     * DOCUMENT ME!
     * 
     * @return DOCUMENT ME!
     */
    public static tw.com.fet.itsoa.schemas.common_domain.sharedresources.xsd.base.schema.ObjectFactory getCommonObjectFactory() {
        return new tw.com.fet.itsoa.schemas.common_domain.sharedresources.xsd.base.schema.ObjectFactory();
    }

    public static com.tibco.schemas.crm_billing.sharedresources.xsd.base.imported.schema.ObjectFactory getBillingObjectFactory() {
        return new com.tibco.schemas.crm_billing.sharedresources.xsd.base.imported.schema.ObjectFactory();
    }

    public static com.tibco.schemas.crm_billingbizservices.sharedresources.xsd.schema.ObjectFactory getBillingServiceObjectFactory() {
        return new com.tibco.schemas.crm_billingbizservices.sharedresources.xsd.schema.ObjectFactory();
    }
}
