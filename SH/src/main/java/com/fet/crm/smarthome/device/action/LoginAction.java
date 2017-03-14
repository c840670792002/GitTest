package com.fet.crm.smarthome.device.action;

import com.fet.crm.smarthome.generic.util.SmartHomeConstants;
import com.fet.generic.logger.ILogger;
import com.fet.generic.logger.LoggerFactory;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;

/**
 * Spring MVC Controller
 * 
 * @author Paul Chan
 * @version 1.0.0.0
 */
@Controller
@SessionAttributes({ SmartHomeConstants.USER_PROFILE, SmartHomeConstants.LOGINED })
public class LoginAction {
    private static final ILogger LOG = LoggerFactory.getLogger(LoginAction.class);

    @RequestMapping("index")
    public String login(final HttpServletRequest request, final Model model) {
        return "/login/index";
    }

    @RequestMapping("/login")
    public String processLoginBack(@RequestParam("returnURL") final String returnURL, final Model model) {
        LOG.info("redirect!!!! : "+ returnURL);
        model.addAttribute("returnURL", returnURL);
        return "/login/postlogin";
    }

    @RequestMapping("/logout")
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    public String processLogout(final HttpServletRequest request, final Model model, final WebRequest webRequest,
            final SessionStatus status) {
        status.setComplete();
        webRequest.removeAttribute(SmartHomeConstants.USER_PROFILE, WebRequest.SCOPE_SESSION);
        webRequest.setAttribute(SmartHomeConstants.LOGINED, Boolean.FALSE, WebRequest.SCOPE_SESSION);
        try {
            final Cookie[] cookies = request.getCookies();
            for (final Cookie cookie : cookies) {
                cookie.setMaxAge(0);
            }
        } catch (Exception e) {
            LOG.debug(e.getMessage(), e);
            model.addAttribute("errMsg", e.getMessage());
        }
        return "success";
    }

}
