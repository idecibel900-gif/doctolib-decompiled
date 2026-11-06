package app.screeb.sdk.internal;

import android.view.View;
import android.view.ViewParent;
import android.view.Window;
import android.widget.FrameLayout;
import app.screeb.sdk.Screeb;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class W implements View.OnAttachStateChangeListener {
    public final /* synthetic */ FrameLayout a;
    public final /* synthetic */ Window b;
    public final /* synthetic */ int c;

    public W(FrameLayout frameLayout, Window window, int i) {
        this.a = frameLayout;
        this.b = window;
        this.c = i;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View v) {
        Intrinsics.checkNotNullParameter(v, "v");
        v.removeOnAttachStateChangeListener(this);
        ViewParent parent = v.getParent();
        FrameLayout frameLayout = this.a;
        if (parent == frameLayout) {
            Screeb.INSTANCE.applyOverlayFrame(this.b, frameLayout, v, this.c);
        }
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View v) {
        Intrinsics.checkNotNullParameter(v, "v");
        v.removeOnAttachStateChangeListener(this);
    }
}
