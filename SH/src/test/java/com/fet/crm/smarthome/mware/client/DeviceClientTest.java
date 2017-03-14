package com.fet.crm.smarthome.mware.client;

import com.fet.crm.smarthome.generic.util.BusinessException;
import com.fet.crm.smarthome.mware.client.impl.DeviceClientImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

import org.junit.Before;
import org.junit.Test;

public class DeviceClientTest {
    private static final String QUERY_TIME_PATTERN = "yyyy/MM/dd HH:mm:ss";
    private DeviceClient deviceClient;

    @Before
    public void setup() {
        deviceClient = new DeviceClientImpl();
    }

    @Test
    public void testQueryDevice() {
        try {
            deviceClient.queryDevice("0955215162", "FETT0000042GZUCNBP");
        } catch (BusinessException e) {
            // ignored
        }
    }

    @Test
    public void testQueryAlertEvent() throws ParseException, BusinessException {
        try {
            final SimpleDateFormat queryTimeFormat = new SimpleDateFormat(QUERY_TIME_PATTERN, Locale.US);
            deviceClient.queryAlertEvent("0955215162", "FETT0000042GZUCNBP",
                    queryTimeFormat.parse("2015/04/01 00:00:00"), queryTimeFormat.parse("2015/04/03 00:00:00"), 1, 1);
        } catch (BusinessException e) {
            // ignored
        }

    }

    @Test
    public void testQueryAlertNotice() {
        try {
            deviceClient.queryAlertNotice("0955215162", "FETT0000042GZUCNBP");
        } catch (BusinessException e) {
            // ignored
        }
    }

    @Test
    public void testAddAlertNotice() {
        try {
            deviceClient.addAlertNotice("0955215162", "FETT0000042GZUCNBP", "email", "paul@bluetechnology.com.tw");
        } catch (BusinessException e) {
            // ignored
        }
    }

    @Test
    public void testRemoveAlertNotice() {
        try {
            deviceClient.removeAlertNotice("0955215162", "FETT0000042GZUCNBP", "sms", "0925658101");
        } catch (BusinessException e) {
            // ignored
        }
    }
}
