package com.winwin.pay.service.impl;

import com.google.inject.Inject;
import com.winwin.pay.exception.PayException;
import com.winwin.pay.service.PayService;
import com.winwin.pay.testbase.ApiTestModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Guice;
import org.testng.annotations.Test;

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
        this.logger.info(this.payService.queryOrder("17091614123618219071").toString());
    }
}
