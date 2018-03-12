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
     * Test method for {@link PayService#queryOrder(String)} .
     */
    @Test
    public void testQueryOrder() throws PayException {
        this.logger.info(this.payService.queryOrder("18030714450985124644").toString());
    }


    /**
     * Test method for {@link PayService#queryOrder(String)} .
     */
    @Test
    //微信扫码支付
    public void testWsPayOrder() throws PayException {
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        WsOrderPayRequest request = new WsOrderPayRequest();
        request
                .setMethod(PayConstants.PayMethod.TRADE_MICROPAY);
        request
                .setSpbillCreateIp("10.0.0.1");
        request.setAuthCode("134595449339479507");
        request.setTotalFee(1);
        request.setOutTradeNo(dateFormat.format(new Date()));
        request.setBody("test");
        this.logger.info(this.payService.wsOrder(request).toString());
    }

    //微信公众号预支付
    public void testWzPayOrder() throws PayException {
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        WzOrderPayRequest request = new WzOrderPayRequest();
        request
                .setMethod(PayConstants.PayMethod.TRADE_MICROPAY);
        request
                .setSpbillCreateIp("10.0.0.1");
        request.setAuthCode("");
        request.setTotalFee(1);
        request.setOutTradeNo(dateFormat.format(new Date()));
        request.setBody("test");
        this.logger.info(this.payService.wzOrder(request).toString());
    }

    //微信小程序支付预下单
    public void testWpPayOrder() throws PayException {
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        WpOrderPayRequest request = new WpOrderPayRequest();
        request
                .setMethod(PayConstants.PayMethod.TRADE_MICROPAY);
        request
                .setSpbillCreateIp("10.0.0.1");
        request.setAuthCode("");
        request.setTotalFee(1);
        request.setOutTradeNo(dateFormat.format(new Date()));
        request.setBody("test");
        this.logger.info(this.payService.wpOrder(request).toString());
    }

    //刷卡支付
    public void testCardPayOrder() throws PayException {
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        CardOrderPayRequest request = new CardOrderPayRequest();
        request
                .setMethod(PayConstants.PayMethod.TRADE_MICROPAY);
        request
                .setSpbillCreateIp("10.0.0.1");
        request.setAuthCode("");
        request.setTotalFee(1);
        request.setOutTradeNo(dateFormat.format(new Date()));
        request.setBody("test");
        this.logger.info(this.payService.cardOrder(request).toString());
    }

    //支付宝扫码支付
    public void testZsPayOrder() throws  PayException {
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        ZsOrderPayRequest request = new ZsOrderPayRequest();
        request
                .setMethod(PayConstants.PayMethod.TRADE_MICROPAY);
        request
                .setSpbillCreateIp("10.0.0.1");
        request.setAuthCode("");
        request.setTotalFee(1);
        request.setOutTradeNo(dateFormat.format(new Date()));
        request.setBody("test");
        this.logger.info(this.payService.zsOrder(request).toString());
    }

    //支付宝窗口支付
    public void testZwPayOrder() throws PayException {
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        ZwOrderPayRequest request = new ZwOrderPayRequest();
        request
                .setMethod(PayConstants.PayMethod.TRADE_MICROPAY);
        request
                .setSpbillCreateIp("10.0.0.1");
        request.setAuthCode("");
        request.setTotalFee(1);
        request.setOutTradeNo(dateFormat.format(new Date()));
        request.setBody("test");
        this.logger.info(this.payService.zwOrder(request).toString());
    }
}
