package com.winwin.pay.service.impl;

import com.google.inject.Inject;
import com.winwin.pay.bean.request.*;
import com.winwin.pay.constant.PayConstants;
import com.winwin.pay.exception.PayException;
import com.winwin.pay.service.PayService;
import com.winwin.pay.testbase.ApiTestModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Guice;
import org.testng.annotations.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 测试支付相关接口
 * Created by Binary Wang on 2016/7/28.
 *
 * @author <a href="https://github.com/binarywang">Binary Wang</a>
 */
@Test
@Guice(modules = ApiTestModule.class)
public class PayServiceApacheHttpImplTest {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Inject
    private PayService payService;

    /**
     * Test method for {@link PayService#queryOrder(PayOrderQueryRequest)} .
     */
    @Test
    public void testQueryOrder() throws PayException {
        PayOrderQueryRequest request = new PayOrderQueryRequest();
        request.setOutTradeNo("20180903162307");
        this.logger.info(this.payService.queryOrder(request).toString());
    }

    @Test
    //微信扫码支付
    public void testWsPayOrder() throws PayException {
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        WeixinQrPayRequest request = new WeixinQrPayRequest();
        request.setOutTradeNo(dateFormat.format(new Date()));
        request.setTotalFee(1);
        request.setBody("test");
        request.setSpbillCreateIp("10.0.0.1");
        request.setNotifyUrl("http://test");
        request.setNonceStr("");
        this.logger.info(this.payService.weixinQrPay(request).toString());
    }

    //微信公众号、小程序预支付
    public void testWzPayOrder() throws PayException {
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        WeixinJsPayRequest request = new WeixinJsPayRequest();
        request.setTotalFee(1);
        request.setSpbillCreateIp("10.0.0.1");
        request.setOutTradeNo(dateFormat.format(new Date()));
        request.setBody("test");
        request.setOpenId("oynvnwF3pn01WT_qXjbXeiDY6EJY");
        request.setNotifyUrl("http://test");
        this.logger.info(this.payService.weixinJsPay(request).toString());
    }

    //微信小程序支付预下单
    public void testWxMiniAppPayOrder() throws PayException {
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        WeixinJsPayRequest request = new WeixinJsPayRequest();
        request
                .setSpbillCreateIp("10.0.0.1");
        request.setAuthCode("");
        request.setTotalFee(1);
        request.setOutTradeNo(dateFormat.format(new Date()));
        request.setBody("test");
        this.logger.info(this.payService.weixinJsPay(request).toString());
    }

    //刷卡支付
    public void testCardPayOrder() throws PayException {
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        MicropayRequest request = new MicropayRequest();
        request.setOutTradeNo(dateFormat.format(new Date()));
        request.setTotalFee(1);
        request.setBody("test");
        request.setAuthCode("134735793063467975");
        request.setOpUser("typ");
        request.setSpbillCreateIp("10.0.0.1");
        request.setNonceStr("test");
        this.logger.info(this.payService.micropay(request).toString());
    }

    //支付宝扫码支付
    public void testZsPayOrder() throws  PayException {
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        AlipayQrPayRequest request = new AlipayQrPayRequest();
        request.setOutTradeNo(dateFormat.format(new Date()));
        request.setTotalFee(1);
        request.setBody("test");
        request.setSpbillCreateIp("10.0.0.1");
        request.setNotifyUrl("http://test");
        request.setNonceStr("typ");
        this.logger.info(this.payService.alipayQrPay(request).toString());
    }

    //支付宝窗口支付
    public void testZwPayOrder() throws PayException {
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        AlipayJsPayRequest request = new AlipayJsPayRequest();
        request.setOutTradeNo(dateFormat.format(new Date()));
        request.setTotalFee(1);
        request.setBody("test");
        request.setOpenId("2088102169853405");
        request.setSpbillCreateIp("10.0.0.1");
        request.setNotifyUrl("http://test");
        request.setNonceStr("typ");
        this.logger.info(this.payService.alipayJsPay(request).toString());
    }

    public void testDownloadBill() throws PayException {
        BillDownloadRequest request = new BillDownloadRequest();
        request.setBillDate("20180902");
        request.setType(PayConstants.BillDownloadType.CONTENT);
        this.logger.info(this.payService.downloadBill(request).toString());
    }
}
