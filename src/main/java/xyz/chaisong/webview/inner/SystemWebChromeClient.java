package xyz.chaisong.webview.inner;

import android.net.Uri;
import android.webkit.WebView;

import xyz.chaisong.webview.WebChromeClient;
import xyz.chaisong.webview.ValueCallback;

/**
 * Created by song on 16/10/19.
 */

public class SystemWebChromeClient extends android.webkit.WebChromeClient {
    private xyz.chaisong.webview.WebView mWebView;
    private WebChromeClient mWebChromeClient;

    public SystemWebChromeClient(xyz.chaisong.webview.WebView webView, WebChromeClient webChromeClient) {
        this.mWebView = webView;
        this.mWebChromeClient = webChromeClient;
    }

    @Override
    public boolean onConsoleMessage(android.webkit.ConsoleMessage cm) {
        return mWebChromeClient.onConsoleMessage(new InnerConsoleMessage(cm));
    }

    @Override
    public boolean onJsAlert(WebView view, String url, String message, android.webkit.JsResult result) {
        return mWebChromeClient.onJsAlert(mWebView, url, message, new InnerJsResult(result));
    }

    @Override
    public void onReceivedTitle(WebView view, String title) {
        mWebChromeClient.onReceivedTitle(mWebView, title);
    }

    public void openFileChooser(android.webkit.ValueCallback var1) {
        this.openFileChooser(var1, (String)null, (String)null);
    }

    public void openFileChooser(android.webkit.ValueCallback var1, String var2) {
        this.openFileChooser(var1, var2, (String)null);
    }

    public void openFileChooser(android.webkit.ValueCallback uploadMsg, String acceptType, String capture) {
        this.mWebChromeClient.openFileChooser(new SystemUriValueCallback(this, uploadMsg), acceptType, capture);
    }

    public boolean onShowFileChooser(WebView webView, android.webkit.ValueCallback filePathCallback, android.webkit.WebChromeClient.FileChooserParams fileChooserParams) {
        return this.mWebChromeClient.onShowFileChooser(mWebView, new SystemUrisValueCallback(this, filePathCallback), fileChooserParams);
    }

    public void onProgressChanged(WebView view, int newProgress) {
        this.mWebChromeClient.onProgressChanged(mWebView, newProgress);
    }

    private static class SystemUriValueCallback implements ValueCallback<Uri> {
        SystemWebChromeClient b;
        android.webkit.ValueCallback a;
        SystemUriValueCallback(SystemWebChromeClient var1, android.webkit.ValueCallback var2) {
            this.b = var1;
            this.a = var2;
        }

        public void onReceiveValue(Uri var1) {
            this.a.onReceiveValue(var1);
        }
    }

    private static class SystemUrisValueCallback implements ValueCallback<Uri[]> {
        SystemWebChromeClient b;
        android.webkit.ValueCallback a;
        SystemUrisValueCallback(SystemWebChromeClient var1, android.webkit.ValueCallback var2) {
            this.b = var1;
            this.a = var2;
        }

        public void onReceiveValue(Uri[] var1) {
            this.a.onReceiveValue(var1);
        }
    }
}
