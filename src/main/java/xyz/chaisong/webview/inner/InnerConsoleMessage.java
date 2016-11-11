package xyz.chaisong.webview.inner;

import xyz.chaisong.webview.ConsoleMessage;

/**
 * Created by song on 16/10/19.
 */

public class InnerConsoleMessage implements ConsoleMessage {
    private ConsoleMessage.MessageLevel a;
    private String b;
    private String c;
    private int d;

    InnerConsoleMessage(android.webkit.ConsoleMessage var1) {
        this.a = ConsoleMessage.MessageLevel.valueOf(var1.messageLevel().name());
        this.b = var1.message();
        this.c = var1.sourceId();
        this.d = var1.lineNumber();
    }

    InnerConsoleMessage(com.tencent.smtt.export.external.interfaces.ConsoleMessage var1) {
        this.a = ConsoleMessage.MessageLevel.valueOf(var1.messageLevel().name());
        this.b = var1.message();
        this.c = var1.sourceId();
        this.d = var1.lineNumber();
    }

    InnerConsoleMessage(String var1, String var2, int var3) {
        this.a = ConsoleMessage.MessageLevel.LOG;
        this.b = var1;
        this.c = var2;
        this.d = var3;
    }

    public ConsoleMessage.MessageLevel messageLevel() {
        return this.a;
    }

    public String message() {
        return this.b;
    }

    public String sourceId() {
        return this.c;
    }

    public int lineNumber() {
        return this.d;
    }
}
