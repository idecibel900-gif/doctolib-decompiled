package app.screeb.sdk.internal;

import androidx.webkit.WebMessageCompat;
import androidx.webkit.WebMessagePortCompat;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class I0 extends WebMessagePortCompat.WebMessageCallbackCompat {
    public final /* synthetic */ K0 a;

    public I0(K0 k0) {
        this.a = k0;
    }

    @Override // androidx.webkit.WebMessagePortCompat.WebMessageCallbackCompat
    public final void onMessage(WebMessagePortCompat port, WebMessageCompat webMessageCompat) {
        Function0 function0;
        Intrinsics.checkNotNullParameter(port, "port");
        String data = webMessageCompat != null ? webMessageCompat.getData() : null;
        if (Intrinsics.areEqual(data != null ? data : null, "F")) {
            function0 = this.a.f;
            if (function0 == null) {
                return;
            }
        } else {
            function0 = this.a.e;
            if (function0 == null) {
                return;
            }
        }
        function0.invoke();
    }
}
