package expo.modules.webview;

import android.webkit.JavascriptInterface;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class RNCWebViewBridge {
    private final DomWebView webView;

    public RNCWebViewBridge(DomWebView webView) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        this.webView = webView;
    }

    @JavascriptInterface
    public final void postMessage(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        this.webView.dispatchMessageEvent(message);
    }
}
