package xyz.chaisong.webview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.widget.FrameLayout;

import java.util.Map;

import xyz.chaisong.webview.inner.*;

/**
 * Created by song on 16/10/19.
 */

public class WebView extends FrameLayout {
    private boolean isX5WebView = false;
    private X5WebView mX5WebView;
    private SystemWebView mWebView;
    private WebSettings mWebSettings;

    private WebViewScrollChangeListener onWebViewScrollChangeListener;

    public WebView(Context context) {
        this(context, (AttributeSet)null);
    }

    public WebView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public WebView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.WebView);
        boolean useX5WebView = a.getBoolean(R.styleable.WebView_x5, false);
        a.recycle();
        initWebView(context, attrs, defStyleAttr, useX5WebView);
    }

    public WebView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, boolean useX5WebView) {
        super(context, attrs, defStyleAttr);
        initWebView(context, attrs, defStyleAttr, useX5WebView);
    }

    private void initWebView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, boolean useX5WebView) {
        this.isX5WebView = useX5WebView;
        if (this.isX5WebView) {
            mX5WebView = new X5WebView(context, attrs);
            mX5WebView.setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            this.addView(mX5WebView);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                com.tencent.smtt.sdk.CookieManager.getInstance().setAcceptThirdPartyCookies(mX5WebView, true);
            }
        } else {
            mWebView = new SystemWebView(context, attrs);
            mWebView.setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            this.addView(mWebView);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                CookieManager.getInstance().setAcceptThirdPartyCookies(mWebView, true);
            }
        }
    }

    public com.tencent.smtt.sdk.WebView getX5WebView() {
        return mX5WebView;
    }

    public android.webkit.WebView getWebView() {
        return mWebView;
    }

    public void loadUrl(String url) {
        if(this.isX5WebView) {
            this.mX5WebView.loadUrl(url);
        } else {
            this.mWebView.loadUrl(url);
        }
    }

    public void loadUrl(String url, Map<String, String> additionalHttpHeaders) {
        if(this.isX5WebView) {
            this.mX5WebView.loadUrl(url, additionalHttpHeaders);
        } else {
            this.mWebView.loadUrl(url, additionalHttpHeaders);
        }
    }

    public void addJavascriptInterface(Object object, String string){
        if(this.isX5WebView) {
            this.mX5WebView.addJavascriptInterface(object, string);
        } else {
            this.mWebView.addJavascriptInterface(object, string);
        }
    }

    public void loadDataWithBaseURL(String baseUrl, String data, String mimeType, String encoding, String historyUrl){
        if(this.isX5WebView) {
            this.mX5WebView.loadDataWithBaseURL(baseUrl, data, mimeType, encoding, historyUrl);
        } else {
            this.mWebView.loadDataWithBaseURL(baseUrl, data, mimeType, encoding, historyUrl);
        }
    }

    public void goBack(){
        if(this.isX5WebView) {
            this.mX5WebView.goBack();
        } else {
            this.mWebView.goBack();
        }
    }

    public void goForward(){
        if(this.isX5WebView) {
            this.mX5WebView.goForward();
        } else {
            this.mWebView.goBack();
        }
    }

    public void reload(){
        if(this.isX5WebView) {
            this.mX5WebView.reload();
        } else {
            this.mWebView.reload();
        }
    }

    public void clearCache(boolean includeDiskFiles) {
        if(this.isX5WebView) {
            this.mX5WebView.clearCache(includeDiskFiles);
        } else {
            this.mWebView.clearCache(includeDiskFiles);
        }
    }

    public void clearView() {
        if(this.isX5WebView) {
            this.mX5WebView.clearView();
        } else {
            this.mWebView.clearView();
        }
    }

    public void freeMemory(){
        if(this.isX5WebView) {
            this.mX5WebView.freeMemory();
        } else {
            this.mWebView.freeMemory();
        }
    }

    public void pauseTimers(){
        if(this.isX5WebView) {
            this.mX5WebView.pauseTimers();
        } else {
            this.mWebView.pauseTimers();
        }
    }

    public void resumeTimers(){
        if (this.isX5WebView) {
            this.mX5WebView.resumeTimers();
        } else {
            this.mWebView.resumeTimers();
        }
    }

    public String getTitle() {
        return this.isX5WebView? this.mX5WebView.getTitle(): this.mWebView.getTitle();
    }

    public String getOriginalUrl(){
        return this.isX5WebView? this.mX5WebView.getOriginalUrl(): this.mWebView.getOriginalUrl();
    }

    public String getUrl() {
        return this.isX5WebView? this.mX5WebView.getUrl(): this.mWebView.getUrl();
    }

    public WebSettings getSettings() {
        return this.mWebSettings != null?this.mWebSettings:(this.isX5WebView?(this.mWebSettings = new WebSettings(this.mX5WebView.getSettings())):(this.mWebSettings = new WebSettings(this.mWebView.getSettings())));
    }

    public void stopLoading() {
        if (this.isX5WebView) {
            this.mX5WebView.stopLoading();
        } else {
            this.mWebView.stopLoading();
        }
    }

    public void setInitialScale(int scale) {
        if(this.isX5WebView) {
            this.mX5WebView.setInitialScale(scale);
        } else {
            this.mWebView.setInitialScale(scale);
        }
    }

    public int getContentHeight() {
        return this.isX5WebView? this.mX5WebView.getContentHeight(): this.mWebView.getContentHeight();
    }

    public float getScale() {
        return this.isX5WebView? this.mX5WebView.getScale(): this.mWebView.getScale();
    }

    public HitTestResult getHitTestResult(){
        return this.isX5WebView? new HitTestResult(this.mX5WebView.getHitTestResult()): new HitTestResult(this.mWebView.getHitTestResult());
    }

    public void setWebChromeClient(WebChromeClient webChromeClient) {
        if(this.isX5WebView) {
            this.mX5WebView.setWebChromeClient(webChromeClient == null? null: new X5WebChromeClient(this, webChromeClient));
        } else {
            this.mWebView.setWebChromeClient(webChromeClient == null?null:new SystemWebChromeClient(this, webChromeClient));
        }
    }

    public void setWebViewClient(WebViewClient webViewClient) {
        if (this.isX5WebView)
            mX5WebView.setWebViewClient(webViewClient == null? null: new X5WebViewClient(this, webViewClient));
        else
            mWebView.setWebViewClient(webViewClient == null? null: new SystemWebViewClient(this, webViewClient));
    }

    public void onResume() {
        if (this.isX5WebView)
            mX5WebView.onResume();
        else
            mWebView.onResume();
    }

    public void onPause() {
        if (this.isX5WebView)
            mX5WebView.onPause();
        else
            mWebView.onPause();
    }

    public void destroy() {
        if (this.isX5WebView)
            mX5WebView.destroy();
        else
            mWebView.destroy();
    }

    public int getWebScrollX() {
        return this.isX5WebView?this.mX5WebView.getWebScrollX():this.mWebView.getScrollX();
    }

    public int getWebScrollY() {
        if(this.isX5WebView) {
            return this.mX5WebView.getWebScrollY();
        } else {
            return this.mWebView.getScrollY();
        }
    }

    public WebViewScrollChangeListener getWebViewScrollChangeListener() {
        return onWebViewScrollChangeListener;
    }

    public void setOnWebViewScrollChangeListener(WebViewScrollChangeListener onWebViewScrollChangeListener) {
        this.onWebViewScrollChangeListener = onWebViewScrollChangeListener;
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        if (onWebViewScrollChangeListener != null) {
            onWebViewScrollChangeListener.onScrollChange(this, l, t, oldl, oldt);
        }
        super.onScrollChanged(l, t, oldl, oldt);
    }

    public interface WebViewScrollChangeListener {
        void onScrollChange(WebView webView, int l, int t, int oldl, int oldt);
    }

    @Override
    public void setLayerType(int layerType, Paint paint) {
        if (this.isX5WebView)
            mX5WebView.setLayerType(layerType, paint);
        else
            mWebView.setLayerType(layerType, paint);
    }

    @Override
    public void scrollTo(int x, int y) {
        if (this.isX5WebView)
            mX5WebView.scrollTo(x, y);
        else
            mWebView.scrollTo(x, y);
    }

    @Override
    public void setVerticalScrollBarEnabled(boolean verticalScrollBarEnabled) {
        if (this.isX5WebView)
            mX5WebView.setVerticalScrollBarEnabled(verticalScrollBarEnabled);
        else
            mWebView.setVerticalScrollBarEnabled(verticalScrollBarEnabled);
    }

    public static class HitTestResult {
        public static final int UNKNOWN_TYPE = 0;
        @Deprecated
        public static final int ANCHOR_TYPE = 1;
        public static final int PHONE_TYPE = 2;
        public static final int GEO_TYPE = 3;
        public static final int EMAIL_TYPE = 4;
        public static final int IMAGE_TYPE = 5;
        @Deprecated
        public static final int IMAGE_ANCHOR_TYPE = 6;
        public static final int SRC_ANCHOR_TYPE = 7;
        public static final int SRC_IMAGE_ANCHOR_TYPE = 8;
        public static final int EDIT_TEXT_TYPE = 9;
        private com.tencent.smtt.sdk.WebView.HitTestResult a;
        private android.webkit.WebView.HitTestResult b = null;

        public HitTestResult() {
            this.a = null;
            this.b = null;
        }

        public HitTestResult(com.tencent.smtt.sdk.WebView.HitTestResult var1) {
            this.a = var1;
            this.b = null;
        }

        public HitTestResult(android.webkit.WebView.HitTestResult var1) {
            this.a = null;
            this.b = var1;
        }

        public int getType() {
            int var1 = 0;
            if(this.a != null) {
                var1 = this.a.getType();
            } else if(this.b != null) {
                var1 = this.b.getType();
            }

            return var1;
        }

        public String getExtra() {
            String var1 = "";
            if(this.a != null) {
                var1 = this.a.getExtra();
            } else if(this.b != null) {
                var1 = this.b.getExtra();
            }

            return var1;
        }
    }

    class SystemWebView extends android.webkit.WebView {
        public SystemWebView(Context var2) {
            this(var2, null);
        }

        public SystemWebView(Context var2, AttributeSet var3) {
            super(var2, var3);
        }

        protected void onScrollChanged(int var1, int var2, int var3, int var4) {
            super.onScrollChanged(var1, var2, var3, var4);
            WebView.this.onScrollChanged(var1, var2, var3, var4);
        }

        @SuppressLint({"ClickableViewAccessibility"})
        public boolean onTouchEvent(MotionEvent var1) {
            if(!this.hasFocus()) {
                this.requestFocus();
            }
            try {
                return super.onTouchEvent(var1);
            } catch (Exception var3) {
                var3.printStackTrace();
                return false;
            }
        }
    }

    class X5WebView extends com.tencent.smtt.sdk.WebView {
        public X5WebView(Context var2) {
            this(var2, null);
        }

        public X5WebView(Context var2, AttributeSet var3) {
            super(var2, var3);
        }

        protected void onScrollChanged(int var1, int var2, int var3, int var4) {
            super.onScrollChanged(var1, var2, var3, var4);
            WebView.this.onScrollChanged(var1, var2, var3, var4);
        }

        @SuppressLint({"ClickableViewAccessibility"})
        public boolean onTouchEvent(MotionEvent var1) {
            if(!this.hasFocus()) {
                this.requestFocus();
            }
            try {
                return super.onTouchEvent(var1);
            } catch (Exception var3) {
                var3.printStackTrace();
                return false;
            }
        }
    }
}
