package app.screeb.sdk.internal;

import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: app.screeb.sdk.internal.y, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class ComponentCallbacks2C0325y implements ComponentCallbacks2 {
    public final /* synthetic */ A a;

    public ComponentCallbacks2C0325y(A a) {
        this.a = a;
    }

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        J j = (J) this.a.b.get();
        if (j != null) {
            j.Y0 = 0L;
            j.f();
        }
    }

    @Override // android.content.ComponentCallbacks
    public final /* synthetic */ void onLowMemory() {
        J j = (J) this.a.b.get();
        if (j != null) {
            j.a(2);
        }
    }

    @Override // android.content.ComponentCallbacks2
    public final void onTrimMemory(int i) {
        J j = (J) this.a.b.get();
        if (j == null) {
            return;
        }
        if (i >= 20) {
            Z z = Z.b;
            Y.a();
            Z.a("trim memory level=" + i + " → app hidden, pausing mirror");
            j.b(false);
            j.a(2);
            return;
        }
        if (i >= 15) {
            Z z2 = Z.b;
            Y.a();
            Z.a("trim memory level=" + i + " → pressure=2");
            j.a(2);
            return;
        }
        if (i >= 10) {
            Z z3 = Z.b;
            Y.a();
            Z.a("trim memory level=" + i + " → pressure=1");
            j.a(1);
        }
    }
}
