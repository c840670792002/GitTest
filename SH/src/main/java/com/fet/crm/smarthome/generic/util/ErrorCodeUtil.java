package com.fet.crm.smarthome.generic.util;

/**
 * DOCUMENT ME!
 * 
 * @author Paul Chan
 * @version 1.0.0.0
 */
public final class ErrorCodeUtil {
    private static final char DASH_CHAR = '-';

    private ErrorCodeUtil() {

    }

    /**
     * 依照 Error Code Pattern 產生 errorCode Domain code-系統代碼(6)-錯誤類別(3)-流水碼(3)
     * 
     * 
     * @param domainCode
     *            Domain Code
     * @param systemCode
     *            系統代碼
     * @param errorType
     *            錯誤類別
     * @param serialNo
     *            錯誤流水號
     * 
     * @return error code
     */
    public static String buildErrorCode(final String domainCode, final String systemCode, final ErrorType errorType,
            final String serialNo) {
        final StringBuffer errorCode = new StringBuffer(18);
        errorCode.append(domainCode);
        errorCode.append(DASH_CHAR);
        errorCode.append(systemCode);
        errorCode.append(DASH_CHAR);
        errorCode.append(errorType.getCode());
        errorCode.append(DASH_CHAR);
        errorCode.append(serialNo);
        return errorCode.toString();
    }

    /**
     * 取得error message
     * 
     * 
     * @param errorType
     *            錯誤類別
     * @param serialNo
     *            錯誤流水號
     * 
     * @return error code
     */
    public static String buildErrorMessageKey(final ErrorType errorType, final String serialNo) {
        final StringBuffer errorCode = new StringBuffer(18);
        errorCode.append("err_code-");
        errorCode.append(errorType.getCode());
        errorCode.append(DASH_CHAR);
        errorCode.append(serialNo);
        return errorCode.toString();
    }
}
