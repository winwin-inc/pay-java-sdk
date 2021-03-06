package com.winwin.pay.service;

import com.winwin.pay.bean.PayApiData;
import com.winwin.pay.bean.request.*;
import com.winwin.pay.bean.result.*;
import com.winwin.pay.bean.result.PayOrderQueryResult;
import com.winwin.pay.config.PayConfig;
import com.winwin.pay.exception.PayException;

/**
 * <pre>
 * 支付相关接口
 * </pre>
 */
public interface PayService {

    /**
     * 获取配置
     */
    PayConfig getConfig();

    /**
     * 设置配置对象
     */
    void setConfig(PayConfig config);

    /**
     * 获取请求数据，方便接口调用方获取处理
     */
    PayApiData getApiData();

    /**
     * <pre>
     * 查询订单(详见 http://open.banmahui.cn/openapi/trade.query.html)
     * 该接口提供所有微信支付订单的查询，商户可以通过查询订单接口主动查询订单状态，完成下一步的业务逻辑。
     * 需要调用查询接口的情况：
     * ◆ 当商户后台、网络、服务器等出现异常，商户系统最终未接收到支付通知；
     * ◆ 调用支付接口后，返回系统错误或未知交易状态情况；
     * ◆ 调用被扫支付API，返回USERPAYING的状态；
     * ◆ 调用关单或撤销接口API之前，需确认支付状态；
     * </pre>
     */
    PayOrderQueryResult queryOrder(PayOrderQueryRequest request) throws PayException;

    /**
     * <pre>
     * 刷卡支付(详见 http://open.banmahui.cn/openapi/trade.micropay.html)
     * </pre>
     */
    MicropayResult micropay(MicropayRequest request) throws PayException;

    /**
     *
     * 微信扫码支付订单
     */
    WeixinQrPayResult weixinQrPay(WeixinQrPayRequest request) throws PayException;

    /**
     *
     * 微信公众号支付订单
     */
    WeixinJsPayResult weixinJsPay(WeixinJsPayRequest request) throws PayException;

    /**
     *
     * 支付宝扫码支付订单
     */
    AlipayQrPayResult alipayQrPay(AlipayQrPayRequest request) throws PayException;

    /**
     *
     * 支付宝服务窗口支付订单
     */
    AlipayJsPayResult alipayJsPay(AlipayJsPayRequest request) throws PayException;

    BillDownloadResult downloadBill(BillDownloadRequest request) throws PayException;
}
