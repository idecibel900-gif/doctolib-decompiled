package app.screeb.sdk.internal;

import android.os.Handler;
import android.os.Looper;
import android.webkit.JavascriptInterface;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: app.screeb.sdk.internal.e0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0299e0 {
    public final /* synthetic */ C0303g0 a;

    public C0299e0(C0303g0 c0303g0) {
        this.a = c0303g0;
    }

    public static final void a(C0303g0 c0303g0, String str) {
        int i = C0303g0.$r8$clinit;
        c0303g0.c(str);
    }

    @JavascriptInterface
    public final void postMessage(final String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        Handler handler = new Handler(Looper.getMainLooper());
        final C0303g0 c0303g0 = this.a;
        handler.post(new Runnable() { // from class: app.screeb.sdk.internal.e0$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                C0299e0.a(c0303g0, message);
            }
        });
    }
}
