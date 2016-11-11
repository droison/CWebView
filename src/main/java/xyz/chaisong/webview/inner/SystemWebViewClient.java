package xyz.chaisong.webview.inner;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.webkit.WebView;

import xyz.chaisong.webview.WebResourceResponse;
import xyz.chaisong.webview.WebViewClient;

import java.util.Map;

/**
 * Created by song on 16/10/19.
 */

public class SystemWebViewClient extends android.webkit.WebViewClient {
    private xyz.chaisong.webview.WebView mWebView;
    private WebViewClient mWebViewClient;

    public SystemWebViewClient(xyz.chaisong.webview.WebView webView, WebViewClient webViewClient) {
        this.mWebView = webView;
        this.mWebViewClient = webViewClient;
    }

    @Override
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        mWebViewClient.onPageStarted(mWebView, url, favicon);
    }

    @Override
    public void onLoadResource(WebView view, String url) {
        mWebViewClient.onLoadResource(mWebView, url);
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        return mWebViewClient.shouldOverrideUrlLoading(mWebView, url);
    }

    @Override
    public void onPageFinished(WebView view, String url) {
        mWebViewClient.onPageFinished(mWebView, url);
    }

    @TargetApi(11)
    public android.webkit.WebResourceResponse shouldInterceptRequest(android.webkit.WebView view, String url) {
        if(Build.VERSION.SDK_INT < 11) {
            return null;
        } else {
            WebResourceResponse resourceResponse =  mWebViewClient.shouldInterceptRequest(mWebView, url);
            return resourceResponse == null?null:new android.webkit.WebResourceResponse(resourceResponse.getMimeType(), resourceResponse.getEncoding(), resourceResponse.getData());
        }
    }

    public android.webkit.WebResourceResponse shouldInterceptRequest(android.webkit.WebView view, WebResourceRequest request) {
        if(Build.VERSION.SDK_INT < 21) {
            return null;
        } else if(request == null) {
            return null;
        } else {
            WebResourceRequest var3 = new WebResourceRequest(request.getUrl().toString(), request.isForMainFrame(), request.hasGesture(), request.getMethod(), request.getRequestHeaders());
            WebResourceResponse var4 = this.mWebViewClient.shouldInterceptRequest(this.mWebView, var3);
            return var4 == null?null:new android.webkit.WebResourceResponse(var4.getMimeType(), var4.getEncoding(), var4.getData());
        }
    }

    public static class WebResourceRequest implements xyz.chaisong.webview.WebResourceRequest {
        private String b;
        private boolean c;
        private boolean d;
        private String e;
        private Map<String, String> f;

        public WebResourceRequest(String var1, boolean var2, boolean var3, String var4, Map<String, String> var5) {
            this.b = var1;
            this.c = var2;
            this.d = var3;
            this.e = var4;
            this.f = var5;
        }

        public Uri getUrl() {
            return Uri.parse(this.b);
        }

        public boolean isForMainFrame() {
            return this.c;
        }

        public boolean hasGesture() {
            return this.d;
        }

        public String getMethod() {
            return this.e;
        }

        public Map<String, String> getRequestHeaders() {
            return this.f;
        }
    }
}
