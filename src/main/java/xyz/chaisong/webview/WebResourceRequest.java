package xyz.chaisong.webview;

import android.net.Uri;

import java.util.Map;

/**
 * Created by song on 16/10/19.
 */

public interface WebResourceRequest {
    Uri getUrl();

    boolean isForMainFrame();

    boolean hasGesture();

    String getMethod();

    Map<String, String> getRequestHeaders();
}
