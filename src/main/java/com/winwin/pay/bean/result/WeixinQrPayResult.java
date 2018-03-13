package com.winwin.pay.bean.result;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("xml")
public class WeixinQrPayResult extends PayBaseResult{
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
    private String totalFee;
    
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
    
    /**
     * <pre>二维码链接
     * code_url
     * 否
     * String
     * https://qr.alipay.com/bax02824jttnhbmik36x0033
     * 可将该参数值生成二维码展示出来进行扫码支付
     * </pre>
     */
    @XStreamAlias("code_url")
    private String codeUrl;
    
    /**
     * <pre>支付宝订单号
     * trade_no
     * 否
     * String
     * 
     * 支付宝JS支付参数
     * </pre>
     */
    @XStreamAlias("trade_no")
    private String tradeNo;
    
    
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

	public String getTotalFee() {
		return totalFee;
	}

	public void setTotalFee(String totalFee) {
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

	public String getCodeUrl() {
		return codeUrl;
	}

	public void setCodeUrl(String codeUrl) {
		this.codeUrl = codeUrl;
	}

	public String getTradeNo() {
		return tradeNo;
	}

	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}

	public String getPayInfo() {
		return payInfo;
	}

	public void setPayInfo(String payInfo) {
		this.payInfo = payInfo;
	}

	public String getPrepayId() {
		return prepayId;
	}

	public void setPrepayId(String prepayId) {
		this.prepayId = prepayId;
	}

	public String getDeviceInfo() {
		return deviceInfo;
	}

	public void setDeviceInfo(String deviceInfo) {
		this.deviceInfo = deviceInfo;
	}

//	public String getDeviceInfo() {
//		return deviceInfo;
//	}

//	public void setDeviceInfo(String deviceInfo) {
//		this.deviceInfo = deviceInfo;
//	}
//
//	public String getPay_Info() {
//		return pay_Info;
//	}
//
//	public void setPay_Info(String pay_Info) {
//		this.pay_Info = pay_Info;
//	}
//
//	public String getPrepay_Id() {
//		return prepay_Id;
//	}
//
//	public void setPrepay_Id(String prepay_Id) {
//		this.prepay_Id = prepay_Id;
//	}
//
//	public String getTrade_No() {
//		return trade_No;
//	}
//
//	public void setTrade_No(String trade_No) {
//		this.trade_No = trade_No;
//	}
//
//	public String getCode_url() {
//		return code_url;
//	}
//
//	public void setCode_url(String code_url) {
//		this.code_url = code_url;
//	}
//
//	public String getTime_End() {
//		return time_End;
//	}
//
//	public void setTime_End(String time_End) {
//		this.time_End = time_End;
//	}
//
//	public String getTrade_Type() {
//		return trade_Type;
//	}
//
//	public void setTrade_Type(String trade_Type) {
//		this.trade_Type = trade_Type;
//	}
//
//	public String getTotal_Fee() {
//		return total_Fee;
//	}
//
//	public void setTotal_Fee(String total_Fee) {
//		this.total_Fee = total_Fee;
//	}
//
//	public String getOut_trade_No() {
//		return out_trade_No;
//	}
//
//	public void setOut_trade_No(String out_trade_No) {
//		this.out_trade_No = out_trade_No;
//	}
//
//	public String getMch_transaction_Id() {
//		return mch_transaction_Id;
//	}
//
//	public void setMch_transaction_Id(String mch_transaction_Id) {
//		this.mch_transaction_Id = mch_transaction_Id;
//	}
//
//	public String getOut_transaction_Id() {
//		return out_transaction_Id;
//	}
//
//	public void setOut_transaction_Id(String out_transaction_Id) {
//		this.out_transaction_Id = out_transaction_Id;
//	}
}
