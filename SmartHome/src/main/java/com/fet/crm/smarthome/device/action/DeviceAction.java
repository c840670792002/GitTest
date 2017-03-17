package com.fet.crm.smarthome.device.action;

import com.fet.crm.smarthome.device.facade.DeviceFacade;
import com.fet.crm.smarthome.generic.bean.AlertEventVO;
import com.fet.crm.smarthome.generic.bean.AlertNoticeVO;
import com.fet.crm.smarthome.generic.bean.DeviceResultVO;
import com.fet.crm.smarthome.generic.bean.DeviceVO;
import com.fet.crm.smarthome.generic.bean.OfferVO;
import com.fet.crm.smarthome.generic.model.UserProfile;
import com.fet.crm.smarthome.generic.util.FETThreadLocalUtil;
import com.fet.crm.smarthome.generic.util.MessageUtil;
import com.fet.crm.smarthome.generic.util.SmartHomeConstants;
import com.fet.crm.smarthome.mware.client.impl.DeviceClientImpl;
import com.fet.generic.logger.ILogger;
import com.fet.generic.logger.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * Spring MVC Controller
 *
 * @author Paul Chan
 * @version 1.0.0.0
 */
@Controller
@SessionAttributes({SmartHomeConstants.USER_PROFILE, SmartHomeConstants.LOGINED})
@RequestMapping("/device")
public class DeviceAction {

    private static final ILogger LOG = LoggerFactory.getLogger(DeviceAction.class);

    @Autowired
    private transient DeviceFacade devicetFacade;

    /**
     * UC110 - 告警設備查詢查詢頁，列出用戶方案及全部設備編號
     *
     * @return
     */
    @RequestMapping("/listAllDevice")
    public String listAllDevice(final HttpServletRequest request, final Model model) {
        LOG.info("DeviceAction.listAllDevice start");
        String resultView = "device/equipment-inquiry";
        try {

            if (model.containsAttribute(SmartHomeConstants.USER_PROFILE)) {
                final UserProfile userProfile = (UserProfile) model.asMap().get(SmartHomeConstants.USER_PROFILE);
                final String msisdn = userProfile.getMsisdn();
                final String subscriberId = userProfile.getSubscriberId();
                LOG.info("msisdn : " + StringUtils.defaultString(msisdn, SmartHomeConstants.NULL));
                LOG.info("subscriberId : " + StringUtils.defaultString(subscriberId, SmartHomeConstants.NULL));
                final List<OfferVO> offerList = devicetFacade.queryAllDevicesBySubscriberId(subscriberId);
                model.addAttribute("offerList", offerList);
            } else {
                LOG.debug("cannot initial userProfile, redirect to login page --  redirect:"
                        + MessageUtil.getStringMessage("base.login.url") + "listAllDevice.action");
                resultView = "redirect:" + MessageUtil.getStringMessage("base.login.url") + "listAllDevice.action";

            }
        } catch (Exception e) {
            LOG.debug(e.getMessage(), e);
            model.addAttribute("errMsg", e.getMessage());
        }
        return resultView;
    }

    /**
     * UC110 - 告警設備查詢查詢頁，列出所選設備以及其子設備狀態
     *
     * @return
     */
    @RequestMapping("/queryDevice")
    public String queryDevice(@ModelAttribute(SmartHomeConstants.USER_PROFILE) final UserProfile userProfile,
            @RequestParam(SmartHomeConstants.DEVICE_SERIAL) final String deviceSerial, final Model model) {
        FETThreadLocalUtil.processLoginInfo(userProfile);
        final String msisdn = userProfile.getMsisdn();
        LOG.info("DeviceAction.queryDevice start");
        LOG.info("msisdn : " + StringUtils.defaultString(msisdn, SmartHomeConstants.NULL));
        // 列出所選設備以及其子設備狀態
        LOG.info("deviceSerial : " + StringUtils.defaultString(deviceSerial, SmartHomeConstants.NULL));
        model.addAttribute(SmartHomeConstants.DEVICE_SERIAL, deviceSerial);
        try {
            final List<DeviceVO> deviceList = devicetFacade.queryDevice(msisdn, deviceSerial);
            model.addAttribute("deviceList", deviceList);
        } catch (Exception e) {
            LOG.debug(e.getMessage(), e);
            model.addAttribute("errMsg", e.getMessage());
        }
        return "device/equipment-inquiry-detail";
    }

    /**
     * UC120 - 告警紀錄查詢頁，列出全部設備編號
     *
     * @return
     */
    @RequestMapping("/recordInquiryInit")
    public String recordInquiryInit(final HttpServletRequest request, final Model model) {
        LOG.info("DeviceAction.recordInquiryInit start");
        // 列出全部設備編號
        String resultView = "device/record-inquiry";
        try {
            if (model.containsAttribute(SmartHomeConstants.USER_PROFILE)) {
                final UserProfile userProfile = (UserProfile) model.asMap().get(SmartHomeConstants.USER_PROFILE);
                final String subscriberId = userProfile.getSubscriberId();
                LOG.info("subscriberId : " + StringUtils.defaultString(subscriberId, SmartHomeConstants.NULL));
                final List<OfferVO> offerList = devicetFacade.queryAllDevicesBySubscriberId(subscriberId);
                model.addAttribute("offerList", offerList);
            } else {
                LOG.debug("cannot initial userProfile, redirect to login page --  redirect:"
                        + MessageUtil.getStringMessage("base.login.url") + "recordInquiryInit.action");
                resultView = "redirect:" + MessageUtil.getStringMessage("base.login.url") + "recordInquiryInit.action";
            }
        } catch (Exception e) {
            LOG.debug(e.getMessage(), e);
            model.addAttribute("errMsg", e.getMessage());
        }
        return resultView;
    }

    /**
     * UC120 - 告警紀錄查詢頁，列出所選設備之告警紀錄
     *
     * @return
     */
    @RequestMapping("/recordInquiry")
    public String recordInquiry(@ModelAttribute(SmartHomeConstants.USER_PROFILE) final UserProfile userProfile,
            @RequestParam(value = SmartHomeConstants.DEVICE_SERIAL, required = true) final String deviceSerial,
            @RequestParam(value = "startDate", required = false, defaultValue = "") final String startDate,
            @RequestParam(value = "endDate", required = false, defaultValue = "") final String endDate,
            @RequestParam(value = "pageNo", required = false, defaultValue = "1") final String pageNo, final Model model) {
        FETThreadLocalUtil.processLoginInfo(userProfile);
        final String msisdn = userProfile.getMsisdn();
        LOG.info("DeviceAction.recordInquiry start");
        LOG.info("msisdn : " + StringUtils.defaultString(msisdn, SmartHomeConstants.NULL));
        LOG.info("deviceSerial : " + StringUtils.defaultString(deviceSerial, SmartHomeConstants.NULL));
        LOG.info("startDate : " + StringUtils.defaultString(startDate, SmartHomeConstants.NULL));
        LOG.info("endDate : " + StringUtils.defaultString(endDate, SmartHomeConstants.NULL));
        LOG.info("pageNo : " + StringUtils.defaultString(pageNo, SmartHomeConstants.NULL));
        try {
            // 將 startDate 轉為 Date 物件 startTimeObj
            final Date startTimeObj = DeviceClientImpl.parseDate(startDate);
            // 將 endDate 轉為 Date 物件 endTimeObj
            final Date endTimeObj = DeviceClientImpl.parseDate(endDate);
            // 列出所選設備之告警紀錄
            final List<AlertEventVO> alertEventList = devicetFacade.queryAlertEvent(msisdn, deviceSerial, startTimeObj,
                    endTimeObj, Integer.parseInt(pageNo));
            model.addAttribute("alertEventList", alertEventList);
            int totalPage = 1;
            if (null != alertEventList && !alertEventList.isEmpty()) {
                totalPage = alertEventList.get(0).getTotalPage();
            }
            model.addAttribute("totalPage", totalPage);
            model.addAttribute("currPage", pageNo);
        } catch (Exception e) {
            LOG.debug(e.getMessage(), e);
            model.addAttribute("errMsg", e.getMessage());
        }
        return "device/record-inquiry-detail";
    }

    /**
     * UC130 - 告警通知設定頁，列出全部設備編號
     *
     * @return
     */
    @RequestMapping("/settingsInit")
    public String settingsInit(final HttpServletRequest request, final Model model) {
        LOG.info("DeviceAction.settingsInit start");
        // 列出全部設備編號
        String resultView = "device/settings";
        try {
            if (model.containsAttribute(SmartHomeConstants.USER_PROFILE)) {
                final UserProfile userProfile = (UserProfile) model.asMap().get(SmartHomeConstants.USER_PROFILE);
                final String subscriberId = userProfile.getSubscriberId();
                LOG.info("subscriberId : " + StringUtils.defaultString(subscriberId, SmartHomeConstants.NULL));
                final List<OfferVO> offerList = devicetFacade.queryAllDevicesBySubscriberId(subscriberId);
                model.addAttribute("offerList", offerList);
            } else {
                LOG.debug("cannot initial userProfile, redirect to login page --  redirect:"
                        + MessageUtil.getStringMessage("base.login.url") + "settingsInit.action");
                resultView = "redirect:" + MessageUtil.getStringMessage("base.login.url") + "settingsInit.action";
            }
        } catch (Exception e) {
            LOG.debug(e.getMessage(), e);
            model.addAttribute("errMsg", e.getMessage());
        }
        return resultView;
    }

    /**
     * UC130 - 告警通知設定頁，列出所選設備之告警通知設定
     *
     * @return
     */
    @RequestMapping("/settings")
    public String settingsDevice(@ModelAttribute(SmartHomeConstants.USER_PROFILE) final UserProfile userProfile,
            @RequestParam(SmartHomeConstants.DEVICE_SERIAL) final String deviceSerial, final Model model) {
        FETThreadLocalUtil.processLoginInfo(userProfile);
        final String msisdn = userProfile.getMsisdn();
        LOG.info("DeviceAction.settingsDevice start");
        LOG.info("msisdn : " + StringUtils.defaultString(msisdn, SmartHomeConstants.NULL));
        LOG.info("deviceSerial : " + StringUtils.defaultString(deviceSerial, SmartHomeConstants.NULL));
        // 列出所選設備之所有告警通知設定
        try {
            final Map<String, List<AlertNoticeVO>> alertNoticeMap = devicetFacade.listAlertNotice(msisdn, deviceSerial);
            model.addAttribute("smsList", alertNoticeMap.get("sms"));
            model.addAttribute("emailList", alertNoticeMap.get("email"));
        } catch (Exception e) {
            LOG.debug(e.getMessage(), e);
            model.addAttribute("errMsg", e.getMessage());
        }
        return "device/settings-detail";
    }

    /**
     * UC130 - 告警通知設定頁，新增告警通知設定
     *
     * @return
     */
    @RequestMapping(value = "/settings", params = {"action=add"})
    public String addSettingsDevice(@ModelAttribute(SmartHomeConstants.USER_PROFILE) final UserProfile userProfile,
            @RequestParam(SmartHomeConstants.DEVICE_SERIAL) final String deviceSerial,
            @RequestParam("type") final String type, @RequestParam("value") final String value, final Model model) {
        FETThreadLocalUtil.processLoginInfo(userProfile);
        final String msisdn = userProfile.getMsisdn();
        LOG.info("DeviceAction.addSettingsDevice start");
        LOG.info("msisdn : " + StringUtils.defaultString(msisdn, SmartHomeConstants.NULL));
        LOG.info("deviceSerial : " + StringUtils.defaultString(deviceSerial, SmartHomeConstants.NULL));
        LOG.info("type : " + StringUtils.defaultString(type, SmartHomeConstants.NULL));
        LOG.info("value : " + StringUtils.defaultString(value, SmartHomeConstants.NULL));

        final StringBuffer errMsg = new StringBuffer();
        try {
            // 新增告警通知設定
            final DeviceResultVO processResult = devicetFacade.addAlertNotice(msisdn, deviceSerial, type, value);
            model.addAttribute("processResult", processResult);
        } catch (Exception e) {
            LOG.debug(e.getMessage(), e);
            errMsg.append(e.getMessage());
        }

        try {
            // 列出所選設備之所有告警通知設定
            final Map<String, List<AlertNoticeVO>> alertNoticeMap = devicetFacade.listAlertNotice(msisdn, deviceSerial);
            model.addAttribute("smsList", alertNoticeMap.get("sms"));
            model.addAttribute("emailList", alertNoticeMap.get("email"));
        } catch (Exception e) {
            LOG.debug(e.getMessage(), e);
            if (errMsg.length() > 0) {
                errMsg.append("<br>");
            }
            errMsg.append(e.getMessage());
        }
        if (errMsg.length() > 0) {
            model.addAttribute("errMsg", errMsg.toString());
        }
        return "device/settings-detail";
    }

    /**
     * UC130 - 告警通知設定頁，移除告警通知設定
     *
     * @return
     */
    @RequestMapping(value = "/settings", params = {"action=remove"})
    public String removeSettingsDevice(@ModelAttribute(SmartHomeConstants.USER_PROFILE) final UserProfile userProfile,
            @RequestParam(SmartHomeConstants.DEVICE_SERIAL) final String deviceSerial,
            @RequestParam("type") final String type, @RequestParam("value") final String value, final Model model) {
        FETThreadLocalUtil.processLoginInfo(userProfile);
        final String msisdn = userProfile.getMsisdn();
        LOG.info("DeviceAction.removeSettingsDevice start");
        LOG.info("msisdn : " + StringUtils.defaultString(msisdn, SmartHomeConstants.NULL));
        LOG.info("deviceSerial : " + StringUtils.defaultString(deviceSerial, SmartHomeConstants.NULL));
        LOG.info("type : " + StringUtils.defaultString(type, SmartHomeConstants.NULL));
        LOG.info("value : " + StringUtils.defaultString(value, SmartHomeConstants.NULL));

        final StringBuffer errMsg = new StringBuffer();
        try {
            // 移除告警通知設定
            final DeviceResultVO processResult = devicetFacade.removeAlertNotice(msisdn, deviceSerial, type, value);
            model.addAttribute("processResult", processResult);
        } catch (Exception e) {
            LOG.debug(e.getMessage(), e);
            errMsg.append(e.getMessage());
        }

        try {
            // 列出所選設備之所有告警通知設定
            final Map<String, List<AlertNoticeVO>> alertNoticeMap = devicetFacade.listAlertNotice(msisdn, deviceSerial);
            model.addAttribute("smsList", alertNoticeMap.get("sms"));
            model.addAttribute("emailList", alertNoticeMap.get("email"));
        } catch (Exception e) {
            LOG.debug(e.getMessage(), e);
            if (errMsg.length() > 0) {
                errMsg.append("<br>");
            }
            errMsg.append(e.getMessage());
        }
        if (errMsg.length() > 0) {
            model.addAttribute("errMsg", errMsg.toString());
        }
        return "device/settings-detail";
    }

    @RequestMapping(value = "/user_manual", method = RequestMethod.GET)
    public String downloadUserManual(HttpServletResponse response, HttpSession session, Model model) {
        LOG.info("DeviceAction.downloadUserManual start");
        String resultView = null;
        try {
            if (model.containsAttribute(SmartHomeConstants.USER_PROFILE)) {
                InputStream input = null;
                try {
                    input = new FileInputStream(new File(session.getServletContext().getRealPath(
                            "/WEB-INF/manual/user_manual.pdf")));
                    final OutputStream output = response.getOutputStream();
                    byte[] buffer = new byte[1024];
                    int bytesRead;
                    while ((bytesRead = input.read(buffer)) != -1) {
                        output.write(buffer, 0, bytesRead);
                    }
                    response.setContentType("application/pdf");
                    response.flushBuffer();
                } catch (IOException ex) {
                    // ignored
                    LOG.debug("ignored");
                } finally {
                    if (null != input) {
                        try {
                            input.close();
                        } catch (IOException e) {
                            // ignored
                            LOG.debug("ignored");
                        }
                    }
                }
            } else {
                LOG.debug("cannot initial userProfile, redirect to login page --  redirect:"
                        + MessageUtil.getStringMessage("base.login.url") + "user_manual.action");
                resultView = "redirect:" + MessageUtil.getStringMessage("base.login.url") + "user_manual.action";

            }
        } catch (Exception e) {
            LOG.debug(e.getMessage(), e);
            resultView = "redirect:" + MessageUtil.getStringMessage("base.login.url") + "user_manual.action";
        }
        return resultView;

    }

    @RequestMapping(value = "/sh_player", method = RequestMethod.GET)
    public String downloadSHPlayer(HttpServletResponse response, HttpSession session, Model model) {
        LOG.info("DeviceAction.downloadSHPlayer start");
        String resultView = null; 
        int BUFFER_SIZE = 4096;
        try {
            if (model.containsAttribute(SmartHomeConstants.USER_PROFILE)) {
                InputStream input = null;
                try {
                    String fullPath = "/WEB-INF/player/SHplayer_1.03_x32.exe";

                    // get absolute path of the application
                    ServletContext context = session.getServletContext();
//                    String appPath = context.getRealPath("");
//                    LOG.info("appPath = " + appPath);

                    // construct the complete absolute path of the file
                    File downloadFile = new File(session.getServletContext().getRealPath(
                            "/WEB-INF/player/SHplayer_1.03_x32.exe"));
                    FileInputStream inputStream = new FileInputStream(downloadFile);
                    LOG.info("fileName:"+downloadFile.getName());
                    // get MIME type of the file
                    String mimeType = context.getMimeType(fullPath);
                    if (mimeType == null) {
                    // set to binary type if MIME mapping not found
                        mimeType = "application/octet-stream";
                    }
                    LOG.info("MIME type: " + mimeType);

                    // set content attributes for the response
                    response.setContentType(mimeType);
                    response.setContentLength((int) downloadFile.length());

// set headers for the response
                    String headerKey = "Content-Disposition";
                    String headerValue = String.format("attachment; filename=\"%s\"",
                            downloadFile.getName());
                    response.setHeader(headerKey, headerValue);

// get output stream of the response
                    OutputStream outStream = response.getOutputStream();

                    byte[] buffer = new byte[1024];
                    int bytesRead;
                    while ((bytesRead = inputStream.read(buffer)) != -1) {
                        outStream.write(buffer, 0, bytesRead);
                    }
                    
                    inputStream.close();
                    outStream.close();
                    response.flushBuffer();
                    LOG.info("finish download software");
                } catch (IOException ex) {
                    // ignored
                    ex.printStackTrace();
                    LOG.debug("ignored");
                } finally {
                    if (null != input) {
                        try {
                            input.close();
                        } catch (IOException e) {
                            // ignored
                            e.printStackTrace();
                            LOG.debug("ignored");
                        }
                    }
                }
            } else {
                LOG.debug("cannot initial userProfile, redirect to login page --  redirect:"
                        + MessageUtil.getStringMessage("base.login.url") + "sh_player.action");
                resultView = "redirect:" + MessageUtil.getStringMessage("base.login.url") + "sh_player.action";

            }
        } catch (Exception e) {
                    e.printStackTrace();
            LOG.debug(e.getMessage(), e);
            resultView = "redirect:" + MessageUtil.getStringMessage("base.login.url") + "sh_player.action";
        }
        return resultView;

    }
}
