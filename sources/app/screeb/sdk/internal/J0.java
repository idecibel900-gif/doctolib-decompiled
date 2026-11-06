package app.screeb.sdk.internal;

import android.webkit.WebMessage;
import android.webkit.WebMessagePort;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class J0 extends WebMessagePort.WebMessageCallback {
    public final /* synthetic */ K0 a;

    public J0(K0 k0) {
        this.a = k0;
    }

    @Override // android.webkit.WebMessagePort.WebMessageCallback
    public final void onMessage(WebMessagePort port, WebMessage webMessage) {
        Function0 function0;
        Intrinsics.checkNotNullParameter(port, "port");
        if (Intrinsics.areEqual(webMessage != null ? webMessage.getData() : null, "F")) {
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
