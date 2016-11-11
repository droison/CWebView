package xyz.chaisong.webview;

/**
 * Created by song on 16/10/19.
 */

public interface ValueCallback<T> extends com.tencent.smtt.sdk.ValueCallback<T> {
    /**
     * Invoked when the value is available.
     * @param value The value.
     */
    public void onReceiveValue(T value);
};
