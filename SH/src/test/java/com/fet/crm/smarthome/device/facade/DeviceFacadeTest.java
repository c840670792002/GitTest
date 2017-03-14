package com.fet.crm.smarthome.device.facade;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.fet.crm.smarthome.device.facade.impl.DeviceFacadeImpl;
import com.fet.crm.smarthome.device.service.CustomerService;
import com.fet.crm.smarthome.device.service.DeviceService;
import com.fet.crm.smarthome.generic.bean.CustomerVO;
import com.fet.crm.smarthome.generic.util.BusinessException;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class DeviceFacadeTest {
    private DeviceFacadeImpl deviceFacade;
    private CustomerService customerService;
    private DeviceService deviceService;

    @Before
    public void setup() {
        deviceFacade = new DeviceFacadeImpl();
        customerService = mock(CustomerService.class);
        deviceFacade.setCustomerService(customerService);
        deviceService = mock(DeviceService.class);
        deviceFacade.setDeviceService(deviceService);
    }

    @Test
    public void testGetSubscriberId() {
        try {
            final CustomerVO customerVO = new CustomerVO();
            when(customerService.getSubscriberIdByMsisdn(anyString())).thenReturn(customerVO);
            deviceFacade.getSubscriberId("");
        } catch (BusinessException e) {
            // ignored
        }
    }

    @Test
    public void testQueryAllDevicesBySubscriberId() {
        try {
            deviceFacade.queryAllDevicesBySubscriberId("");
        } catch (BusinessException e) {
            // ignored
        }
    }

    @Test
    public void testQueryDevice() {
        try {
            deviceFacade.queryDevice("", "");
        } catch (BusinessException e) {
            // ignored
        }
    }

    @Test
    public void testQueryAlertEvent() {
        final Date now = new Date();
        try {
            deviceFacade.queryAlertEvent("0955215162", "FET0000042GZUCNBP", now, now, 0);
        } catch (BusinessException e) {
            // ignored
        }
    }

    @Test
    public void testListAlertNotice() {
        try {
            deviceFacade.listAlertNotice("0955215162", "FET0000042GZUCNBP");
        } catch (BusinessException e) {
            // ignored
        }
    }

    @Test
    public void testAddAlertNotice() {
        try {
            deviceFacade.addAlertNotice("0955215162", "FET0000042GZUCNBP", "sms", "");
        } catch (BusinessException e) {
            // ignored
        }
    }

    @Test
    public void testRemoveAlertNotice() {
        try {
            deviceFacade.removeAlertNotice("0955215162", "FET0000042GZUCNBP", "sms", "0925658101");
        } catch (BusinessException e) {
            // ignored
        }
    }
}
