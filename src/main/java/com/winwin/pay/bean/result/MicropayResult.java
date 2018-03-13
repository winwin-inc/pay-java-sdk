package com.winwin.pay.bean.result;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("xml")
public class MicropayResult extends PayBaseResult {
    /**
     * <pre>设备号
     * out_transaction_id
     * 是
     * String(32)
     * 400892200120170711155736281
     * 平台交易单号
     * </pre>
     */
    @XStreamAlias("out_transaction_id")
    private String outTransactionId;

    /**
     * <pre>通道订单号
     * mch_transaction_id
     * 是
     * String(32)
     * 10552000579420170711155736341
     * 通道订单号
     * </pre>
     */
    @XStreamAlias("mch_transaction_id")
    private String mchTransactionId;

    /**
     * <pre>商户订单号
     * out_trade_no
     * 是
     * String(32)
     * 20150806125346
     * 商户系统内部的订单号
     * </pre>
     */
    @XStreamAlias("out_trade_no")
    private String outTradeNo;

    /**
     * <pre>总金额
     * total_fee
     * 是
     * Int(100)
     * 100
     * 总金额
     * </pre>
     */
    @XStreamAlias("total_fee")
    private int totalFee;

    /**
     * <pre>交易类型
     * trade_type
     * 是
     * String(16)
     * pay.weixin.micropay
     * pay.weixin.micropay:微信刷卡支付 pay.alipay.micropay:支付宝刷卡支付
     * </pre>
     */
    @XStreamAlias("trade_type")
    private String tradeType;

    /**
     * <pre>支付完成时间
     * time_end
     * 是
     * String(14)
     * 20091225091010
     * 支付完成时间
     * </pre>
     */
    @XStreamAlias("time_end")
    private String timeEnd;

    public String getOutTransactionId() {
        return outTransactionId;
    }

    public void setOutTransactionId(String outTransactionId) {
        this.outTransactionId = outTransactionId;
    }

    public String getMchTransactionId() {
        return mchTransactionId;
    }

    public void setMchTransactionId(String mchTransactionId) {
        this.mchTransactionId = mchTransactionId;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public int getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(int totalFee) {
        this.totalFee = totalFee;
    }

    public String getTradeType() {
        return tradeType;
    }

    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }

    public String getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(String timeEnd) {
        this.timeEnd = timeEnd;
    }
}
