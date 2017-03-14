package com.fet.crm.smarthome.device.service;

import com.fet.crm.smarthome.generic.bean.CustomerVO;
import com.fet.crm.smarthome.generic.model.UserProfile;
import com.fet.crm.smarthome.generic.util.BusinessException;

/**
 * Customer service
 * 
 * @author Paul Chan
 * @version 1.0.0.0
 */
public interface SIGCustomerService {

    UserProfile getUserProfile(String cspUser) throws BusinessException;

    /**
     * 呼叫API以門號取得：顧客編號（customerId）、付款帳號（accountId）、用戶編號（subscriberId）及門號產品別
     * （KGT/FET）資訊。
     * 
     * @param msisdn
     *            the msisdn
     * 
     * @return the CustomerVO
     * 
     * @throws Exception
     *             the exception
     */
    CustomerVO getSubscriberIdByMsisdn(final String msisdn) throws BusinessException;

}
