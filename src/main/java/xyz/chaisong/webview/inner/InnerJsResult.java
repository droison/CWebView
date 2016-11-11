package xyz.chaisong.webview.inner;

import xyz.chaisong.webview.JsResult;

/**
 * Created by song on 16/10/19.
 */

class InnerJsResult implements JsResult {
    boolean isX5 = false;
    android.webkit.JsResult a;
    com.tencent.smtt.export.external.interfaces.JsResult b;

    InnerJsResult(android.webkit.JsResult var2) {
        this.a = var2;
    }

    InnerJsResult(com.tencent.smtt.export.external.interfaces.JsResult var2) {
        this.isX5 = true;
        this.b = var2;
    }

    public void cancel() {
        if (this.isX5)
            this.b.cancel();
        else
            this.a.cancel();
    }

    public void confirm() {
        if (this.isX5)
            this.b.confirm();
        else
            this.a.confirm();
    }
}
