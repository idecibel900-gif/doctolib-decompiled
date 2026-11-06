package expo.modules.webview;

import androidx.collection.ArrayMap;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class DomWebViewRegistry {
    private static int nextWebViewId;
    public static final DomWebViewRegistry INSTANCE = new DomWebViewRegistry();
    private static final ArrayMap registry = new ArrayMap();

    private DomWebViewRegistry() {
    }

    public final synchronized DomWebView get(int i) {
        WeakDomWebViewRef weakDomWebViewRef;
        WeakReference ref;
        weakDomWebViewRef = (WeakDomWebViewRef) registry.get(Integer.valueOf(i));
        return (weakDomWebViewRef == null || (ref = weakDomWebViewRef.getRef()) == null) ? null : (DomWebView) ref.get();
    }

    public final synchronized int add(DomWebView webView) {
        int i;
        Intrinsics.checkNotNullParameter(webView, "webView");
        i = nextWebViewId;
        registry.put(Integer.valueOf(i), new WeakDomWebViewRef(new WeakReference(webView)));
        nextWebViewId++;
        return i;
    }

    public final synchronized void reset() {
        registry.clear();
        nextWebViewId = 0;
    }
}
