package androidx.webkit;

import android.os.Build;
import android.webkit.WebSettings;
import androidx.webkit.internal.ApiFeature;
import androidx.webkit.internal.ApiHelperForQ;
import androidx.webkit.internal.WebSettingsAdapter;
import androidx.webkit.internal.WebSettingsNoOpAdapter;
import androidx.webkit.internal.WebViewFeatureInternal;
import androidx.webkit.internal.WebViewGlueCommunicator;

/* JADX INFO: loaded from: classes.dex */
public abstract class WebSettingsCompat {
    public static void setForceDark(WebSettings webSettings, int i) {
        ApiFeature.Q q = WebViewFeatureInternal.FORCE_DARK;
        if (q.isSupportedByFramework()) {
            ApiHelperForQ.setForceDark(webSettings, i);
        } else {
            if (q.isSupportedByWebView()) {
                getAdapter(webSettings).setForceDark(i);
                return;
            }
            throw WebViewFeatureInternal.getUnsupportedOperationException();
        }
    }

    public static void setForceDarkStrategy(WebSettings webSettings, int i) {
        if (WebViewFeatureInternal.FORCE_DARK_STRATEGY.isSupportedByWebView()) {
            getAdapter(webSettings).setForceDarkStrategy(i);
            return;
        }
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    public static void setPaymentRequestEnabled(WebSettings webSettings, boolean z) {
        if (WebViewFeatureInternal.PAYMENT_REQUEST.isSupportedByWebView()) {
            getAdapter(webSettings).setPaymentRequestEnabled(z);
            return;
        }
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    private static WebSettingsAdapter getAdapter(WebSettings webSettings) {
        try {
            return WebViewGlueCommunicator.getCompatConverter().convertSettings(webSettings);
        } catch (ClassCastException e) {
            if (Build.VERSION.SDK_INT == 30 && "android.webkit.WebSettingsWrapper".equals(webSettings.getClass().getCanonicalName())) {
                return new WebSettingsNoOpAdapter();
            }
            throw e;
        }
    }
}
