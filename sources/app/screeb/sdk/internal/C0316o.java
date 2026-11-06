package app.screeb.sdk.internal;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: app.screeb.sdk.internal.o, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0316o {
    public final byte[] a;
    public final int b;
    public final r c;

    public C0316o(byte[] bytes, int i, r recycler) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        Intrinsics.checkNotNullParameter(recycler, "recycler");
        this.a = bytes;
        this.b = i;
        this.c = recycler;
    }

    public final byte[] a() {
        byte[] bArrCopyOf = Arrays.copyOf(this.a, this.b);
        Intrinsics.checkNotNullExpressionValue(bArrCopyOf, "copyOf(...)");
        return bArrCopyOf;
    }

    public final void b() {
        this.c.invoke(this.a);
    }
}
