package com.fet.crm.smarthome.generic.util;

import com.fet.crm.smarthome.generic.model.UserProfile;
import com.fet.generic.logger.FETThreadLocal;
import com.fet.generic.logger.logobj.Lur;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

public class FETThreadLocalUtil {

    public static void processLoginInfo(final UserProfile userProfile) {
        final String msisdn = userProfile.getMsisdn();
        final String cspUuid = userProfile.getFetuid();
        final String subscriberId = userProfile.getSubscriberId();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("CSP UUID", cspUuid);
        map.put("SubScribe ID", subscriberId);
        JSONObject jsObj = new JSONObject(map);
        com.fet.generic.logger.UserProfile userprofile = new com.fet.generic.logger.UserProfile(msisdn, jsObj);

        FETThreadLocal.setUserProfile(userprofile);

        Lur lur = FETThreadLocal.getLoginfo().getLur();
        lur.setSubscriberid(subscriberId);
        lur.setMsisdn(msisdn);
        lur.setFetuuid(cspUuid);
        lur.setObjectid(msisdn);
        FETThreadLocal.getLoginfo().setLur(lur);
    }
}
