package com.winwin.pay.service.impl;

import com.winwin.pay.bean.PayApiData;
import com.winwin.pay.exception.PayException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.nio.charset.StandardCharsets;

/**
 * <pre>
 * 微信支付请求实现类，apache httpclient实现
 * </pre>
 */
public class PayServiceApacheHttpImpl extends PayServiceAbstractImpl {

    @Override
    protected String post(String url, String requestStr) throws PayException {
        try {
            HttpClientBuilder httpClientBuilder = HttpClients.custom();
            HttpPost httpPost = new HttpPost(url);

            httpPost.setConfig(RequestConfig.custom()
                    .setConnectionRequestTimeout(this.getConfig().getHttpConnectionTimeout())
                    .setConnectTimeout(this.getConfig().getHttpConnectionTimeout())
                    .setSocketTimeout(this.getConfig().getHttpTimeout())
                    .build());

            try (CloseableHttpClient httpclient = httpClientBuilder.build()) {
                httpPost.setEntity(new StringEntity(new String(requestStr.getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1)));
                try (CloseableHttpResponse response = httpclient.execute(httpPost)) {
                    String responseString = EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);
                    this.log.info("\n【请求地址】：{}\n【请求数据】：{}\n【响应数据】：{}", url, requestStr, responseString);
                    apiData.set(new PayApiData(url, requestStr, responseString, null));
                    return responseString;
                }
            } finally {
                httpPost.releaseConnection();
            }
        } catch (Exception e) {
            this.log.error("\n【请求地址】：{}\n【请求数据】：{}\n【异常信息】：{}", url, requestStr, e.getMessage());
            apiData.set(new PayApiData(url, requestStr, null, e.getMessage()));
            throw new PayException(e.getMessage(), e);
        }
    }
}
