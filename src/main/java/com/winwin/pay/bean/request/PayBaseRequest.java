package com.winwin.pay.bean.request;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.winwin.pay.config.PayConfig;
import com.winwin.pay.exception.PayException;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;


/**
 * <pre>
 *  请求对象共用的参数存放类
 * </pre>
 */
public abstract class PayBaseRequest extends BaseRequest {
    /**
     * <pre>
     * 字段名：商户编号
     * 变量名：mch_id
     * 是否必填：mch_id, device_id 二选一
     * 类型：String(32)
     * 示例值：1234567
     * </pre>
     */
    @XStreamAlias("mch_id")
    private String mchId;

    /**
     * <pre>
     * 字段名：设备编号
     * 变量名：device_id
     * 是否必填：mch_id, device_id 二选一
     * 类型：String(32)
     * 示例值：12011590
     * 说明：ERP/POS厂商的设备编号
     * </pre>
     */
    @XStreamAlias("device_id")
    private String deviceId;

    public String getMchId() {
        return mchId;
    }

    public void setMchId(String mchId) {
        this.mchId = mchId;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    /**
     * 将单位为元转换为单位为分
     *
     * @param yuan 将要转换的元的数值字符串
     */
    public static Integer yuanToFee(String yuan) {
        return new BigDecimal(yuan).setScale(2, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100)).intValue();
    }

    @Override
    public void checkAndSign(PayConfig config) throws PayException {
        if (StringUtils.isBlank(getMchId())) {
            this.setMchId(config.getMchId());
        }
        if (StringUtils.isBlank(getDeviceId())) {
            this.setDeviceId(config.getDeviceId());
        }
        super.checkAndSign(config);
    }
}
