package com.fet.crm.smarthome.generic.util;

/**
 * error code 中的 錯誤類別
 * 
 * 001-I/O, 002-SQL Exception, 003-Web Service(API),
 * 004-Services(業務流程API),005-UI, 006-AUTHORITY, 007-Cache
 * 
 * @author Paul Chan
 * @version 1.0.0.0
 * */
public enum ErrorType {
    IO("001"), SQLException("002"), WebService("003"), Services("004"), UI("005"), Authority("006"), Cache("007");

    private String code;

    private ErrorType(final String code) {
        this.code = code;
    }

    /**
     * DOCUMENT ME!
     * 
     * @return DOCUMENT ME!
     */
    public String getCode() {
        return code;
    }
}
