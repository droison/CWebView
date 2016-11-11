package xyz.chaisong.webview;

/**
 * Created by song on 16/10/19.
 */

public interface ConsoleMessage {
    ConsoleMessage.MessageLevel messageLevel();

    String message();

    String sourceId();

    int lineNumber();

    public static enum MessageLevel {
        TIP,
        LOG,
        WARNING,
        ERROR,
        DEBUG;

        private MessageLevel() {
        }
    }
}
