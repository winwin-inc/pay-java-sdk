package com.winwin.pay.bean.request;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.winwin.pay.constant.PayConstants;
import com.winwin.pay.exception.PayException;

@XStreamAlias("xml")
public class WeixinQrPayRequest extends PayBaseRequest{
    /**
     * <pre>
     * 商户订单号
     * out_trade_no
     * String(32)
     * 20150806125346
     * 商户系统内部的订单号
     * </pre>
     */
    @XStreamAlias("out_trade_no")
    private String outTradeNo;
    
    /**
     * <pre>
     * 总金额
     * total_fee
     * Int
     * 88
     * 总金额
     * </pre>
     */
    @XStreamAlias("total_fee")
    private int totalFee;
    
    /**
     * <pre>
     * 商品描述
     * body
     * String(127)
     * 商品描述
     * </pre>
     */
    @XStreamAlias("body")
    private String body;
    
    /**
     * <pre>
     * 附加信息	
     * attach
     * String(128)
     * 商户附加信息，可做扩展参数
     * </pre>
     */
    @XStreamAlias("attach")
    private String attach;
    
    /**
     * <pre>
     * 终端IP	
     * spbill_create_ip
     * String(16)
     * 123.12.12.123
     * 订单生成的机器 IP
     * </pre>
     */
    @XStreamAlias("spbill_create_ip")
    private String spbillCreateIp;

    /**
     * <pre>
     * 订单生成时间	
     * time_start
     * String(14)
     * 20091225091010
     * 订单生成时间
     * </pre>
     */
    @XStreamAlias("time_start")
    private String timeStart;
    
    /**
     * <pre>
     * 订单超时时间	
     * time_expire
     * String(14)
     * 20091225091010
     * 订单失效时间
     * </pre>
     */
    @XStreamAlias("time_expire")
    private String timeExpire;
    
    /**
     * <pre>
     * 商品标记	
     * goods_tag
     * String(32)
     * 商品标记
     * </pre>
     */
    @XStreamAlias("goods_tag")
    private String goodsTag;
    
    /**
     * <pre>
     * 是否限制信用卡	
     * limit_pay
     * String(32)
     * no_credit
     * 指定不能使用信用卡支付
     * </pre>
     */
    @XStreamAlias("limit_pay")
    private String limitPay;
    
    /**
     * <pre>
     * 商品ID
     * product_id
     * String(32)
     * 12235413214070356458058
     * 预留字段此 id 为静态可打印的二维码中包含的商品 ID，商户自行维护
     * </pre>
     */
    @XStreamAlias("product_id")
    private String productId;
    
    /**
     * <pre>
     * 通知地址	
     * notify_url
     * String(255)
     * http://notify_url.demo
     * 接收异步通知的URL，需给绝对路径
     * </pre>
     */
    @XStreamAlias("notify_url")
    private String notifyUrl;
    
    /**
     * <pre>
     * 小程序	ID
     * wx_miniappid
     * String(32)
     * wxd678efh567hg6787
     * 微信分配的小程序ID
     * </pre>
     */
    @XStreamAlias("wx_miniappid")
    private String wxMiniappId;

    public WeixinQrPayRequest() {
		this.setMethod(PayConstants.PayMethod.TRADE_WEIXIN_QR);
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

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getAttach() {
		return attach;
	}

	public void setAttach(String attach) {
		this.attach = attach;
	}

	public String getSpbillCreateIp() {
		return spbillCreateIp;
	}

	public void setSpbillCreateIp(String spbillCreateIp) {
		this.spbillCreateIp = spbillCreateIp;
	}

	public String getTimeStart() {
		return timeStart;
	}

	public void setTimeStart(String timeStart) {
		this.timeStart = timeStart;
	}

	public String getTimeExpire() {
		return timeExpire;
	}

	public void setTimeExpire(String timeExpire) {
		this.timeExpire = timeExpire;
	}

	public String getGoodsTag() {
		return goodsTag;
	}

	public void setGoodsTag(String goodsTag) {
		this.goodsTag = goodsTag;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getNotifyUrl() {
		return notifyUrl;
	}

	public void setNotifyUrl(String notifyUrl) {
		this.notifyUrl = notifyUrl;
	}

	public String getWxMiniappId() {
		return wxMiniappId;
	}

	public void setWxMiniappId(String wxMiniappId) {
		this.wxMiniappId = wxMiniappId;
	}

	@Override
	protected void checkConstraints() throws PayException {
	}
}
