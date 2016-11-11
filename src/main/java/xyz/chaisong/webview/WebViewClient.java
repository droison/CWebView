package xyz.chaisong.webview;

import android.annotation.TargetApi;
import android.graphics.Bitmap;

/**
 * Created by song on 16/10/19.
 */

public class WebViewClient {
    public void onPageStarted(WebView view, String url, Bitmap favicon) {

    }

    public void onLoadResource(WebView view, String url) {

    }

    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        return false;
    }

    public void onPageFinished(WebView view, String url) {

    }

    @Deprecated
    public WebResourceResponse shouldInterceptRequest(WebView view, String url) {
        return null;
    }

    @TargetApi(21)
    public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest request) {
        return shouldInterceptRequest(view, request.getUrl().toString());
    }
}
