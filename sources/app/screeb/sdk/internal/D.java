package app.screeb.sdk.internal;

import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class D {
    public static void a(O src, O target) {
        Intrinsics.checkNotNullParameter(src, "source");
        Intrinsics.checkNotNullParameter(target, "target");
        synchronized (src) {
            try {
                if (!src.b()) {
                    target.getClass();
                    Intrinsics.checkNotNullParameter(src, "src");
                    int iPosition = src.a.position();
                    if (iPosition != 0) {
                        target.a(iPosition);
                        src.a.flip();
                        target.a.put(src.a);
                        src.a.clear();
                    }
                    src.a.clear();
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
