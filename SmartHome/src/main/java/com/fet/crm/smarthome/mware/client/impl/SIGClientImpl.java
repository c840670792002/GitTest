package com.fet.crm.smarthome.mware.client.impl;

import com.fet.crm.smarthome.generic.util.BusinessException;
import com.fet.crm.smarthome.generic.util.MessageUtil;
import com.fet.crm.smarthome.generic.util.SmartHomeConstants;
import com.fet.crm.smarthome.generic.util.UserUtil;
import com.fet.crm.smarthome.mware.client.SIGClient;
import com.fet.generic.logger.ILogger;
import com.fet.generic.logger.LoggerFactory;
import com.fet.siggw.facade.SearchFacade;
import com.fet.siggw.vo.MsisdnKeysVo;
import com.fet.siggw.vo.SGWReturn;

import java.util.Date;

import org.apache.commons.lang.StringUtils;

/**
 * 呼叫 SIG 之 client
 * 
 * @author Paul Chan
 * @version 1.0.0.0
 */
public class SIGClientImpl implements SIGClient {
    private static final ILogger LOG = LoggerFactory.getLogger(SIGClientImpl.class);
    private transient SearchFacade searchFacade;

    /**
     * DOCUMENT ME!
     * 
     * @param searchFacade
     *            DOCUMENT ME!
     */
    public void setSearchFacade(final SearchFacade searchFacade) {
        this.searchFacade = searchFacade;
    }

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
    public MsisdnKeysVo retvKeysByMsisdn(final String msisdn) throws BusinessException {
//        LOG.info("==============ResourceService.retvKeysByMsisdn Start ("
//                + StringUtils.defaultString(msisdn, SmartHomeConstants.NULL) + ")==============");
        String errorMsg;
        MsisdnKeysVo vo = null;
        try {
            // BizEntity固定寫死為FET以加速SIG的運算速度(實測快0.5秒) 20120924
//            LOG.info("==============SIG searchFacade.retvKeysByMsisdn Start ("
//                    + StringUtils.defaultString(msisdn, SmartHomeConstants.NULL) + ")==============");
            final Date startTime = new Date();
            
            LOG.info(
                    "MSISDN:"+msisdn+"\n"+
                    "UserIDF : " + MessageUtil.getStringMessage("user.id.f")+"\n"+
                    "ChannelF : " + MessageUtil.getStringMessage("user.channel.f")+"\n"+
                    "UserNameF : " + MessageUtil.getStringMessage("user.name.f")+"\n"+
                    "UserNameK : " + MessageUtil.getStringMessage("user.name.k")+"\n"+
                    "PasswordF : " + MessageUtil.getStringMessage("user.password.f")+"\n"+
                    "PasswordK : " + MessageUtil.getStringMessage("user.password.k")
                    );

            final SGWReturn sgwReturn = searchFacade.retvKeysByMsisdn(UserUtil.defaultUserVo, msisdn,
                    SearchFacade.BizEntityF);
            final Date endTime = new Date();
            LOG.info("SIG searchFacade.retvKeysByMsisdn End ("
                    + StringUtils.defaultString(msisdn, SmartHomeConstants.NULL) + "), Time diff: "
                    + (endTime.getTime()-startTime.getTime()));

            if (null == sgwReturn) {
                LOG.info("sgwReturn is null");
            } else {
                LOG.info(sgwReturn.toString());
                if (sgwReturn.getExceptionF() != null) {
                    errorMsg = sgwReturn.getExceptionF().toString();
                    throw new Exception(errorMsg);
                } else if (sgwReturn.getExceptionK() != null) {
                    errorMsg = sgwReturn.getExceptionK().toString();
                    throw new Exception(errorMsg);
                } else if (sgwReturn.getExceptionOthers() != null) {
                    errorMsg = sgwReturn.getExceptionOthers().toString();
                    throw new Exception(errorMsg);
                } else {
                    if (sgwReturn.getRtnObject() != null) {
                        vo = (MsisdnKeysVo) sgwReturn.getRtnObject();
                    }
                }
            }
        } catch (Exception e) {
            LOG.warn(e.getMessage(), e);
            throw new BusinessException(e);
        }
//        LOG.info("==============ResourceService.retvKeysByMsisdn End ("
//                + StringUtils.defaultString(msisdn, SmartHomeConstants.NULL) + ")==============");
        return vo;
    }
}
