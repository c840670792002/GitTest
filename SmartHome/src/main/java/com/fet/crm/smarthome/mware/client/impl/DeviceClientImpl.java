package com.fet.crm.smarthome.mware.client.impl;

import com.fet.crm.smarthome.generic.model.AlertNoticeResponse;
import com.fet.crm.smarthome.generic.model.CommonQueryDeviceRequest;
import com.fet.crm.smarthome.generic.model.CommonResponse;
import com.fet.crm.smarthome.generic.model.DeviceRequest;
import com.fet.crm.smarthome.generic.model.ModifyAlertNotice;
import com.fet.crm.smarthome.generic.model.ModifyAlertNoticeRequest;
import com.fet.crm.smarthome.generic.model.QueryAlertEventRequest;
import com.fet.crm.smarthome.generic.model.QueryAlertEventResponse;
import com.fet.crm.smarthome.generic.model.QueryAlertNoticeResponse;
import com.fet.crm.smarthome.generic.model.QueryDeviceResponse;
import com.fet.crm.smarthome.generic.util.BusinessException;
import com.fet.crm.smarthome.generic.util.DeviceAPIResultCode;
import com.fet.crm.smarthome.generic.util.ErrorCodeUtil;
import com.fet.crm.smarthome.generic.util.ErrorType;
import com.fet.crm.smarthome.generic.util.HttpConnectionUtil;
import com.fet.crm.smarthome.generic.util.MessageUtil;
import com.fet.crm.smarthome.generic.util.SmartHomeConstants;
import com.fet.crm.smarthome.mware.client.DeviceClient;
import com.fet.generic.logger.ILogger;
import com.fet.generic.logger.LoggerFactory;
import com.google.gson.Gson;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.apache.commons.lang3.StringUtils;

/**
 * 呼叫設備 API 之 middleware client
 * 
 * @author Paul Chan
 * @version 1.0.0.0
 */
public class DeviceClientImpl implements DeviceClient {
    private static final ILogger LOG = LoggerFactory.getLogger(DeviceClientImpl.class);
    private static final String UI_DATETIME_PATTERN = "MM/dd/yyyy HH:mm";
    private static final String UI_DATE_PATTERN = "MM/dd/yyyy";
    private static final String QUERY_TIME_PATTERN = "yyyy/MM/dd HH:mm:ss";

    /**
     * call 設備API queryDevice method 取得設備狀態
     * 
     * @param msisdn
     *            DOCUMENT ME!
     * @param deviceSerial
     *            DOCUMENT ME!
     * @throws BusinessException
     */
    public QueryDeviceResponse queryDevice(final String msisdn, final String deviceSerial) throws BusinessException {
        final CommonQueryDeviceRequest dataObject = new CommonQueryDeviceRequest();
        dataObject.setMsisdn(msisdn);

        final DeviceRequest deviceRequest = new DeviceRequest();
        deviceRequest.setSerial(deviceSerial);
        dataObject.setDevice(deviceRequest);
        
        String invokedMethod = "qD";
        
        LOG.info("msisdn:"+msisdn+"\n"+"deviceSerial:"+deviceSerial+"\n"+"invoked method:"+invokedMethod);
             
        QueryDeviceResponse response = null;

        try {
            final String responseJSONStr = HttpConnectionUtil.postJsonData(invokedMethod, dataObject);
            // final String responseJSONStr =
            // "{\"devices\":[{\"type\":\"攝影機\",\"serial\":\"FET0005678TWNTONY\",\"power\":\"1\",\"status\":\"0\",\"connTime\":\"2015/04/03 00:00:00\"},{\"type\":\"磁簧\",\"serial\":\"7893569\",\"power\":\"1\",\"status\":\"1\",\"connTime\":\"2015/04/01 00:00:00\",\"pSerial\":\"FET0005678TWNTONY\"},{\"type\":\"紅外線偵測器\",\"serial\":\"7893569\",\"power\":\"1\",\"status\":\"1\",\"connTime\":\"2015/04/02 00:00:00\",\"pSerial\":\"FET0005678TWNTONY\"}]}";
            LOG.info("queryDevice response JSON:" + responseJSONStr);

            final Gson gson = new Gson();
            response = gson.fromJson(responseJSONStr, QueryDeviceResponse.class);
            if (null == response) {
                throw new BusinessException();
            } else if ("S".equals(response.getResult().getStatus())) {
                LOG.debug("queryDevice success");
            } else {
                throw new BusinessException(response.getResult().getErrCode());
            }
        } catch (Exception e) {
            final String errCode = ErrorCodeUtil.buildErrorCode(SmartHomeConstants.DOMAIN_CODE,
                    SmartHomeConstants.SYSTEM_CODE, ErrorType.WebService, "004");
            LOG.error(errCode, e.getMessage(), e);
            if (null == response || null == response.getResult()) {
                throw new BusinessException(MessageUtil.getStringMessage(ErrorCodeUtil.buildErrorMessageKey(ErrorType.WebService, "004")));
            } else {
                throw new BusinessException(response.getResult().getMsg());
            }
        }

        return response;
    }

    /**
     * DOCUMENT ME!
     * 
     * @param msisdn
     *            DOCUMENT ME!
     * @param deviceSerial
     *            DOCUMENT ME!
     * @param startTime
     *            DOCUMENT ME!
     * @param endTime
     *            DOCUMENT ME!
     * @param pageNo
     *            DOCUMENT ME!
     * @param pageSize
     *            DOCUMENT ME!
     * 
     * @return DOCUMENT ME!
     * @throws BusinessException
     */
    public QueryAlertEventResponse queryAlertEvent(final String msisdn, final String deviceSerial,
            final Date startTime, final Date endTime, final int pageNo, final int pageSize) throws BusinessException {
        final QueryAlertEventRequest dataObject = new QueryAlertEventRequest();
        dataObject.setMsisdn(msisdn);

        final DeviceRequest deviceRequest = new DeviceRequest();
        deviceRequest.setSerial(deviceSerial);
        dataObject.setDevice(deviceRequest);
        
        String invokedMethod = "qAE";
             

        final SimpleDateFormat queryTimeFormat = new SimpleDateFormat(QUERY_TIME_PATTERN, Locale.US);
        if (null != startTime) {
            dataObject.setStartTime(queryTimeFormat.format(startTime));
        }
        if (null != endTime) {
            dataObject.setEndTime(queryTimeFormat.format(endTime));
        }
        dataObject.setPageNum(pageNo);
        dataObject.setPageSize(pageSize);
        
        LOG.info(
                "msisdn:"+msisdn+"\n"+
                "deviceSerial:"+deviceSerial+"\n"+
                "invoked method:"+invokedMethod+"\n"+
                "startTime:"+dataObject.getStartTime()+"\n"+
                "endTime:"+dataObject.getEndTime()+"\n"+
                "pageNo:"+pageNo+"\n"+
                "pageSize:"+pageSize
                );

        QueryAlertEventResponse response = null;

        try {
            final String responseJSONStr = HttpConnectionUtil.postJsonData(invokedMethod, dataObject);
            // final String responseJSONStr =
            // "{\"alertEvents\":[{\"time\":\"2015/04/22 00:00:00\",\"pic\":\"http://www.fetnet.net/pic/1232321232\",\"device\":{\"type\":\"磁簧\",\"serial\":\"7893569\",\"pSerial\":\"FET0005678TWNTONY\"}},{\"time\":\"2015/04/20 00:00:00\",\"pic\":\"http://www.fetnet.net/pic/1332366232\",\"device\":{\"type\":\"紅外線偵測器\",\"serial\":\"7893569\",\"pSerial\":\"FET0005678TWNTONY\"}}]}";
            LOG.info("queryAlertEvent response JSON:" + responseJSONStr);
            final Gson gson = new Gson();
            response = gson.fromJson(responseJSONStr, QueryAlertEventResponse.class);
            if (null == response) {
                throw new BusinessException();
            } else if ("S".equals(response.getResult().getStatus())) {
                LOG.debug("queryAlertEvent success");
            } else {
                throw new BusinessException(response.getResult().getErrCode());
            }
        } catch (Exception e) {
            final String errCode = ErrorCodeUtil.buildErrorCode(SmartHomeConstants.DOMAIN_CODE,
                    SmartHomeConstants.SYSTEM_CODE, ErrorType.WebService, "005");
            LOG.error(errCode, e.getMessage(), e);
            if (null == response || null == response.getResult()) {
                throw new BusinessException(MessageUtil.getStringMessage(ErrorCodeUtil.buildErrorMessageKey(ErrorType.WebService, "005")));
            } else {
                throw new BusinessException(response.getResult().getMsg());
            }
        }

        return response;
    }

    /**
     * DOCUMENT ME!
     * 
     * @param msisdn
     *            DOCUMENT ME!
     * @param deviceSerial
     *            DOCUMENT ME!
     * 
     * @return DOCUMENT ME!
     * @throws BusinessException
     */
    public QueryAlertNoticeResponse queryAlertNotice(final String msisdn, final String deviceSerial)
            throws BusinessException {
        final CommonQueryDeviceRequest dataObject = new CommonQueryDeviceRequest();
        dataObject.setMsisdn(msisdn);

        final DeviceRequest deviceRequest = new DeviceRequest();
        deviceRequest.setSerial(deviceSerial);
        dataObject.setDevice(deviceRequest);

        String invokedMethod = "qAN";
        LOG.info("msisdn:"+msisdn+"\n"+"deviceSerial:"+deviceSerial+"\n"+"invoked method:"+invokedMethod);

        QueryAlertNoticeResponse response = null;
        try {
            final String responseJSONStr = HttpConnectionUtil.postJsonData(invokedMethod, dataObject);
            // final String responseJSONStr =
            // "{\"alertNotices\":[{\"value\":\"0988332211\",\"type\":\"sms\",\"status\":\"1\"},{\"value\":\"abcde@fareastone.com.tw\",\"type\":\"email\",\"status\":\"1\"},{\"value\":\"p1232423@fareastone.com.tw\",\"type\":\"email\",\"status\":\"2\"}]}";
            LOG.info("queryAlertNotice response JSON:" + responseJSONStr);

            final Gson gson = new Gson();
            response = gson.fromJson(responseJSONStr, QueryAlertNoticeResponse.class);
            if (null == response) {
                throw new BusinessException();
            } else if ("S".equals(response.getResult().getStatus())) {
                LOG.debug("queryAlertNotice success");
            } else {
                throw new BusinessException(response.getResult().getErrCode());
            }
        } catch (Exception e) {
            final String errCode = ErrorCodeUtil.buildErrorCode(SmartHomeConstants.DOMAIN_CODE,
                    SmartHomeConstants.SYSTEM_CODE, ErrorType.WebService, "006");
            LOG.error(errCode, e.getMessage(), e);
            if (null == response || null == response.getResult()) {
                throw new BusinessException(MessageUtil.getStringMessage(ErrorCodeUtil.buildErrorMessageKey(ErrorType.WebService, "006")));
            } else {
                throw new BusinessException(response.getResult().getMsg());
            }
        }

        return response;
    }

    /**
     * DOCUMENT ME!
     * 
     * @param msisdn
     *            DOCUMENT ME!
     * @param deviceSerial
     *            DOCUMENT ME!
     * @param type
     *            DOCUMENT ME!
     * @param value
     *            DOCUMENT ME!
     * 
     * @return DOCUMENT ME!
     * @throws BusinessException
     */
    public CommonResponse addAlertNotice(final String msisdn, final String deviceSerial, final String type,
            final String value) throws BusinessException {
        final ModifyAlertNoticeRequest dataObject = new ModifyAlertNoticeRequest();
        dataObject.setMsisdn(msisdn);

        final DeviceRequest deviceRequest = new DeviceRequest();
        deviceRequest.setSerial(deviceSerial);
        dataObject.setDevice(deviceRequest);

        final ModifyAlertNotice alertNoticeRequest = new ModifyAlertNotice();
        alertNoticeRequest.setType(type);
        alertNoticeRequest.setValue(value);
        dataObject.setAlertNotice(alertNoticeRequest);

        String invokedMethod = "aAN";
        LOG.info("msisdn:"+msisdn+"\n"+"deviceSerial:"+deviceSerial+"\n"+"type:"+type+"\n"+"value:"+value+"\n"+"invoked method:"+invokedMethod);
        
        CommonResponse response = null;

        try {
            final String responseJSONStr = HttpConnectionUtil.postJsonData(invokedMethod, dataObject);
            // final String responseJSONStr =
            // "{\"result\":{\"status\":\"F\",\"msg\":\"email 重複\",\"errCode\":\"ERR00244311\"}}";
            // final String responseJSONStr ="{\"result\":{\"status\":\"S\"}}";
            LOG.info("addAlertNotice response JSON:" + responseJSONStr);

            final Gson gson = new Gson();
            response = gson.fromJson(responseJSONStr, CommonResponse.class);
            if (null == response) {
                throw new BusinessException(DeviceAPIResultCode.deviceAPIConnectionFail.getCode());
            } else if ("S".equals(response.getResult().getStatus())) {
                LOG.debug("addAlertNotice success");
            } else {
                throw new BusinessException(response.getResult().getErrCode());
            }
        } catch (Exception e) {
            final String errCode = ErrorCodeUtil.buildErrorCode(SmartHomeConstants.DOMAIN_CODE,
                    SmartHomeConstants.SYSTEM_CODE, ErrorType.WebService, "007");
            LOG.error(errCode, e.getMessage(), e);
            if (null == response || null == response.getResult()) {
                throw new BusinessException(MessageUtil.getStringMessage(ErrorCodeUtil.buildErrorMessageKey(ErrorType.WebService, "007")));
            } else {
                throw new BusinessException(response.getResult().getMsg());
            }
        }

        return response;
    }

    /**
     * DOCUMENT ME!
     * 
     * @param msisdn
     *            DOCUMENT ME!
     * @param deviceSerial
     *            DOCUMENT ME!
     * @param type
     *            DOCUMENT ME!
     * @param value
     *            DOCUMENT ME!
     * 
     * @return DOCUMENT ME!
     * @throws BusinessException
     */
    public CommonResponse removeAlertNotice(final String msisdn, final String deviceSerial, final String type,
            final String value) throws BusinessException {
        final ModifyAlertNoticeRequest dataObject = new ModifyAlertNoticeRequest();
        dataObject.setMsisdn(msisdn);

        final DeviceRequest deviceRequest = new DeviceRequest();
        deviceRequest.setSerial(deviceSerial);
        dataObject.setDevice(deviceRequest);

        final ModifyAlertNotice alertNoticeRequest = new ModifyAlertNotice();
        alertNoticeRequest.setType(type);
        alertNoticeRequest.setValue(value);
        dataObject.setAlertNotice(alertNoticeRequest);

        String invokedMethod = "rAN";
        LOG.info("msisdn:"+msisdn+"\n"+"deviceSerial:"+deviceSerial+"\n"+"type:"+type+"\n"+"value:"+value+"\n"+"invoked method:"+invokedMethod);       
        
        CommonResponse response = null;

        try {
            final String responseJSONStr = HttpConnectionUtil.postJsonData(invokedMethod, dataObject);
            // final String responseJSONStr =
            // "{\"result\":{\"status\":\"F\",\"msg\":\"email 重複\",\"errCode\":\"ERR00244311\"}}";
            // final String responseJSONStr = "{\"result\":{\"status\":\"S\"}}";
            LOG.info("removeAlertNotice response JSON:" + responseJSONStr);

            final Gson gson = new Gson();
            response = gson.fromJson(responseJSONStr, AlertNoticeResponse.class);
            if (null == response) {
                throw new BusinessException(DeviceAPIResultCode.deviceAPIConnectionFail.getCode());
            } else if ("S".equals(response.getResult().getStatus())) {
                LOG.debug("removeAlertNotice success");
            } else {
                throw new BusinessException(response.getResult().getErrCode());
            }
        } catch (Exception e) {
            final String errCode = ErrorCodeUtil.buildErrorCode(SmartHomeConstants.DOMAIN_CODE,
                    SmartHomeConstants.SYSTEM_CODE, ErrorType.WebService, "008");
            LOG.error(errCode, e.getMessage(), e);
            if (null == response || null == response.getResult()) {
                throw new BusinessException(MessageUtil.getStringMessage(ErrorCodeUtil.buildErrorMessageKey(ErrorType.WebService, "008")));
            } else {
                throw new BusinessException(response.getResult().getMsg());
            }
        }

        return response;
    }

    public static Date parseDate(final String dateTimeString) throws BusinessException {
        Date result = null;
        try {
            if (StringUtils.isNotBlank(dateTimeString)) {
                if (UI_DATETIME_PATTERN.length() == dateTimeString.length()) {
                    final SimpleDateFormat queryDateTimeFormat = new SimpleDateFormat(UI_DATETIME_PATTERN, Locale.US);
                    result = queryDateTimeFormat.parse(dateTimeString);
                } else if (UI_DATE_PATTERN.length() == dateTimeString.length()) {
                    final SimpleDateFormat queryDateTimeFormat = new SimpleDateFormat(UI_DATE_PATTERN, Locale.US);
                    result = queryDateTimeFormat.parse(dateTimeString);
                } else {
                    final String errCode = ErrorCodeUtil.buildErrorCode(SmartHomeConstants.DOMAIN_CODE,
                            SmartHomeConstants.SYSTEM_CODE, ErrorType.UI, "001");
                    throw new BusinessException(MessageUtil.getStringMessage(ErrorCodeUtil.buildErrorMessageKey(ErrorType.UI, "001")));
                }
            }
        } catch (Exception e) {
            final String errCode = ErrorCodeUtil.buildErrorCode(SmartHomeConstants.DOMAIN_CODE,
                    SmartHomeConstants.SYSTEM_CODE, ErrorType.UI, "001");
            LOG.error(errCode, e.getMessage(), e);
            throw new BusinessException(MessageUtil.getStringMessage(ErrorCodeUtil.buildErrorMessageKey(ErrorType.UI, "001")));
        }
        return result;
    }
}
