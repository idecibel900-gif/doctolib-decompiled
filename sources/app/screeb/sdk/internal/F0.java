package app.screeb.sdk.internal;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class F0 {
    public static void a(long j, long j2, G0 kind, int i, int i2, int i3, int i4, O src, O out, int i5) {
        if ((i5 & 64) != 0) {
            i3 = 0;
        }
        Intrinsics.checkNotNullParameter(kind, "kind");
        Intrinsics.checkNotNullParameter(src, "patches");
        Intrinsics.checkNotNullParameter(out, "out");
        out.a(1);
        out.a.put((byte) 8);
        out.b(2L);
        out.b(j);
        out.b(j2);
        out.b(kind.a);
        out.b(i);
        out.b(i2);
        out.b(1);
        out.a(0);
        out.a(i3);
        out.b(i4);
        Intrinsics.checkNotNullParameter(src, "src");
        int iPosition = src.a.position();
        if (iPosition == 0) {
            return;
        }
        out.a(iPosition);
        src.a.flip();
        out.a.put(src.a);
        src.a.clear();
    }
}
