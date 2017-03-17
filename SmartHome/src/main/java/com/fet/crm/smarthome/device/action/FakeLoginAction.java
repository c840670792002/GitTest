package com.fet.crm.smarthome.device.action;

import com.fet.crm.smarthome.device.facade.DeviceFacade;
import com.fet.crm.smarthome.generic.model.UserProfile;
import com.fet.crm.smarthome.generic.util.SmartHomeConstants;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes({ SmartHomeConstants.USER_PROFILE, SmartHomeConstants.LOGINED })
public class FakeLoginAction {
    @Autowired
    private transient DeviceFacade devicetFacade;

    @RequestMapping("/fakeLogin")
    public String fakeLogin() {
        return "login/fake_index";
    }

    @RequestMapping("/fake/login")
    public String login(@RequestParam(SmartHomeConstants.MSISDN) final String msisdn, final Model model,
            HttpServletRequest request, HttpServletResponse response) {
        final UserProfile userProfile = new UserProfile();
        userProfile.setMsisdn(msisdn);
        userProfile.setFetuid(msisdn);
        userProfile.setNickName("fake nick name");
        final Cookie cookie = new Cookie("fetuid", msisdn);
        cookie.setMaxAge(Integer.MAX_VALUE);
        response.addCookie(cookie);
        model.addAttribute(SmartHomeConstants.USER_PROFILE, userProfile);
        model.addAttribute(SmartHomeConstants.LOGINED, Boolean.TRUE);
        try {
            final String subscriberId = devicetFacade.getSubscriberId(userProfile.getMsisdn());
            userProfile.setSubscriberId(subscriberId);

        } catch (Exception e) {
            model.addAttribute("errMsg", e.getMessage());
        }
        return "forward:/device/settingsInit.action";
    }
}
