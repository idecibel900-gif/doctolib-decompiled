package expo.modules.webview;

import android.webkit.JavascriptInterface;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class DomWebViewBridge {
    private final DomWebView webView;

    public DomWebViewBridge(DomWebView webView) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        this.webView = webView;
    }

    @JavascriptInterface
    public final String eval(String params) {
        Intrinsics.checkNotNullParameter(params, "params");
        return this.webView.evalSync(params);
    }
}
