package com.winwin.pay.bean.request;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.winwin.pay.exception.PayException;

/**
 * <pre>
 *  下载对账单请求
 * </pre>
 */
final public class BillDownloadRequest extends BaseRequest {
    /**
     * <pre>
     * 下载对账单的日期
     * bill_date
     * String(8)
     * 20091225
     * 下载对账单的日期
     * </pre>
     */
    @XStreamAlias("bill_date")
    private String billDate;

    /**
     * <pre>
     * 账单下载方式
     * bill_date
     * Int
     * 20091225
     * 账单下载方式
     * </pre>
     */
    private int type;

    public BillDownloadRequest() {
        setMethod("trade.bill.download");
    }

    public String getBillDate() {
        return billDate;
    }

    public void setBillDate(String billDate) {
        this.billDate = billDate;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    protected void checkConstraints() throws PayException {
    }
}
