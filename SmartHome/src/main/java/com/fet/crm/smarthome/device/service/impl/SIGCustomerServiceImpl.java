package com.fet.crm.smarthome.device.service.impl;

import com.fet.crm.smarthome.device.service.CustomerService;
import com.fet.crm.smarthome.generic.bean.CustomerVO;
import com.fet.crm.smarthome.generic.model.UserProfile;
import com.fet.crm.smarthome.generic.util.BusinessException;
import com.fet.crm.smarthome.generic.util.ErrorCodeUtil;
import com.fet.crm.smarthome.generic.util.ErrorType;
import com.fet.crm.smarthome.generic.util.MessageUtil;
import com.fet.crm.smarthome.generic.util.SmartHomeConstants;
import com.fet.crm.smarthome.mware.client.SIGClient;
import com.fet.crm.smarthome.mware.client.UserProfileClient;
import com.fet.generic.logger.ILogger;
import com.fet.generic.logger.LoggerFactory;
import com.fet.siggw.vo.MsisdnKeysVo;

import org.apache.commons.lang.StringUtils;

/**
 * Customer service, using SIG
 * 
 * @author Paul Chan
 * @version 1.0.0.0
 */
public class SIGCustomerServiceImpl implements CustomerService {
    private static final ILogger LOG = LoggerFactory.getLogger(SIGCustomerServiceImpl.class);
    private transient UserProfileClient userProfileClient;
    private transient SIGClient sigClient;

    /**
     * DOCUMENT ME!
     * 
     * @param sigClient
     *            DOCUMENT ME!
     */
    public void setSigClient(final SIGClient sigClient) {
        this.sigClient = sigClient;
    }

    /**
     * DOCUMENT ME!
     * 
     * @param sigClient
     *            DOCUMENT ME!
     */
    public void setUserProfileClient(final UserProfileClient userProfileClient) {
        this.userProfileClient = userProfileClient;
    }

    /**
     * DOCUMENT ME!
     * 
     * @param fetuid
     *            DOCUMENT ME!
     * @param cspUser
     *            DOCUMENT ME!
     * @param sessionMsisdn
     *            DOCUMENT ME!
     * 
     * @return DOCUMENT ME!
     * @throws BusinessException
     */
    @Override
    public UserProfile getUserProfile(final String cspUser) throws BusinessException {
        String fetuidOrMsisdn = null;
        if (StringUtils.isNotBlank(cspUser)) {
            fetuidOrMsisdn = cspUser;
        }
        UserProfile qResult = null;
        int counter = 0;
        final int retryLimit = MessageUtil.getInteger("csp_api.retry_limit", 5);
        // 由於GetUserProfile常常會失敗所以要有重試的機制
        do {
            counter++;
            try {
                LOG.debug("try " + counter + " time(s)");
                qResult = userProfileClient.getUserProfile(fetuidOrMsisdn);
            } catch (Exception e) {
                if (counter < retryLimit) {
                    LOG.info("retry counter:" + counter);
                } else {
                    final String errCode = ErrorCodeUtil.buildErrorCode(SmartHomeConstants.DOMAIN_CODE,
                            SmartHomeConstants.SYSTEM_CODE, ErrorType.WebService, "001");
                    LOG.error(errCode, e.getMessage(), e);
                    throw new BusinessException(MessageUtil.getStringMessage(ErrorCodeUtil.buildErrorMessageKey(
                            ErrorType.WebService, "001")));
                }
            }
        } while (null == qResult && counter < retryLimit);
        
        if (null == qResult) {
            LOG.error("cannot get user profile via csp login");
        }
        return qResult;
    }

    /**
     * DOCUMENT ME!
     * 
     * @param msisdn
     *            DOCUMENT ME!
     * 
     * @return DOCUMENT ME!
     * 
     * @throws Exception
     *             DOCUMENT ME!
     */
    @Override
    public CustomerVO getSubscriberIdByMsisdn(final String msisdn) throws BusinessException {
        final MsisdnKeysVo keysVO = sigClient.retvKeysByMsisdn(msisdn);
        final CustomerVO customerVO = new CustomerVO();
        customerVO.setMsisdn(msisdn);
        if (null != keysVO) {
            customerVO.setSubscriberId(keysVO.getSubscriberId());
            customerVO.setProductType(keysVO.getBizEntity());
        }
        return customerVO;
    }
}
