package com.winwin.pay.bean.result;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * <pre>
 *  查询订单 返回结果对象
 * Created by Binary Wang on 2016-10-24.
 * 注释中各行每个字段描述对应如下：
 * <li>字段名
 * <li>变量名
 * <li>是否必填
 * <li>类型
 * <li>示例值
 * <li>描述
 * </pre>
 *
 * @author <a href="https://github.com/binarywang">Binary Wang</a>
 */
@XStreamAlias("xml")
public class PayOrderQueryResult extends PayBaseResult {

    /**
     * <pre>设备号
     * device_info
     * 否
     * String(32)
     * 013467007045764
     * 微信支付分配的终端设备号，
     * </pre>
     */
    @XStreamAlias("device_info")
    private String deviceInfo;

    /**
     * <pre>用户标识
     * openid
     * 是
     * String(128)
     * oUpF8uMuAJO_M2pxb1Q9zNjWeS6o
     * 用户在商户appid下的唯一标识
     * </pre>
     */
    @XStreamAlias("openid")
    private String openid;

    /**
     * <pre>是否关注公众账号
     * is_subscribe
     * 否
     * String(1)
     * Y
     * 用户是否关注公众账号，Y-关注，N-未关注，仅在公众账号类型支付有效
     * </pre>
     */
    @XStreamAlias("is_subscribe")
    private String isSubscribe;

    /**
     * <pre>交易类型
     * trade_type
     * 是
     * String(16)
     * JSAPI
     * 调用接口提交的交易类型，取值如下：JSAPI，NATIVE，APP，MICROPAY，详细说明见参数规定
     * </pre>
     */
    @XStreamAlias("trade_type")
    private String tradeType;

    /**
     * <pre>交易状态
     * trade_state
     * 是
     * String(32)
     * SUCCESS
     * SUCCESS—支付成功,REFUND—转入退款,NOTPAY—未支付,CLOSED—已关闭,REVOKED—已撤销（刷卡支付）,USERPAYING--用户支付中,PAYERROR--支付失败(其他原因，如银行返回失败)
     * </pre>
     */
    @XStreamAlias("trade_state")
    private String tradeState;

    /**
     * <pre>付款银行
     * bank_type
     * 是
     * String(16)
     * CMC
     * 银行类型，采用字符串类型的银行标识
     * </pre>
     */
    @XStreamAlias("bank_type")
    private String bankType;

    /**
     * <pre>订单金额
     * total_fee
     * 是
     * Int
     * 100
     * 订单总金额，单位为分
     * </pre>
     */
    @XStreamAlias("total_fee")
    private Integer totalFee;

    /**
     * <pre>货币种类
     * fee_type
     * 否
     * String(8)
     * CNY
     * 货币类型，符合ISO 4217标准的三位字母代码，默认人民币：CNY，其他值列表详见货币类型
     * </pre>
     */
    @XStreamAlias("fee_type")
    private String feeType;

    /**
     * <pre>微信支付订单号
     * transaction_id
     * 是
     * String(32)
     * 1009660380201506130728806387
     * 微信支付订单号
     * </pre>
     */
    @XStreamAlias("transaction_id")
    private String transactionId;

    /**
     * <pre>微信支付订单号
     * transaction_id
     * 是
     * String(32)
     * 1009660380201506130728806387
     * 微信支付订单号
     * </pre>
     */
    @XStreamAlias("out_transaction_id")
    private String outTransactionId;
    /**
     * <pre>商户订单号
     * out_trade_no
     * 是
     * String(32)
     * 20150806125346
     * 商户系统的订单号，与请求一致。
     * </pre>
     */
    @XStreamAlias("out_trade_no")
    private String outTradeNo;
    /**
     * <pre>附加数据
     * attach
     * 否
     * String(128)
     * 深圳分店
     * 附加数据，原样返回
     * </pre>
     */
    @XStreamAlias("attach")
    private String attach;
    /**
     * <pre>支付完成时间
     * time_end
     * 是
     * String(14)
     * 20141030133525
     * 订单支付时间，格式为yyyyMMddHHmmss，如2009年12月25日9点10分10秒表示为20091225091010。其他详见时间规则
     * </pre>
     */
    @XStreamAlias("time_end")
    private String timeEnd;
    /**
     * <pre>交易状态描述
     * trade_state_desc
     * 是
     * String(256)
     * 支付失败，请重新下单支付
     * 对当前查询订单状态的描述和下一步操作的指引
     * </pre>
     */
    @XStreamAlias("trade_state_desc")
    private String tradeStateDesc;

    public String getDeviceInfo() {
        return deviceInfo;
    }

    public void setDeviceInfo(String deviceInfo) {
        this.deviceInfo = deviceInfo;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getIsSubscribe() {
        return isSubscribe;
    }

    public void setIsSubscribe(String isSubscribe) {
        this.isSubscribe = isSubscribe;
    }

    public String getTradeType() {
        return tradeType;
    }

    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }

    public String getTradeState() {
        return tradeState;
    }

    public void setTradeState(String tradeState) {
        this.tradeState = tradeState;
    }

    public String getBankType() {
        return bankType;
    }

    public void setBankType(String bankType) {
        this.bankType = bankType;
    }

    public Integer getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(Integer totalFee) {
        this.totalFee = totalFee;
    }

    public String getFeeType() {
        return feeType;
    }

    public void setFeeType(String feeType) {
        this.feeType = feeType;
    }

    public String getOutTransactionId() {
        return outTransactionId;
    }

    public void setOutTransactionId(String outTransactionId) {
        this.outTransactionId = outTransactionId;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getAttach() {
        return attach;
    }

    public void setAttach(String attach) {
        this.attach = attach;
    }

    public String getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(String timeEnd) {
        this.timeEnd = timeEnd;
    }

    public String getTradeStateDesc() {
        return tradeStateDesc;
    }

    public void setTradeStateDesc(String tradeStateDesc) {
        this.tradeStateDesc = tradeStateDesc;
    }
}
