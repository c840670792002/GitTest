package com.fet.crm.smarthome.generic.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

import com.fet.generic.logger.ILogger;
import com.fet.generic.logger.LoggerFactory;

/**
 * ===================================================================== <br>
 * Licensed Materials - Property of BlueTouch Digital Technology Inc., Ltd. <br>
 * 藍科數位科技股份有限公司版權所有翻印必究 <br>
 * (C) Copyright BlueTouch Digital Technology Inc., Ltd. 2001 All Rights
 * Reserved. <br>
 * 日期：2012/6/19 <br>
 * 作者：Eric Wei <br>
 * 程式代號: RegularExpressionUtil.java <br>
 * 程式說明: 正規表示式的比對工具<br>
 * ======================================================================
 */
public final class RegularExpressionUtil {
    private static final ILogger LOG = LoggerFactory.getLogger(RegularExpressionUtil.class);
    private static Map<String, Pattern> patternMap;

    static {
        patternMap = new HashMap<String, Pattern>();

        final List<String> tags = MessageUtil.getArrayMessage("regular.expression.tag");

        for (final String tagName : tags) {
            if (!patternMap.containsKey(tagName)) {
                buildPattern(tagName);
            }
        }
    }

    private static void buildPattern(final String tagName) {
        patternMap.put(tagName, Pattern.compile("\\<" + tagName + "\\>(.*?)\\<\\/" + tagName + "\\>"));
    }

    private RegularExpressionUtil() {

    }

    /**
     * 取得第一組比對成功的Tag Value
     * 
     * @param xmlString
     * @param tagName
     * @return String
     */
    public static String getTagValue(final String xmlString, final String tagName) {
        String returnStr = null;

        try {
            final Pattern pattern = getPattern(tagName);
            final Matcher matcher = pattern.matcher(xmlString);
            final boolean matchFound = matcher.find();

            if (matchFound) {
                returnStr = matcher.group(1);
            }
        } catch (Exception e) {
            LOG.info("Exception occurs in RegularExpressionUtil.getTagValue", e);
        }

        return returnStr;
    }

    /**
     * DOCUMENT ME!
     * 
     * @param xmlString
     *            DOCUMENT ME!
     * @param tagName
     *            DOCUMENT ME!
     * 
     * @return DOCUMENT ME!
     */
    public static String[] getTagValueArray(final String xmlString, final String tagName) {
        final List<String> returnStr = new ArrayList<String>();

        try {
            final Pattern pattern = getPattern(tagName);
            final Matcher matcher = pattern.matcher(xmlString);
            int count;

            while (matcher.find()) {
                count = matcher.groupCount();
                returnStr.add(StringUtils.defaultString(matcher.group(count)));
            }
        } catch (Exception e) {
            LOG.info("Exception occurs in RegularExpressionUtil.getTagValue", e);
        }

        return returnStr.toArray(new String[returnStr.size()]);
    }

    private static Pattern getPattern(final String tagName) {
        if (!patternMap.containsKey(tagName)) {
            buildPattern(tagName);
        }

        return patternMap.get(tagName);
    }
}
