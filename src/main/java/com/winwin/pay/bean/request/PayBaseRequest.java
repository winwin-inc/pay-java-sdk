package com.winwin.pay.bean.request;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.winwin.pay.config.PayConfig;
import com.winwin.pay.exception.PayException;
import com.winwin.pay.util.SignUtils;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.common.util.BeanUtils;
import me.chanjar.weixin.common.util.ToStringUtils;
import me.chanjar.weixin.common.util.xml.XStreamInitializer;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;

import static com.winwin.pay.constant.PayConstants.SignType.ALL_SIGN_TYPES;


/**
 * <pre>
 *  请求对象共用的参数存放类
 * </pre>
 */
public abstract class PayBaseRequest {
    /**
     * <pre>
     * 字段名：应用ID
     * 变量名：appid
     * 是否必填：是
     * 类型：String(32)
     * 示例值：12011590
     * </pre>
     */
    @XStreamAlias("appid")
    protected String appid;

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

    /**
     * 字段名：接口版本号
     * 变量名：version
     * 是否必填：是
     * 类型：String(32)
     * 示例值：1.0.0
     */
    @XStreamAlias("version")
    protected String version;

    /**
     * 字段名：接口名称
     * 变量名：method
     * 是否必填：是
     * 类型：String(32)
     * 示例值：trade.query
     */
    protected String method;
    /**
     * <pre>
     * 字段名：随机字符串
     * 变量名：nonce_str
     * 是否必填：是
     * 类型：String(32)
     * 示例值：5K8264ILTKCH16CQ2502SI8ZNMTM67VS
     * 描述：随机字符串，不长于32位。推荐随机数生成算法
     * </pre>
     */
    @XStreamAlias("nonce_str")
    protected String nonceStr;
    /**
     * <pre>
     * 字段名：签名
     * 变量名：sign
     * 是否必填：是
     * 类型：String(32)
     * 示例值：C380BEC2BFD727A4B6845133519F3AD6
     * 描述：签名，详见签名生成算法
     * </pre>
     */
    @XStreamAlias("sign")
    protected String sign;

    /**
     * <pre>
     * 字段名：签名类型
     * 变量名：sign_type
     * 是否必填：否
     * 类型：String(32)
     * 示例值：MD5
     * 描述：签名类型，目前只支持MD5
     * </pre>
     */
    @XStreamAlias("sign_type")
    private String signType;

    /**
     * <pre>
     * 字段名：字符集
     * 变量名：charset
     * 是否必填：否
     * 类型：String(32)
     * 示例值：UTF-8
     * </pre>
     */
    private String charset;

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

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

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getMethod() {
        return method;
    }

    protected void setMethod(String method) {
        this.method = method;
    }

    public String getNonceStr() {
        return nonceStr;
    }

    public void setNonceStr(String nonceStr) {
        this.nonceStr = nonceStr;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getSignType() {
        return signType;
    }

    public void setSignType(String signType) {
        this.signType = signType;
    }

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    /**
     * 将单位为元转换为单位为分
     *
     * @param yuan 将要转换的元的数值字符串
     */
    public static Integer yuanToFee(String yuan) {
        return new BigDecimal(yuan).setScale(2, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100)).intValue();
    }

    /**
     * 检查请求参数内容，包括必填参数以及特殊约束
     */
    private void checkFields() throws PayException {
        //check required fields
        try {
            BeanUtils.checkRequiredFields(this);
        } catch (WxErrorException e) {
            throw new PayException(e.getError().getErrorMsg(), e);
        }

        //check other parameters
        this.checkConstraints();
    }

    /**
     * 检查约束情况
     */
    protected abstract void checkConstraints() throws PayException;

    @Override
    public String toString() {
        return ToStringUtils.toSimpleString(this);
    }

    public String toXML() {
        XStream xstream = XStreamInitializer.getInstance();
        xstream.processAnnotations(this.getClass());
        return xstream.toXML(this);
    }

    /**
     * <pre>
     * 检查参数，并设置签名
     * 1、检查参数（注意：子类实现需要检查参数的而外功能时，请在调用父类的方法前进行相应判断）
     * 2、补充系统参数，如果未传入则从配置里读取
     * 3、生成签名，并设置进去
     * </pre>
     *
     * @param config 支付配置对象，用于读取相应系统配置信息
     */
    public void checkAndSign(PayConfig config) throws PayException {
        this.checkFields();

        if (StringUtils.isBlank(getAppid())) {
            this.setAppid(config.getAppId());
        }
        if (StringUtils.isBlank(getVersion())) {
            this.setVersion(config.getVersion());
        }

        if (StringUtils.isBlank(getSignType())) {
            if (config.getSignType() != null && !ALL_SIGN_TYPES.contains(config.getSignType())) {
                throw new PayException("非法的signType配置：" + config.getSignType() + "，请检查配置！");
            }
            this.setSignType(StringUtils.trimToNull(config.getSignType()));
        } else {
            if (!ALL_SIGN_TYPES.contains(this.getSignType())) {
                throw new PayException("非法的sign_type参数：" + this.getSignType());
            }
        }
        if (StringUtils.isBlank(getMchId())) {
            this.setMchId(config.getMchId());
        }
        if (StringUtils.isBlank(getDeviceId())) {
            this.setDeviceId(config.getDeviceId());
        }

        if (StringUtils.isBlank(getNonceStr())) {
            this.setNonceStr(String.valueOf(System.currentTimeMillis()));
        }

        //设置签名字段的值
        this.setSign(SignUtils.createSign(this, this.getSignType(), config.getAppKey()));
    }

}
