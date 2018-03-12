package com.winwin.pay.testbase;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.winwin.pay.config.PayConfig;

@XStreamAlias("xml")
public class XmlPayConfig extends PayConfig {
    private String openid;

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }
}
