package app.screeb.sdk.internal;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.util.Base64;
import android.webkit.WebMessage;
import android.webkit.WebMessagePort;
import android.webkit.WebView;
import androidx.webkit.WebMessageCompat;
import androidx.webkit.WebMessagePortCompat;
import androidx.webkit.WebViewCompat;
import androidx.webkit.WebViewFeature;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class K0 {
    public final WebView a;
    public final Handler b;
    public volatile WebMessagePortCompat c;
    public volatile WebMessagePort d;
    public Function0 e;
    public Function0 f;

    public K0(WebView webView) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        this.a = webView;
        this.b = new Handler(Looper.getMainLooper());
    }

    public static final void a(WebMessagePort webMessagePort, String str, K0 k0) {
        try {
            webMessagePort.postMessage(new WebMessage(str));
        } catch (Throwable th) {
            Z z = Z.b;
            Y.a();
            Z.b("Mirror", "string postMessage failed: " + th.getClass().getSimpleName());
            k0.d = null;
            Intrinsics.checkNotNull(str);
            k0.a(str);
        }
    }

    public static final void a(WebMessagePortCompat webMessagePortCompat, byte[] bArr, K0 k0, boolean z, C0316o c0316o) {
        try {
            webMessagePortCompat.postMessage(new WebMessageCompat(bArr));
            if (!z) {
            }
        } catch (Throwable th) {
            try {
                Z z2 = Z.b;
                Y.a();
                Z.b("Mirror", "binary postMessage failed: " + th.getClass().getSimpleName());
                k0.c = null;
                String strEncodeToString = Base64.encodeToString(bArr, 0, bArr.length, 2);
                Intrinsics.checkNotNullExpressionValue(strEncodeToString, "encodeToString(...)");
                k0.a(strEncodeToString);
            } finally {
                if (z) {
                    c0316o.b();
                }
            }
        }
    }

    public static final void a(K0 k0) {
        boolean z;
        String simpleName;
        StringBuilder sb;
        try {
            z = WebViewFeature.isFeatureSupported("CREATE_WEB_MESSAGE_CHANNEL") && WebViewFeature.isFeatureSupported("POST_WEB_MESSAGE") && WebViewFeature.isFeatureSupported("WEB_MESSAGE_PORT_SET_MESSAGE_CALLBACK") && WebViewFeature.isFeatureSupported("WEB_MESSAGE_PORT_POST_MESSAGE") && WebViewFeature.isFeatureSupported("WEB_MESSAGE_GET_MESSAGE_PAYLOAD");
        } catch (Throwable unused) {
        }
        try {
            if (z) {
                k0.b();
            } else {
                k0.c();
            }
        } catch (Throwable th) {
            if (z) {
                try {
                    k0.c();
                    return;
                } catch (Throwable th2) {
                    Z z2 = Z.b;
                    Y.a();
                    Z z3 = Z.b;
                    simpleName = th2.getClass().getSimpleName();
                    sb = new StringBuilder();
                    sb.append("WebTransport channel install failed: ");
                    sb.append(simpleName);
                    Z.b("Mirror", sb.toString());
                }
            }
            Z z4 = Z.b;
            Y.a();
            simpleName = th.getClass().getSimpleName();
            sb = new StringBuilder();
            sb.append("WebTransport channel install failed: ");
            sb.append(simpleName);
            Z.b("Mirror", sb.toString());
        }
    }

    public static final void a(K0 k0, String str) {
        try {
            k0.a.evaluateJavascript("window.__sr_apply&&window.__sr_apply('" + str + "')", null);
        } catch (Throwable unused) {
        }
    }

    public final void a() {
        this.a.post(new Runnable() { // from class: app.screeb.sdk.internal.K0$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                K0.a(this.f$0);
            }
        });
    }

    public final void a(final C0316o message) {
        Intrinsics.checkNotNullParameter(message, "message");
        final WebMessagePortCompat webMessagePortCompat = this.c;
        if (webMessagePortCompat != null) {
            byte[] bArrA = message.a;
            final boolean z = bArrA.length == message.b;
            if (!z) {
                bArrA = message.a();
            }
            final byte[] bArr = bArrA;
            if (!z) {
                message.c.invoke(message.a);
            }
            this.b.post(new Runnable() { // from class: app.screeb.sdk.internal.K0$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    K0.a(webMessagePortCompat, bArr, this, z, message);
                }
            });
            return;
        }
        final WebMessagePort webMessagePort = this.d;
        if (webMessagePort != null) {
            final String strEncodeToString = Base64.encodeToString(message.a, 0, message.b, 2);
            message.c.invoke(message.a);
            this.b.post(new Runnable() { // from class: app.screeb.sdk.internal.K0$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    K0.a(webMessagePort, strEncodeToString, this);
                }
            });
        } else {
            String strEncodeToString2 = Base64.encodeToString(message.a, 0, message.b, 2);
            message.c.invoke(message.a);
            Intrinsics.checkNotNull(strEncodeToString2);
            a(strEncodeToString2);
        }
    }

    public final void a(final String str) {
        this.b.post(new Runnable() { // from class: app.screeb.sdk.internal.K0$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                K0.a(this.f$0, str);
            }
        });
    }

    public final void b() {
        WebMessagePortCompat[] webMessagePortCompatArrCreateWebMessageChannel = WebViewCompat.createWebMessageChannel(this.a);
        Intrinsics.checkNotNullExpressionValue(webMessagePortCompatArrCreateWebMessageChannel, "createWebMessageChannel(...)");
        WebMessagePortCompat webMessagePortCompat = webMessagePortCompatArrCreateWebMessageChannel[0];
        WebViewCompat.postWebMessage(this.a, new WebMessageCompat("", new WebMessagePortCompat[]{webMessagePortCompatArrCreateWebMessageChannel[1]}), Uri.parse("*"));
        webMessagePortCompat.setWebMessageCallback(this.b, new I0(this));
        this.c = webMessagePortCompat;
        Z.a("Mirror", "WebTransport: binary ArrayBuffer channel ready");
    }

    public final void c() {
        WebMessagePort[] webMessagePortArrCreateWebMessageChannel = this.a.createWebMessageChannel();
        Intrinsics.checkNotNullExpressionValue(webMessagePortArrCreateWebMessageChannel, "createWebMessageChannel(...)");
        WebMessagePort webMessagePort = webMessagePortArrCreateWebMessageChannel[0];
        this.a.postWebMessage(new WebMessage("", new WebMessagePort[]{webMessagePortArrCreateWebMessageChannel[1]}), Uri.parse("*"));
        webMessagePort.setWebMessageCallback(new J0(this), this.b);
        this.d = webMessagePort;
        Z.a("Mirror", "WebTransport: base64 string channel ready");
    }

    public final void d() {
        WebMessagePortCompat webMessagePortCompat;
        try {
            if (WebViewFeature.isFeatureSupported("WEB_MESSAGE_PORT_CLOSE") && (webMessagePortCompat = this.c) != null) {
                webMessagePortCompat.close();
            }
        } catch (Throwable unused) {
        }
        try {
            WebMessagePort webMessagePort = this.d;
            if (webMessagePort != null) {
                webMessagePort.close();
            }
        } catch (Throwable unused2) {
        }
        this.c = null;
        this.d = null;
    }
}
