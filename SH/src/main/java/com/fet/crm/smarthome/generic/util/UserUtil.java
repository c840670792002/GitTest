package com.fet.crm.smarthome.generic.util;

import java.util.ResourceBundle;

import com.fet.siggw.vo.UserVo;

/**
 * DOCUMENT ME!
 * 
 * @author Paul Chan
 * @version 1.0.0.0
 */
public final class UserUtil {
    private static final String PROPERTIES_FILE_NAME = "smarthome";
    private static final ResourceBundle resourceBundle = ResourceBundle.getBundle(PROPERTIES_FILE_NAME);
    public static final UserVo defaultUserVo = getDefaultUser();
    private static final String USER_ID_F = "user.id.f";
    private static final String CHANNEL_F = "user.channel.f";
    private static final String USER_NAME_F = "user.name.f";
    private static final String USER_NAME_K = "user.name.k";
    private static final String USER_PASSWORD_F = "user.password.f";
    private static final String USER_PASSWORD_K = "user.password.k";

    private UserUtil() {

    }

    private static UserVo getDefaultUser() {
        final UserVo userVo = new UserVo();
        userVo.setUserIDF(resourceBundle.getString(USER_ID_F));
        userVo.setChannelF(resourceBundle.getString(CHANNEL_F));
        userVo.setUserNameF(resourceBundle.getString(USER_NAME_F));
        userVo.setUserNameK(resourceBundle.getString(USER_NAME_K));
        userVo.setPasswordF(resourceBundle.getString(USER_PASSWORD_F));
        userVo.setPasswordK(resourceBundle.getString(USER_PASSWORD_K));
        return userVo;
    }
}
