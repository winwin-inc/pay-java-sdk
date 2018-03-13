package com.winwin.pay.bean.result;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("xml")
public class AlipayQrPayResult extends PayBaseResult {
    /**
     * <pre>设备号
     * code_url
     * 是
     * String(32)
     * 400892200120170711155736281
     * 平台交易单号
     * </pre>
     */
    @XStreamAlias("code_url")
    private String codeUrl;

    public String getCodeUrl() {
        return codeUrl;
    }

    public void setCodeUrl(String codeUrl) {
        this.codeUrl = codeUrl;
    }
}
