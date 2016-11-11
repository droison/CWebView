package xyz.chaisong.webview.inner;

import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;

import xyz.chaisong.webview.WebResourceResponse;
import xyz.chaisong.webview.WebViewClient;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.sdk.WebView;

/**
 * Created by song on 16/10/19.
 */

public class X5WebViewClient extends com.tencent.smtt.sdk.WebViewClient {
    private xyz.chaisong.webview.WebView mWebView;
    private WebViewClient mWebViewClient;

    public X5WebViewClient(xyz.chaisong.webview.WebView webView, WebViewClient webViewClient) {
        this.mWebView = webView;
        this.mWebViewClient = webViewClient;
    }

    @Override
    public void onPageStarted(com.tencent.smtt.sdk.WebView view, String url, Bitmap favicon) {
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

    @Override
    public com.tencent.smtt.export.external.interfaces.WebResourceResponse shouldInterceptRequest(WebView webView, String url) {
        if(Build.VERSION.SDK_INT < 11) {
            return null;
        } else {
            WebResourceResponse resourceResponse =  mWebViewClient.shouldInterceptRequest(mWebView, url);
            return resourceResponse == null?null:new com.tencent.smtt.export.external.interfaces.WebResourceResponse(resourceResponse.getMimeType(), resourceResponse.getEncoding(), resourceResponse.getData());
        }
    }

    @Override
    public com.tencent.smtt.export.external.interfaces.WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest request) {
        if(Build.VERSION.SDK_INT < 21) {
            return null;
        } else if(request == null) {
            return null;
        } else {
            SystemWebViewClient.WebResourceRequest var3 = new SystemWebViewClient.WebResourceRequest(request.getUrl().toString(), request.isForMainFrame(), request.hasGesture(), request.getMethod(), request.getRequestHeaders());
            WebResourceResponse var4 = this.mWebViewClient.shouldInterceptRequest(this.mWebView, var3);
            return var4 == null?null:new com.tencent.smtt.export.external.interfaces.WebResourceResponse(var4.getMimeType(), var4.getEncoding(), var4.getData());
        }
    }

    @Override
    public com.tencent.smtt.export.external.interfaces.WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest request, Bundle bundle) {
        if(Build.VERSION.SDK_INT < 21) {
            return null;
        } else if(request == null) {
            return null;
        } else {
            SystemWebViewClient.WebResourceRequest var3 = new SystemWebViewClient.WebResourceRequest(request.getUrl().toString(), request.isForMainFrame(), request.hasGesture(), request.getMethod(), request.getRequestHeaders());
            WebResourceResponse var4 = this.mWebViewClient.shouldInterceptRequest(this.mWebView, var3);
            return var4 == null?null:new com.tencent.smtt.export.external.interfaces.WebResourceResponse(var4.getMimeType(), var4.getEncoding(), var4.getData());
        }
    }

}
