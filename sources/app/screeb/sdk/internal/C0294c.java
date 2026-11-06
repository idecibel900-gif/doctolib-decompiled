package app.screeb.sdk.internal;

import android.view.Window;
import java.lang.ref.WeakReference;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: app.screeb.sdk.internal.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0294c {
    public final Function0 a;
    public WeakReference b;
    public Window.Callback c;

    public C0294c(Function0 onActivity) {
        Intrinsics.checkNotNullParameter(onActivity, "onActivity");
        this.a = onActivity;
    }

    public final void a() {
        Window window;
        WeakReference weakReference = this.b;
        if (weakReference == null || (window = (Window) weakReference.get()) == null) {
            return;
        }
        try {
            Window.Callback callback = window.getCallback();
            if ((callback instanceof WindowCallbackC0292b) && ((WindowCallbackC0292b) callback).a() == this) {
                window.setCallback(this.c);
            }
        } catch (Throwable th) {
            Z z = Z.b;
            Y.a();
            Z.b("Command", "ActivityTouchObserver.detach failed: " + th.getClass().getSimpleName());
        }
        this.b = null;
        this.c = null;
    }

    public final boolean a(Window window) {
        Intrinsics.checkNotNullParameter(window, "window");
        WeakReference weakReference = this.b;
        if ((weakReference != null ? (Window) weakReference.get() : null) != window) {
            return false;
        }
        Window.Callback callback = window.getCallback();
        WindowCallbackC0292b windowCallbackC0292b = callback instanceof WindowCallbackC0292b ? (WindowCallbackC0292b) callback : null;
        return (windowCallbackC0292b != null ? windowCallbackC0292b.b : null) == this;
    }
}
