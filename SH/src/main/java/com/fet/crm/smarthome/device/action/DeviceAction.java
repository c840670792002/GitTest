package com.fet.crm.smarthome.device.action;

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

	private final static String DID_MASTER_1 = MessageUtil.getStringMessage("smarthome2.did.master.type.1");
	private final static String DID_MASTER_2 = MessageUtil.getStringMessage("smarthome2.did.master.type.2");
	
    /**	共用入口方法，CSR/PC/WO可透過此URL進入
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/commonEntry")
    public String commonEntry(final HttpServletRequest request, final Model model){
    	LOG.info("entry...");
    	String resultView = "device/errorPage";

    	final String channel = request.getParameter(SmartHomeConstants.CHANNEL);
    	final UserProfile userProfile = new UserProfile();
        
    	String msisdn;
    	String uId;
    	String nickName;
    	String subscriberId;
    	
    	//FIXME 帶入參數有哪些???CSR???
    	//entry為Fetnet時，需傳遞msisdn,uid,nickName,subscriberId (Fetnet 走正常登入流程，應不會透過轉址進入)
    	if(SmartHomeConstants.CHANNEL_FET.equals(channel)){
//    		msisdn = request.getParameter("msisdn");
//    		uId = request.getParameter("uId");
//    		nickName = request.getParameter("nickName");
//    		subscriberId = request.getParameter("subscriberId");
//    		
//            userProfile.setMsisdn(msisdn);
//            userProfile.setFetuid(uId);
//            userProfile.setNickName(nickName);
//            userProfile.setSubscriberId(subscriberId);
//            userProfile.setChannel(channel);
            
        //entry為CSR時 
    	}else if(SmartHomeConstants.CHANNEL_CSR.equals(channel)){
    		//TODO 驗證帳號 & 權限 
    		//TODO 於userProfile中新增權限變數來顯示第四個TAB
    		msisdn = request.getParameter("msisdn");
    		//TODO 利用APIM=>用msisdn取uid ：getUid(String msisdn);
    		uId = "TODO";//ApimClient.getUid(msisdn);
    		
//    		uId = request.getParameter("uId");
//    		nickName = request.getParameter("nickName");
//    		subscriberId = request.getParameter("subscriberId");
    		
            userProfile.setMsisdn(msisdn);
            userProfile.setFetuid(uId);
//            userProfile.setNickName(nickName);
//            userProfile.setSubscriberId(subscriberId);
            userProfile.setChannel(channel);

        	model.addAttribute(SmartHomeConstants.USER_PROFILE, userProfile);
        	model.addAttribute(SmartHomeConstants.LOGINED, Boolean.TRUE);
    	//entry異常時
    	}else{
    		return resultView;//TODO 入口錯誤導到error頁面?
    	}
    	
    	//初始第一個tab分頁並導頁
    	resultView = listAllDevice(request, model);
    	
    	return resultView;
    }
    
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

        	//已登入判斷邏輯
            if (model.containsAttribute(SmartHomeConstants.USER_PROFILE)) {
            	//取得model中的UserProfile
            	final UserProfile userProfile = (UserProfile) model.asMap().get(SmartHomeConstants.USER_PROFILE);
                final String msisdn = userProfile.getMsisdn();
                final String subscriberId = userProfile.getSubscriberId();
                final String fetuid = userProfile.getFetuid();
                final String channel = userProfile.getChannel();
                LOG.info("msisdn : " + StringUtils.defaultString(msisdn, SmartHomeConstants.NULL));
                LOG.info("subscriberId : " + StringUtils.defaultString(subscriberId, SmartHomeConstants.NULL));
                LOG.info("fetuid : " + StringUtils.defaultString(fetuid, SmartHomeConstants.NULL));
                LOG.info("channel : " + StringUtils.defaultString(channel, SmartHomeConstants.NULL));
                //按照userProfile資訊取得全部設備編號offerList(SH+SH2) 增加queryAllDevices方法，需支援同時抓出SH2的設備編號
                final List<OfferVO> offerList = devicetFacade.queryAllDevices(channel,subscriberId,fetuid);
                model.addAttribute("offerList", offerList);
                
            } else {
                LOG.debug("cannot initial userProfile, redirect to login page --  redirect:"
                        + MessageUtil.getStringMessage("base.login.url") + "user_manual.action");
                resultView = "redirect:" + MessageUtil.getStringMessage("base.login.url") + "user_manual.action";
                
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
        	
        	Integer didType = getDidType(deviceSerial);
        	
        	List<DeviceVO> deviceList = null;
        	switch(didType) { 
	            case 1: //一代
	            	deviceList = devicetFacade.queryDevice(msisdn, deviceSerial);//FIXME 先mark掉一代
	                break; 
	            case 2: //二代
	            	deviceList = devicetFacade.queryDeviceFor2(userProfile.getChannel(),deviceSerial,userProfile.getFetuid());
	                break; 
	            default: 
            	; 
        	}
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
                final String fetuid = userProfile.getFetuid();
                final String channel = userProfile.getChannel();
                LOG.info("subscriberId : " + StringUtils.defaultString(subscriberId, SmartHomeConstants.NULL));
                LOG.info("fetuid : " + StringUtils.defaultString(fetuid, SmartHomeConstants.NULL));
                LOG.info("channel : " + StringUtils.defaultString(channel, SmartHomeConstants.NULL));
                //按照userProfile資訊取得全部設備編號offerList(SH+SH2) 增加queryAllDevices方法，需支援同時抓出SH2的設備編號
                final List<OfferVO> offerList = devicetFacade.queryAllDevices(channel,subscriberId,fetuid);
                
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
            

        	Integer didType = getDidType(deviceSerial);
        	
        	List<AlertEventVO> alertEventList = null;
        	switch(didType) { 
	            case 1: //一代
	            	alertEventList = devicetFacade.queryAlertEvent(msisdn, deviceSerial, startTimeObj, endTimeObj, Integer.parseInt(pageNo));//FIXME 先mark掉一代
	                break; 
	            case 2: //二代
	            	alertEventList = devicetFacade.queryAlertEventFor2(userProfile.getChannel(),deviceSerial,userProfile.getFetuid(), startTimeObj, endTimeObj, Integer.parseInt(pageNo));
	                break; 
	            default: 
            	; 
        	}
            
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
                final String fetuid = userProfile.getFetuid();
                final String channel = userProfile.getChannel();
                LOG.info("subscriberId : " + StringUtils.defaultString(subscriberId, SmartHomeConstants.NULL));
                LOG.info("fetuid : " + StringUtils.defaultString(fetuid, SmartHomeConstants.NULL));
                LOG.info("channel : " + StringUtils.defaultString(channel, SmartHomeConstants.NULL));
                //按照userProfile資訊取得全部設備編號offerList(SH+SH2) 增加queryAllDevices方法，需支援同時抓出SH2的設備編號
                final List<OfferVO> offerList = devicetFacade.queryAllDevices(channel,subscriberId,fetuid);
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

        try {

        	Integer didType = getDidType(deviceSerial);
        	
        	//列出所選設備之所有告警通知設定
        	Map<String, List<AlertNoticeVO>>  alertNoticeMap = null;
        	switch(didType) { 
	            case 1: //一代
	            	alertNoticeMap = devicetFacade.listAlertNotice(msisdn, deviceSerial);//FIXME 先mark掉一代
	                break; 
	            case 2: //二代
	            	alertNoticeMap = devicetFacade.listAlertNoticeFor2(userProfile.getChannel(),deviceSerial,userProfile.getFetuid());
	                break; 
	            default: 
            	; 
        	}
        	
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
        
        Integer didType = getDidType(deviceSerial);

        try {

        	DeviceResultVO processResult = null;
        	switch(didType) { 
	            case 1: //一代
	                processResult = devicetFacade.addAlertNotice(msisdn, deviceSerial, type, value);//FIXME 先mark掉一代
	                break; 
	            case 2: //二代
	            	processResult = devicetFacade.addAlertNoticeFor2(userProfile.getChannel(),userProfile.getFetuid(),msisdn, deviceSerial, type, value);
	                break; 
	            default: 
            	; 
        	}
        	
            model.addAttribute("processResult", processResult);
        } catch (Exception e) {
            LOG.debug(e.getMessage(), e);
            errMsg.append(e.getMessage());
        }

        try {

        	//列出所選設備之所有告警通知設定
        	Map<String, List<AlertNoticeVO>>  alertNoticeMap = null;
        	switch(didType) { 
	            case 1: //一代
//	            	alertNoticeMap = devicetFacade.listAlertNotice(msisdn, deviceSerial);//FIXME 先mark掉一代
//	                break; 
	            case 2: //二代
	            	alertNoticeMap = devicetFacade.listAlertNoticeFor2(userProfile.getChannel(),deviceSerial,userProfile.getFetuid());
	                break; 
	            default: 
            	; 
        	}

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


        Integer didType = getDidType(deviceSerial);

        try {

        	DeviceResultVO processResult = null;
        	switch(didType) { 
	            case 1: //一代
	                processResult = devicetFacade.removeAlertNotice(msisdn, deviceSerial, type, value);//FIXME 先mark掉一代
	                break; 
	            case 2: //二代
	            	processResult = devicetFacade.removeAlertNoticeFor2(userProfile.getChannel(),userProfile.getFetuid(),msisdn, deviceSerial, type, value);
	                break; 
	            default: 
            	; 
        	}
            model.addAttribute("processResult", processResult);
        } catch (Exception e) {
            LOG.debug(e.getMessage(), e);
            errMsg.append(e.getMessage());
        }

        try {
            // 列出所選設備之所有告警通知設定
        	Map<String, List<AlertNoticeVO>>  alertNoticeMap = null;
        	switch(didType) { 
	            case 1: //一代
//	            	alertNoticeMap = devicetFacade.listAlertNotice(msisdn, deviceSerial);//FIXME 先mark掉一代
//	                break; 
	            case 2: //二代
	            	alertNoticeMap = devicetFacade.listAlertNoticeFor2(userProfile.getChannel(),deviceSerial,userProfile.getFetuid());
	                break; 
	            default: 
            	; 
        	}
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
    


    /** 依據DID前三碼區分一代、二代
     * @param deviceSerial
     * @return
     */
    private Integer getDidType(String deviceSerial) {
    	Integer rtn = null;
    	if(DID_MASTER_1.equals(deviceSerial.subSequence(0, 3))){
    		rtn = 1;
    	}else if(DID_MASTER_2.equals(deviceSerial.subSequence(0, 3))){
    		rtn = 2;
    	}
    	return rtn;
	}
}
