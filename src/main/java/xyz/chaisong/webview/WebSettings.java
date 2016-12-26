package xyz.chaisong.webview;

import android.os.Build;

/**
 * Created by song on 16/10/19.
 */

public class WebSettings {
    private boolean isX5WebSetting = false;
    private com.tencent.smtt.sdk.WebSettings mX5WebSettings;
    private android.webkit.WebSettings mWebSettings;

    private WebSettings(){

    }

    WebSettings(android.webkit.WebSettings webSettings) {
        mWebSettings = webSettings;
    }

    WebSettings(com.tencent.smtt.sdk.WebSettings x5WebSetting) {
        this.isX5WebSetting = true;
        this.mX5WebSettings = x5WebSetting;
    }

    public String getUserAgentString(){
        return this.isX5WebSetting? mX5WebSettings.getUserAgentString(): mWebSettings.getUserAgentString();
    }

    public void setUserAgentString(String ua){
        if (this.isX5WebSetting) {
            mX5WebSettings.setUserAgentString(ua);
        } else {
            mWebSettings.setUserAgentString(ua);
        }
    }

    public void setPluginState(PluginState state) {
        if (this.isX5WebSetting) {
            mX5WebSettings.setPluginState(com.tencent.smtt.sdk.WebSettings.PluginState.valueOf(state.name()));
        } else {
            mWebSettings.setPluginState(android.webkit.WebSettings.PluginState.valueOf(state.name()));
        }
    }

    public void setDomStorageEnabled(boolean enabled) {
        if (this.isX5WebSetting) {
            mX5WebSettings.setDomStorageEnabled(enabled);
        } else {
            mWebSettings.setDomStorageEnabled(enabled);
        }
    }

    public void setJavaScriptEnabled(boolean enabled) {
        if (this.isX5WebSetting) {
            mX5WebSettings.setJavaScriptEnabled(enabled);
        } else {
            mWebSettings.setJavaScriptEnabled(enabled);
        }
    }

    public void setDatabaseEnabled(boolean enabled) {
        if (this.isX5WebSetting) {
            mX5WebSettings.setDatabaseEnabled(enabled);
        } else {
            mWebSettings.setDatabaseEnabled(enabled);
        }
    }

    public void setDatabasePath(String path) {
        if (this.isX5WebSetting) {
            mX5WebSettings.setDatabasePath(path);
        } else {
            mWebSettings.setDatabasePath(path);
        }
    }

    public void setAppCacheEnabled(boolean enabled) {
        if (this.isX5WebSetting) {
            mX5WebSettings.setAppCacheEnabled(enabled);
        } else {
            mWebSettings.setAppCacheEnabled(enabled);
        }
    }

    public void setAppCachePath(String path) {
        if (this.isX5WebSetting) {
            mX5WebSettings.setAppCachePath(path);
        } else {
            mWebSettings.setAppCachePath(path);
        }
    }

    public void setAppCacheMaxSize(long size) {
        if (this.isX5WebSetting) {
            mX5WebSettings.setAppCacheMaxSize(size);
        } else {
            mWebSettings.setAppCacheMaxSize(size);
        }
    }

    public void setLoadWithOverviewMode(boolean mode) {
        if (this.isX5WebSetting) {
            mX5WebSettings.setLoadWithOverviewMode(mode);
        } else {
            mWebSettings.setLoadWithOverviewMode(mode);
        }
    }

    public void setUseWideViewPort(boolean enabled) {
        if (this.isX5WebSetting) {
            mX5WebSettings.setUseWideViewPort(enabled);
        } else {
            mWebSettings.setUseWideViewPort(enabled);
        }
    }

    public void setLayoutAlgorithm(LayoutAlgorithm l) {
        if (this.isX5WebSetting) {
            mX5WebSettings.setLayoutAlgorithm(com.tencent.smtt.sdk.WebSettings.LayoutAlgorithm.valueOf(l.name()));
        } else {
            mWebSettings.setLayoutAlgorithm(android.webkit.WebSettings.LayoutAlgorithm.valueOf(l.name()));
        }
    }

    public void setCacheMode(int mode) {
        if (this.isX5WebSetting) {
            mX5WebSettings.setCacheMode(mode);
        } else {
            mWebSettings.setCacheMode(mode);
        }
    }

    public void setAllowFileAccess(boolean mode) {
        if (this.isX5WebSetting) {
            mX5WebSettings.setAllowFileAccess(mode);
        } else {
            mWebSettings.setAllowFileAccess(mode);
        }
    }

    public void setSupportZoom(boolean mode) {
        if (this.isX5WebSetting) {
            mX5WebSettings.setSupportZoom(mode);
        } else {
            mWebSettings.setSupportZoom(mode);
        }
    }

    public void setGeolocationEnabled(boolean mode) {
        if (this.isX5WebSetting) {
            mX5WebSettings.setGeolocationEnabled(mode);
        } else {
            mWebSettings.setGeolocationEnabled(mode);
        }
    }

    public void setRenderPriority(WebSettings.RenderPriority priority) {
        if (this.isX5WebSetting) {
            mX5WebSettings.setRenderPriority(com.tencent.smtt.sdk.WebSettings.RenderPriority.valueOf(priority.name()));
        } else {
            mWebSettings.setRenderPriority(android.webkit.WebSettings.RenderPriority.valueOf(priority.name()));
        }
    }

    public void setMixedContentMode(int mode) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            if (this.isX5WebSetting) {
                mX5WebSettings.setMixedContentMode(mode);
            } else {
                mWebSettings.setMixedContentMode(mode);
            }
        }
    }

    /**
     * Default cache usage mode. If the navigation type doesn't impose any
     * specific behavior, use cached resources when they are available
     * and not expired, otherwise load resources from the network.
     * Use with {@link #setCacheMode}.
     */
    public static final int LOAD_DEFAULT = -1;

    /**
     * Normal cache usage mode. Use with {@link #setCacheMode}.
     *
     * @deprecated This value is obsolete, as from API level
     * {@link android.os.Build.VERSION_CODES#HONEYCOMB} and onwards it has the
     * same effect as {@link #LOAD_DEFAULT}.
     */
    @Deprecated
    public static final int LOAD_NORMAL = 0;

    /**
     * Use cached resources when they are available, even if they have expired.
     * Otherwise load resources from the network.
     * Use with {@link #setCacheMode}.
     */
    public static final int LOAD_CACHE_ELSE_NETWORK = 1;

    /**
     * Don't use the cache, load from the network.
     * Use with {@link #setCacheMode}.
     */
    public static final int LOAD_NO_CACHE = 2;

    /**
     * Don't use the network, load from the cache.
     * Use with {@link #setCacheMode}.
     */
    public static final int LOAD_CACHE_ONLY = 3;

    public static enum PluginState {
        ON,
        ON_DEMAND,
        OFF;

        private PluginState() {
        }
    }

    public enum LayoutAlgorithm {
        NORMAL,
        /**
         * @deprecated This algorithm is now obsolete.
         */
        @Deprecated
        SINGLE_COLUMN,
        /**
         * @deprecated This algorithm is now obsolete.
         */
        @Deprecated
        NARROW_COLUMNS,
        TEXT_AUTOSIZING
    }

    public static enum RenderPriority {
        NORMAL,
        HIGH,
        LOW;

        private RenderPriority() {
        }
    }

    /**
     * Used with {@link #setMixedContentMode}
     *
     * In this mode, the WebView will allow a secure origin to load content from any other origin,
     * even if that origin is insecure. This is the least secure mode of operation for the WebView,
     * and where possible apps should not set this mode.
     */
    public static final int MIXED_CONTENT_ALWAYS_ALLOW = 0;

    /**
     * Used with {@link #setMixedContentMode}
     *
     * In this mode, the WebView will not allow a secure origin to load content from an insecure
     * origin. This is the preferred and most secure mode of operation for the WebView and apps are
     * strongly advised to use this mode.
     */
    public static final int MIXED_CONTENT_NEVER_ALLOW = 1;

    /**
     * Used with {@link #setMixedContentMode}
     *
     * In this mode, the WebView will attempt to be compatible with the approach of a modern web
     * browser with regard to mixed content. Some insecure content may be allowed to be loaded by
     * a secure origin and other types of content will be blocked. The types of content are allowed
     * or blocked may change release to release and are not explicitly defined.
     *
     * This mode is intended to be used by apps that are not in control of the content that they
     * render but desire to operate in a reasonably secure environment. For highest security, apps
     * are recommended to use {@link #MIXED_CONTENT_NEVER_ALLOW}.
     */
    public static final int MIXED_CONTENT_COMPATIBILITY_MODE = 2;
}
