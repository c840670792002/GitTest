package com.fet.crm.smarthome.generic.util;

import com.fet.generic.logger.ILogger;
import com.fet.generic.logger.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * DOCUMENT ME!
 * 
 * @author Paul Chan
 * @version 1.0.0.0
 */
public final class MessageUtil {
    private static final ILogger LOG = LoggerFactory.getLogger(MessageUtil.class);
    private static final String PROPERTIES_FILE_NAME = "smarthome";
    private static final ResourceBundle DEFAULT_RESOURCE_BUNDLE = ResourceBundle.getBundle(PROPERTIES_FILE_NAME);

    private MessageUtil() {

    }

    /**
     * DOCUMENT ME!
     * 
     * @param messageKey
     *            DOCUMENT ME!
     * 
     * @return DOCUMENT ME!
     */
    public static String getStringMessage(final String messageKey) {
        return getStringMessage(messageKey, null);
    }

    /**
     * DOCUMENT ME!
     * 
     * @param messageKey
     *            DOCUMENT ME!
     * @param defaultString
     *            DOCUMENT ME!
     * 
     * @return DOCUMENT ME!
     */
    public static String getStringMessage(final String messageKey, final String defaultString) {

        String result = null;
        if (DEFAULT_RESOURCE_BUNDLE.containsKey(messageKey)) {
            result = DEFAULT_RESOURCE_BUNDLE.getString(messageKey);
        } else {
            LOG.warn("message key : " + messageKey + " not found");
        }
        if (null == result) {
            result = defaultString;
        }
        return result;
    }

    /**
     * DOCUMENT ME!
     * 
     * @param messageKey
     *            DOCUMENT ME!
     * 
     * @return DOCUMENT ME!
     */
    public static Integer getInteger(final String messageKey) {
        return getInteger(messageKey, -1);
    }

    /**
     * DOCUMENT ME!
     * 
     * @param messageKey
     *            DOCUMENT ME!
     * @param defaultValue
     *            DOCUMENT ME!
     * 
     * @return DOCUMENT ME!
     */
    public static Integer getInteger(final String messageKey, final Integer defaultValue) {
        try {
            return getInteger(messageKey, false);
        } catch (NumberFormatException e) {
            LOG.debug(SmartHomeConstants.IGNORED, e);
            return defaultValue;
        }
    }

    /**
     * DOCUMENT ME!
     * 
     * @param messageKey
     *            DOCUMENT ME!
     * @param throwException
     *            DOCUMENT ME!
     * 
     * @return DOCUMENT ME!
     * 
     * @throws NumberFormatException
     *             DOCUMENT ME!
     */
    public static Integer getInteger(final String messageKey, final boolean throwException)
            throws NumberFormatException {
        Integer result = null;
        final String msg = getStringMessage(messageKey);

        try {
            result = Integer.parseInt(msg);
        } catch (NumberFormatException e) {
            if (throwException) {
                throw e;
            } else {
                LOG.debug(SmartHomeConstants.IGNORED, e);
            }
        }

        return result;
    }

    /**
     * DOCUMENT ME!
     * 
     * @param messageKey
     *            DOCUMENT ME!
     * 
     * @return DOCUMENT ME!
     */
    public static List<String> getArrayMessage(final String messageKey) {
        final List<String> result = new ArrayList<String>();
        final String msg = getStringMessage(messageKey);
        final String[] msgAry = msg.split(",");

        for (final String message : msgAry) {
            result.add(message);
        }

        return result;
    }
}
