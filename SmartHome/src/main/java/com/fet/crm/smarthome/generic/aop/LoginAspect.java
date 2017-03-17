package com.fet.crm.smarthome.generic.aop;

import com.fet.crm.smarthome.device.facade.DeviceFacade;
import com.fet.crm.smarthome.generic.model.UserProfile;
import com.fet.crm.smarthome.generic.util.FETThreadLocalUtil;
import com.fet.crm.smarthome.generic.util.SmartHomeConstants;
import com.fet.generic.logger.ILogger;
import com.fet.generic.logger.LoggerFactory;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
public class LoginAspect {
    private static final ILogger LOG = LoggerFactory.getLogger(LoginAspect.class);
    @Autowired
    private transient DeviceFacade devicetFacade;

    @Before("execution(* com.fet.crm.smarthome.device.action.DeviceAction.*(..)) || execution(* com.fet.crm.smarthome.device.action.LoginAction.login(..))")
    public void beforeProcess(JoinPoint joinPoint) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
                .getRequest();
        LOG.debug("Request url : " + request.getRequestURI());
        final Object[] objAry = joinPoint.getArgs();
        Model model = null;
        for (Object obj : objAry) {
            if (obj instanceof Model) {
                model = (Model) obj;
                break;
            }
        }
        if (null != model) {
            final Cookie[] cookies = request.getCookies();
            if (!Boolean.TRUE.equals(model.asMap().get(SmartHomeConstants.LOGINED))) {
                String fetuid = null;
                if (null != cookies) {
                    for (final Cookie cookie : cookies) {
                        if ("fetuid".equals(cookie.getName())) {
                            fetuid = cookie.getValue();
                            break;
                        }
                    }

                    if (StringUtils.isNotEmpty(fetuid)) {
                        LOG.info("fetuid is " + fetuid);
                        initUserProfile(fetuid, model);
                    } else {
                        LOG.debug("fetuid is NULL");
                    }
                }
            }

        }
    }

    private UserProfile initUserProfile(final String fetuid, final Model model) {
        UserProfile userProfile = null;
        if (model.containsAttribute(SmartHomeConstants.USER_PROFILE)) {
            userProfile = (UserProfile) model.asMap().get(SmartHomeConstants.USER_PROFILE);
        } else {
            if (StringUtils.isNotBlank(fetuid)) {
                final String[] fetuidAry = fetuid.split("\\|");
                try {
                    userProfile = devicetFacade.getUserProfile(fetuidAry[0]);

                    final String subscriberId = devicetFacade.getSubscriberId(userProfile.getMsisdn());
                    LOG.info("SubScriberID:" + subscriberId);
                    userProfile.setSubscriberId(subscriberId);

                    model.addAttribute(SmartHomeConstants.USER_PROFILE, userProfile);

                    FETThreadLocalUtil.processLoginInfo(userProfile);
                } catch (Exception e) {
                    LOG.error(e.getMessage(), e);
                    model.addAttribute("errMsg", e.getMessage());
                }
            }
        }
        return userProfile;
    }
}
