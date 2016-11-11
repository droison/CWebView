package xyz.chaisong.webview;

import android.net.Uri;

/**
 * Created by song on 16/10/19.
 */

public class WebChromeClient {

    public boolean onConsoleMessage(ConsoleMessage cm) {
        return false;
    }

    public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
        return false;
    }

    public void onReceivedTitle(WebView view, String title) {

    }

    public void openFileChooser(ValueCallback<Uri> uploadMsg, String acceptType, String capture) {

    }

    public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> filePathCallback, android.webkit.WebChromeClient.FileChooserParams fileChooserParams) {
        return false;
    }

    public void onProgressChanged(WebView view, int newProgress) {

    }
}
