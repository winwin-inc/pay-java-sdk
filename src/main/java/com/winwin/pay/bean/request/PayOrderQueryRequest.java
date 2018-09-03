package com.winwin.pay.bean.request;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.winwin.pay.exception.PayException;
import org.apache.commons.lang3.StringUtils;

/**
 * <pre>
 * 订单查询请求对象
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
public class PayOrderQueryRequest extends PayBaseRequest {

    /**
     * <pre>
     * 平台订单号
     * transaction_id
     * 三选一
     * String(32)
     * 17061307203230323
     * 平台订单号，优先使用
     * </pre>
     */
    @XStreamAlias("transaction_id")
    private String transactionId;

    /**
     * <pre>
     * 第三方平台订单号
     * mch_transaction_id
     * 三选一
     * String(32)
     * 10096603802015061307
     * 平台订单号，优先使用
     * </pre>
     */
    @XStreamAlias("mch_transaction_id")
    private String mchTransactionId;

    /**
     * <pre>
     * 商户订单号
     * out_trade_no
     * 三选一
     * String(32)
     * 20150806125346
     * 商户系统内部的订单号
     * </pre>
     */
    @XStreamAlias("out_trade_no")
    private String outTradeNo;

    public PayOrderQueryRequest() {
        setMethod("trade.query");
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
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

    @Override
    protected void checkConstraints() throws PayException {
        int orderNo = 0;
        if (!StringUtils.isBlank(transactionId)) {
            orderNo += 1;
        }
        if (!StringUtils.isBlank(mchTransactionId)) {
            orderNo += 1;
        }
        if (!StringUtils.isBlank(outTradeNo)) {
            orderNo += 1;
        }
        if (orderNo != 1) {
            throw new PayException("transaction_id、 mch_transaction_id 和 out_trade_no 不能同时存在或同时为空，必须三选一");
        }
    }
}
