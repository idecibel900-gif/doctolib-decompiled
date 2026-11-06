package app.screeb.sdk.internal;

import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes3.dex */
public final class H implements Runnable {
    public final /* synthetic */ J a;

    public H(J j) {
        this.a = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int iCoerceAtLeast;
        C0296d c0296d = this.a.f;
        synchronized (c0296d) {
            iCoerceAtLeast = RangesKt.coerceAtLeast(c0296d.i - 1, 0);
            c0296d.i = iCoerceAtLeast;
        }
        if (iCoerceAtLeast > 0) {
            this.a.I.postDelayed(this, 15000L);
        }
    }
}
