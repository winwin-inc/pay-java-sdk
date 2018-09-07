package com.winwin.pay.service.impl;

import com.winwin.pay.bean.PayApiData;
import com.winwin.pay.bean.request.*;
import com.winwin.pay.bean.result.*;
import com.winwin.pay.bean.request.PayOrderQueryRequest;
import com.winwin.pay.bean.result.PayBaseResult;
import com.winwin.pay.bean.result.PayOrderQueryResult;
import com.winwin.pay.config.PayConfig;
import com.winwin.pay.exception.PayException;
import com.winwin.pay.service.PayService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <pre>
 *  微信支付接口请求抽象实现类
 * </pre>
 */
public abstract class PayServiceAbstractImpl implements PayService {
    protected final Logger log = LoggerFactory.getLogger(this.getClass());
    protected static ThreadLocal<PayApiData> apiData = new ThreadLocal<>();

    protected PayConfig config;

    @Override
    public PayConfig getConfig() {
        return this.config;
    }

    @Override
    public void setConfig(PayConfig config) {
        this.config = config;
    }

    @Override
    public PayApiData getApiData() {
        try {
            return apiData.get();
        } finally {
            //一般来说，接口请求会在一个线程内进行，这种情况下，每个线程get的会是之前所存入的数据，
            // 但以防万一有同一线程多次请求的问题，所以每次获取完数据后移除对应数据
            apiData.remove();
        }
    }

    private String getPayBaseUrl() {
        return this.config.getApiBaseUri();
    }

    /**
     * 发送post请求
     *
     * @param url        请求地址
     * @param requestStr 请求信息
     * @return 返回请求结果字符串
     */
    protected abstract String post(String url, String requestStr) throws PayException;

    @Override
    public PayOrderQueryResult queryOrder(PayOrderQueryRequest request) throws PayException {
        request.checkAndSign(this.getConfig());

        String url = this.getPayBaseUrl();
        String responseContent = this.post(url, request.toXML());
        if (StringUtils.isBlank(responseContent)) {
            throw new PayException("无响应结果");
        }

        PayOrderQueryResult result = PayBaseResult.fromXML(responseContent, PayOrderQueryResult.class);
        result.checkResult(this, request.getSignType(), true);
        return result;
    }

    //微信扫码支付订单
    public WeixinQrPayResult weixinQrPay(WeixinQrPayRequest request) throws PayException {
    	request.checkAndSign(this.getConfig());
    	String url = this.getPayBaseUrl();
    	String responseContent = this.post(url, request.toXML());
    	WeixinQrPayResult result = PayBaseResult.fromXML(responseContent, WeixinQrPayResult.class);
    	result.checkResult(this, request.getSignType(), true);
		return result;
    }

    //微信公众号、小程序支付下单
    public WeixinJsPayResult weixinJsPay(WeixinJsPayRequest request) throws PayException{
        request.checkAndSign(this.getConfig());
        String url = this.getPayBaseUrl();
        String responseContent = this.post(url, request.toXML());
        WeixinJsPayResult result = PayBaseResult.fromXML(responseContent, WeixinJsPayResult.class);
        result.checkResult(this, request.getSignType(), true);
        return result;
    }

    //刷卡支付订单
    public MicropayResult micropay(MicropayRequest request) throws  PayException{
        request.checkAndSign(this.getConfig());
        String url = this.getPayBaseUrl();
        String responseContent = this.post(url, request.toXML());
        MicropayResult result = PayBaseResult.fromXML(responseContent, MicropayResult.class);
        if (result.getErrCode() != null && result.getErrCode().equals("USERPAYING")) {
            return result;
        }
        result.checkResult(this, request.getSignType(), true);
        return result;
    }

    //支付宝扫码支付
    public AlipayQrPayResult alipayQrPay(AlipayQrPayRequest request) throws  PayException{
        request.checkAndSign(this.getConfig());
        String url = this.getPayBaseUrl();
        String responseContent = this.post(url, request.toXML());
        AlipayQrPayResult result = PayBaseResult.fromXML(responseContent, AlipayQrPayResult.class);
        result.checkResult(this, request.getSignType(), true);
        return result;
    }

    //支付宝窗口支付
    public AlipayJsPayResult alipayJsPay(AlipayJsPayRequest request) throws PayException {
        request.checkAndSign(this.getConfig());
        String url = this.getPayBaseUrl();
        String responseContent = this.post(url, request.toXML());
        AlipayJsPayResult result = PayBaseResult.fromXML(responseContent, AlipayJsPayResult.class);
        result.checkResult(this, request.getSignType(), true);
        return result;
    }

    @Override
    public BillDownloadResult downloadBill(BillDownloadRequest request) throws PayException {
        request.checkAndSign(this.getConfig());
        String url = this.getPayBaseUrl();
        String responseContent = this.post(url, request.toXML());
        BillDownloadResult result = PayBaseResult.fromXML(responseContent, BillDownloadResult.class);
        if (result.getContent() != null) {
            result.setContent(result.getContent().replace("\n", "\r\n"));
        }
        result.checkResult(this, request.getSignType(), true);
        return result;
    }
}
