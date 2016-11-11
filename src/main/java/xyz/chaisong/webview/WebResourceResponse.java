package xyz.chaisong.webview;

import java.io.InputStream;
import java.util.Map;

/**
 * Created by song on 16/10/19.
 */

public class WebResourceResponse {
    private String mMimeType;
    private String mEncoding;
    private int mStatusCode;
    private String mReasonPhrase;
    private Map<String, String> mResponseHeaders;
    private InputStream mInputStream;

    public WebResourceResponse(String var1, String var2, InputStream var3) {
        this.mMimeType = var1;
        this.mEncoding = var2;
        this.setData(var3);
    }

    public WebResourceResponse(String var1, String var2, int var3, String var4, Map<String, String> var5, InputStream var6) {
        this.mMimeType = var1;
        this.mEncoding = var2;
        this.mStatusCode = var3;
        this.mReasonPhrase = var4;
        this.setResponseHeaders(var5);
    }

    public void setMimeType(String var1) {
        this.mMimeType = var1;
    }

    public String getMimeType() {
        return this.mMimeType;
    }

    public void setEncoding(String var1) {
        this.mEncoding = var1;
    }

    public String getEncoding() {
        return this.mEncoding;
    }

    public void setStatusCodeAndReasonPhrase(int var1, String var2) {
        this.mStatusCode = var1;
        this.mReasonPhrase = var2;
    }

    public int getStatusCode() {
        return this.mStatusCode;
    }

    public String getReasonPhrase() {
        return this.mReasonPhrase;
    }

    public void setResponseHeaders(Map<String, String> var1) {
        this.mResponseHeaders = var1;
    }

    public Map<String, String> getResponseHeaders() {
        return this.mResponseHeaders;
    }

    public void setData(InputStream var1) {
        this.mInputStream = var1;
    }

    public InputStream getData() {
        return this.mInputStream;
    }
}