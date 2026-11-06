package androidx.webkit.internal;

import android.webkit.WebView;
import org.chromium.support_lib_boundary.StaticsBoundaryInterface;
import org.chromium.support_lib_boundary.WebViewProviderBoundaryInterface;
import org.chromium.support_lib_boundary.WebkitToCompatConverterBoundaryInterface;

/* JADX INFO: loaded from: classes.dex */
public interface WebViewProviderFactory {
    WebViewProviderBoundaryInterface createWebView(WebView webView);

    StaticsBoundaryInterface getStatics();

    String[] getWebViewFeatures();

    WebkitToCompatConverterBoundaryInterface getWebkitToCompatConverter();
}
