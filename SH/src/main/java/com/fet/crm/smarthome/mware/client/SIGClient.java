package com.fet.crm.smarthome.mware.client;

import com.fet.crm.smarthome.generic.util.BusinessException;
import com.fet.siggw.vo.MsisdnKeysVo;

/**
 * 呼叫 SIG 之 client
 * 
 * @author Paul Chan
 * @version 1.0.0.0
 */
public interface SIGClient {

    /**
     * 呼叫API以門號取得：顧客編號（customerId）、付款帳號（accountId）、用戶編號（subscriberId）及門號產品別
     * （KGT/FET）資訊。
     * 
     * @param msisdn
     *            the msisdn
     * 
     * @return the MsisdnKeysVo
     * 
     * @throws BusinessException
     *             the exception
     */
    MsisdnKeysVo retvKeysByMsisdn(final String msisdn) throws BusinessException;

}
