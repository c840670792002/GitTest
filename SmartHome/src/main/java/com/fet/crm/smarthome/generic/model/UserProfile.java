package com.fet.crm.smarthome.generic.model;

import java.io.Serializable;

public class UserProfile implements Serializable {
    private static final long serialVersionUID = -901357025659554296L;
    private String fetuid;
    private String msisdn;
    private String nickName;
    private String subscriberId;

    public String getFetuid() {
        return fetuid;
    }

    public void setFetuid(String fetuid) {
        this.fetuid = fetuid;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getSubscriberId() {
        return subscriberId;
    }

    public void setSubscriberId(String subscriberId) {
        this.subscriberId = subscriberId;
    }

}
