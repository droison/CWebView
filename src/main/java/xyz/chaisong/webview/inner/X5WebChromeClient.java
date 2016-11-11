package xyz.chaisong.webview.inner;

import android.annotation.TargetApi;
import android.content.Intent;
import android.net.Uri;

import xyz.chaisong.webview.WebChromeClient;
import xyz.chaisong.webview.ValueCallback;
import com.tencent.smtt.sdk.WebView;

/**
 * Created by song on 16/10/19.
 */

public class X5WebChromeClient extends com.tencent.smtt.sdk.WebChromeClient {
    private xyz.chaisong.webview.WebView mWebView;
    private WebChromeClient mWebChromeClient;

    public X5WebChromeClient(xyz.chaisong.webview.WebView webView, WebChromeClient webChromeClient) {
        this.mWebView = webView;
        this.mWebChromeClient = webChromeClient;
    }

    @Override
    public boolean onConsoleMessage(com.tencent.smtt.export.external.interfaces.ConsoleMessage cm) {
        return mWebChromeClient.onConsoleMessage(new InnerConsoleMessage(cm));
    }

    @Override
    public boolean onJsAlert(WebView view, String url, String message, com.tencent.smtt.export.external.interfaces.JsResult result) {
        return mWebChromeClient.onJsAlert(mWebView, url, message, new InnerJsResult(result));
    }

    @Override
    public void onReceivedTitle(WebView view, String title) {
        mWebChromeClient.onReceivedTitle(mWebView, title);
    }

    public void openFileChooser(com.tencent.smtt.sdk.ValueCallback var1) {
        this.openFileChooser(var1, (String)null, (String)null);
    }

    public void openFileChooser(com.tencent.smtt.sdk.ValueCallback var1, String var2) {
        this.openFileChooser(var1, var2, (String)null);
    }

    @Override
    public void openFileChooser(com.tencent.smtt.sdk.ValueCallback uploadMsg, String acceptType, String capture) {
        this.mWebChromeClient.openFileChooser(new X5WebChromeClient.X5UriValueCallback(this, uploadMsg), acceptType, capture);
    }

    @Override
    public boolean onShowFileChooser(WebView webView, com.tencent.smtt.sdk.ValueCallback filePathCallback, FileChooserParams fileChooserParams) {
        return this.mWebChromeClient.onShowFileChooser(mWebView, new X5WebChromeClient.X5UrisValueCallback(this, filePathCallback), new x(fileChooserParams));
    }

    public void onProgressChanged(WebView view, int newProgress) {
        this.mWebChromeClient.onProgressChanged(mWebView, newProgress);
    }

    private static class X5UriValueCallback implements ValueCallback<Uri> {
        X5WebChromeClient b;
        com.tencent.smtt.sdk.ValueCallback a;
        X5UriValueCallback(X5WebChromeClient var1, com.tencent.smtt.sdk.ValueCallback var2) {
            this.b = var1;
            this.a = var2;
        }

        public void onReceiveValue(Uri var1) {
            this.a.onReceiveValue(var1);
        }
    }

    private static class X5UrisValueCallback implements ValueCallback<Uri[]> {
        X5WebChromeClient b;
        com.tencent.smtt.sdk.ValueCallback a;
        X5UrisValueCallback(X5WebChromeClient var1, com.tencent.smtt.sdk.ValueCallback var2) {
            this.b = var1;
            this.a = var2;
        }

        public void onReceiveValue(Uri[] var1) {
            this.a.onReceiveValue(var1);
        }
    }

    @TargetApi(21)
    static class x extends android.webkit.WebChromeClient.FileChooserParams {
        FileChooserParams fileChooserParams;

        x(FileChooserParams var2) {
            this.fileChooserParams = var2;
        }

        public int getMode() {
            return this.fileChooserParams.getMode();
        }

        public String[] getAcceptTypes() {
            return this.fileChooserParams.getAcceptTypes();
        }

        public boolean isCaptureEnabled() {
            return this.fileChooserParams.isCaptureEnabled();
        }

        public CharSequence getTitle() {
            return this.fileChooserParams.getTitle();
        }

        public String getFilenameHint() {
            return this.fileChooserParams.getFilenameHint();
        }

        public Intent createIntent() {
            return this.fileChooserParams.createIntent();
        }
    }

}
