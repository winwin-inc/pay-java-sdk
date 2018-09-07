package com.winwin.pay.bean.result;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.util.Map;

@XStreamAlias("xml")
public class BillDownloadResult extends BaseResult {
    /**
     * 账单内容
     */
    private String content;

    /**
     * 账单下载链接
     */
    @XStreamAlias("download_url")
    private String downloadUrl;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    protected Map<String, String> toMap() {
        Map<String, String> result = super.toMap();
        if (result.containsKey("content")) {
            result.put("content", result.get("content").replace("\n", "\r\n"));
        }
        return result;
    }
}
