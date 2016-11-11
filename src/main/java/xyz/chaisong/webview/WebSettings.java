package xyz.chaisong.webview;

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
}
