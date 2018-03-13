package com.winwin.pay.bean.request;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.winwin.pay.constant.PayConstants;
import com.winwin.pay.exception.PayException;

@XStreamAlias("xml")
public class MicropayRequest extends PayBaseRequest {
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
     * 授权码
     * auth_code
     * String(128)
     * 134765033631695703
     * 扫码支付授权码
     * </pre>
     */
    @XStreamAlias("auth_code")
    private String authCode;

    /**
     * <pre>
     * 操作员
     * op_user
     * String(32)
     * 1323
     * 操作员账号
     * </pre>
     */
    @XStreamAlias("op_user")
    private String opUser;

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

    public MicropayRequest() {
        this.setMethod(PayConstants.PayMethod.TRADE_MICROPAY);
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

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    public String getOpUser() {
        return opUser;
    }

    public void setOpUser(String opUser) {
        this.opUser = opUser;
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

    public String getLimitPay() {
        return limitPay;
    }

    public void setLimitPay(String limitPay) {
        this.limitPay = limitPay;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    @Override
    protected void checkConstraints() throws PayException {

    }
}
