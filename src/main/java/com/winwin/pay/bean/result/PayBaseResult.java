package com.winwin.pay.bean.result;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * <pre>
 * 微信支付结果共用属性类
 * </pre>
 */
public abstract class PayBaseResult extends BaseResult {

    /**
     * 商户号
     */
    @XStreamAlias("mch_id")
    private String mchId;

    public String getMchId() {
        return mchId;
    }

    public void setMchId(String mchId) {
        this.mchId = mchId;
    }
}
