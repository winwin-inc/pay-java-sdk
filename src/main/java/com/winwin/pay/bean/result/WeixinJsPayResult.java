package com.winwin.pay.bean.result;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("xml")
public class WeixinJsPayResult extends PayBaseResult {
    /**
     * <pre>预支付会话标识
     * prepay_id
     * 否
     * String
     *
     * 预支付会话标识
     */
    @XStreamAlias("prepay_id")
    private String prepayId;

    /**
     * <pre>js支付信息
     * pay_info
     * 否
     * String
     *
     * json格式的字符串，作用于js支付时的参数
     * </pre>
     */
    @XStreamAlias("pay_info")
    private String payInfo;

    public String getPrepayId() {
        return prepayId;
    }

    public void setPrepayId(String prepayId) {
        this.prepayId = prepayId;
    }

    public String getPayInfo() {
        return payInfo;
    }

    public void setPayInfo(String payInfo) {
        this.payInfo = payInfo;
    }

}
