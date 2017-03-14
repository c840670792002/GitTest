package com.fet.crm.smarthome.generic.util;

import com.fet.generic.logger.ILogger;
import com.fet.generic.logger.LoggerFactory;
import com.google.gson.Gson;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import org.apache.http.util.ByteArrayBuffer;

/**
 * DOCUMENT ME!
 * 
 * @author Paul Chan
 * @version 1.0.0.0
 */
public final class HttpConnectionUtil {
    private static final ILogger LOG = LoggerFactory.getLogger(HttpConnectionUtil.class);
    private static final String DEVICE_API_ENCODE = MessageUtil.getStringMessage("device_api.encode");
    private static final String DEVICE_API_URL = MessageUtil.getStringMessage("device_api.url");
    private static final int DEVICE_API_TIMEOUT = Integer.valueOf(MessageUtil.getStringMessage("device_api.timeout"));
    private static final String CSP_API_ENCODE = MessageUtil.getStringMessage("csp_api.encode");
    private static final String CSP_API_URL = MessageUtil.getStringMessage("csp_api.url");
    private static final int CSP_API_TIMEOUT = Integer.valueOf(MessageUtil.getStringMessage("csp_api.timeout"));

    private HttpConnectionUtil() {

    }

    /**
     * DOCUMENT ME!
     * 
     * @param url
     *            DOCUMENT ME!
     * @param outputStream
     *            DOCUMENT ME!
     * @param charsetName
     *            DOCUMENT ME!
     * @param timeout
     *            DOCUMENT ME!
     * 
     * @return DOCUMENT ME!
     * 
     * @throws Exception
     *             DOCUMENT ME!
     */
    public static String postJsonData(final String invokeMethod, final String jsonData) throws BusinessException {
        String result = null;
        byte[] httpByte = null;
        byte[] tmp_data = null;
        URL myURL = null;
        URLConnection urlConnection = null;
        InputStream is = null;
        BufferedInputStream bis = null;
        ByteArrayBuffer baf = null;
        int responseCode = 0;
        try {
            myURL = new URL(parseUrl(invokeMethod));
            final long startTime = System.currentTimeMillis();
//            LOG.info("=============== Invoke HttpConnectionUtil.postJsonData Start ===============");
            urlConnection = myURL.openConnection();

            final HttpURLConnection httpURLConnection = (HttpURLConnection) urlConnection;
            httpURLConnection.setConnectTimeout(DEVICE_API_TIMEOUT);

            httpURLConnection.setDoOutput(true);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty("Content-Type", "application/json");
            httpURLConnection.getOutputStream().write(jsonData.getBytes(DEVICE_API_ENCODE));
            httpURLConnection.getOutputStream().flush();
            httpURLConnection.getOutputStream().close();

            responseCode = validateResponseCode(httpURLConnection.getResponseCode());
            final long endTime = System.currentTimeMillis();
//            LOG.info("=============== Invoke HttpConnectionUtil.postJsonData Finish ===============");
            LOG.info("Url : "+myURL.toString()+" Time spent : " + (endTime - startTime) + " ms");

            if (responseCode == HttpURLConnection.HTTP_OK) {
                is = validateStream(httpURLConnection.getInputStream());
            } else {
                is = validateStream(httpURLConnection.getErrorStream());
            }

            bis = new BufferedInputStream(is);
            baf = new ByteArrayBuffer(100);

            int current = 0;

            while ((current = bis.read()) != -1) {
                baf.append(current);
            }

            httpByte = baf.toByteArray();
            tmp_data = (byte[]) httpByte.clone();

            result = new String(tmp_data, DEVICE_API_ENCODE);

            if (responseCode != HttpURLConnection.HTTP_OK) {
                throw new HttpConnectionException("Return message:" + result);
            }

            return result;
        } catch (final IOException e) {
            // logger.error(e.getMessage(), e);
            throw new BusinessException(e);
        } finally {
            // inputstream, outputstream must close.
            if (null != is) {
                try {
                    is.close();
                } catch (final IOException e) {
                    LOG.debug(SmartHomeConstants.IGNORED, e);
                }
            }

            if (null != bis) {
                try {
                    bis.close();
                } catch (final IOException e) {
                    LOG.debug(SmartHomeConstants.IGNORED, e);
                }
            }
        }
    }

    /**
     * DOCUMENT ME!
     * 
     * @param fetuid
     *            DOCUMENT ME!
     * 
     * @return DOCUMENT ME!
     * 
     * @throws HttpConnectionException
     *             DOCUMENT ME!
     * @throws IOException
     *             DOCUMENT ME!
     * @throws Exception
     *             DOCUMENT ME!
     */
    public static String getCspResult(final String fetuid) throws BusinessException {
        String result = null;
        byte[] httpByte = null; // 不需要全域變數的的地方 , 盡量使用區域變數
        byte[] tmp_data = null;
        URL myURL = null;
        URLConnection urlConnection = null;
        InputStream is = null;
        BufferedInputStream bis = null;
        ByteArrayBuffer baf = null;
        int responseCode = 0;

        try {
            final String url = CSP_API_URL.replace("{fetuid}", fetuid);
            myURL = new URL(url);

            LOG.info("url:"+url);
            urlConnection = myURL.openConnection();

            final HttpURLConnection httpURLConnection = (HttpURLConnection) urlConnection;
            httpURLConnection.setConnectTimeout(CSP_API_TIMEOUT);

            responseCode = validateResponseCode(httpURLConnection.getResponseCode());
            LOG.info("responseCode:"+responseCode);

            if (HttpURLConnection.HTTP_OK == responseCode) {
                is = validateStream(urlConnection.getInputStream());
            } else {
                is = validateStream(httpURLConnection.getErrorStream());
            }

            bis = new BufferedInputStream(is);
            baf = new ByteArrayBuffer(100);

            int current = 0;

            while ((current = bis.read()) != -1) {
                baf.append(current);
            }

            httpByte = baf.toByteArray();
            tmp_data = (byte[]) httpByte.clone();

            result = new String(tmp_data, CSP_API_ENCODE);
            baf.clear();

            if (responseCode != HttpURLConnection.HTTP_OK) {
                throw new HttpConnectionException("Return message:" + result);
            }

            return result;
        } catch (Exception e) {
            // logger.error(e.getMessage(), e);
            throw new BusinessException(e);
        } finally {
            // inputstream, outputstream must close.
            if (null != is) {
                try {
                    is.close();
                } catch (final IOException e) {
                    LOG.debug(SmartHomeConstants.IGNORED, e);
                }
            }

            if (null != bis) {
                try {
                    bis.close();
                } catch (final IOException e) {
                    LOG.debug(SmartHomeConstants.IGNORED, e);
                }
            }
        }
    }

    private static String parseUrl(final String invokeMethod) {
        final StringBuffer result = new StringBuffer();
        result.append(DEVICE_API_URL);
        result.append(invokeMethod);
        LOG.info("parsed url : " + result.toString());
        return result.toString();
    }

    private static String parseJson(final Object dataObject) {
        final Gson gson = new Gson();
        final String result = gson.toJson(dataObject);
        LOG.info("parsed json String : " + result);
        return result;
    }

    /**
     * DOCUMENT ME!
     * 
     * @param invokeMethod
     *            DOCUMENT ME!
     * @param dataObject
     *            DOCUMENT ME!
     * 
     * @return DOCUMENT ME!
     * 
     * @throws Exception
     *             DOCUMENT ME!
     */
    public static String postJsonData(final String invokeMethod, final Object dataObject) throws BusinessException {
        return postJsonData(invokeMethod, parseJson(dataObject));
    }

    private static InputStream validateStream(InputStream stream) {
        LOG.debug("validateStream");
        return stream;
    }

    private static int validateResponseCode(int responseCode) {
        LOG.debug("validateResponseCode");
        return responseCode;
    }
}
