package com.fet.crm.smarthome.generic.util;

public enum DeviceAPIResultCode {
    success("1"),fail("0"),dataNotFound("0"), keyIncorrect("-1"),formatError("-2"), incorrectTime("-3"),noDeviceSerial("-4"), databaseConnectionFail("-5"),deviceAPIConnectionFail("null");
    private String code;
    private DeviceAPIResultCode(final String code) {
        this.code = code;
    }
    public String getCode() {
        return code;
    }
}
