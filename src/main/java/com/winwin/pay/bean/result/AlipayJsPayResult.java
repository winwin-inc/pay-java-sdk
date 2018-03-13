package com.winwin.pay.bean.result;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("xml")
public class AlipayJsPayResult extends PayBaseResult {
    /**
     * 支付宝订单号
     * trade_no
     * 否
     * String(32)
     * 支付宝JS支付参数
     */
    @XStreamAlias("trade_no")
    private String tradeNo;

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }
}
