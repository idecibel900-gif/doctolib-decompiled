package app.screeb.sdk.internal;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: app.screeb.sdk.internal.i0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0307i0 implements K {
    public final T a = new T();

    @Override // app.screeb.sdk.internal.K
    public final long a(N buf, View view, View view2, long j, int i, int i2, boolean z, int i3, int i4, int i5, int i6, boolean z2, boolean z3) {
        Intrinsics.checkNotNullParameter(buf, "buf");
        Intrinsics.checkNotNullParameter(view, "view");
        int[] iArr = Q.a;
        return Q.a(buf, view, view2, j, i, i2, z, i3, i4, false, true, true, this.a, i5, i6, z2, z3);
    }

    @Override // app.screeb.sdk.internal.K
    public final T a() {
        return this.a;
    }

    public final T b() {
        return this.a;
    }
}
