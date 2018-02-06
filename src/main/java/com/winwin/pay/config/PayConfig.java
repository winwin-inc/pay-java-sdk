package com.winwin.pay.config;

/**
 * 支付配置
 */
public class PayConfig {

    /**
     * http请求连接超时时间
     */
    private int httpConnectionTimeout = 5000;

    /**
     * http请求数据读取等待时间
     */
    private int httpTimeout = 10000;

    private String apiBaseUri;
    private String appId;
    private String appKey;
    private String version = "1.0.0";
    private String signType;
    private String mchId;
    private String deviceId;

    public int getHttpConnectionTimeout() {
        return httpConnectionTimeout;
    }

    public void setHttpConnectionTimeout(int httpConnectionTimeout) {
        this.httpConnectionTimeout = httpConnectionTimeout;
    }

    public int getHttpTimeout() {
        return httpTimeout;
    }

    public void setHttpTimeout(int httpTimeout) {
        this.httpTimeout = httpTimeout;
    }

    public String getApiBaseUri() {
        return apiBaseUri;
    }

    public void setApiBaseUri(String apiBaseUri) {
        this.apiBaseUri = apiBaseUri;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getSignType() {
        return signType;
    }

    public void setSignType(String signType) {
        this.signType = signType;
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
}
