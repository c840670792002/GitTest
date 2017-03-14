package com.fet.crm.smarthome.mware.client.impl;

import com.fet.crm.smarthome.generic.model.UserProfile;
import com.fet.crm.smarthome.generic.util.BusinessException;
import com.fet.crm.smarthome.generic.util.HttpConnectionUtil;
import com.fet.crm.smarthome.generic.util.RegularExpressionUtil;
import com.fet.crm.smarthome.mware.client.UserProfileClient;
import com.fet.generic.logger.ILogger;
import com.fet.generic.logger.LoggerFactory;

import org.apache.commons.lang.StringUtils;

/**
 * 呼叫 CSP API 之 client
 * 
 * @author Paul Chan
 * @version 1.0.0.0
 */
public class UserProfileClientImpl implements UserProfileClient {
    private static final ILogger LOG = LoggerFactory.getLogger(UserProfileClientImpl.class);
    public static final String CSP_API_SUCCESS_CODE = "00000000";

    /**
     * DOCUMENT ME!
     * 
     * @param fetuid
     *            DOCUMENT ME!
     * 
     * @return DOCUMENT ME!
     * 
     * @throws BusinessException
     *             DOCUMENT ME!
     */
    public UserProfile getUserProfile(final String fetuid) throws BusinessException {
        LOG.info("fetuid:"+ fetuid);
        final UserProfile userProfile = new UserProfile();

        // 取得CSP基本資訊
        final String cspResult = HttpConnectionUtil.getCspResult(fetuid);
        
        LOG.info("cspResult:" + cspResult);

        final String returnCode = StringUtils.defaultString(RegularExpressionUtil.getTagValue(cspResult, "returnCode"));
        LOG.debug("ReturnCode:" + returnCode);
        final String description = StringUtils.defaultString(RegularExpressionUtil
                .getTagValue(cspResult, "description"));
        LOG.debug("Description:" + description);

        if ((null != returnCode) && CSP_API_SUCCESS_CODE.equals(returnCode)) { // 成功
            final String realFetuid = StringUtils.defaultString(RegularExpressionUtil.getTagValue(cspResult, "id"));
            final String msisdn = StringUtils.defaultString(RegularExpressionUtil.getTagValue(cspResult, "MSISDN"));
            final String nickName = StringUtils.defaultString(RegularExpressionUtil.getTagValue(cspResult, "nickName"));

            LOG.info("Real FET UID:" + realFetuid+"\n"+"MSISDN:" + msisdn+"\n"+"NickName:" + nickName);            

            if (StringUtils.isNotEmpty(msisdn)) {
                userProfile.setFetuid(realFetuid);
                userProfile.setMsisdn(msisdn);
                userProfile.setNickName(nickName);
            }
        } else {
            // 失敗時拋出例外
            throw new BusinessException("GetUserProfile Fail, returnCode: " + returnCode + ", description: "
                    + description + ", (fetuid:" + fetuid + ")");
        }       

        return userProfile;
    }
}
