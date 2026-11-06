package app.screeb.sdk.internal;

import android.view.Choreographer;

/* JADX INFO: renamed from: app.screeb.sdk.internal.f0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class ChoreographerFrameCallbackC0301f0 implements Choreographer.FrameCallback {
    public final /* synthetic */ C0303g0 a;

    public ChoreographerFrameCallbackC0301f0(C0303g0 c0303g0) {
        this.a = c0303g0;
    }

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long j) {
        C0303g0 c0303g0 = this.a;
        if (c0303g0.i) {
            if (c0303g0.v == 0) {
                c0303g0.v = j;
            }
            long j2 = c0303g0.w;
            if (j2 != 0) {
                double d = (j - j2) / 1000000.0d;
                c0303g0.z = d;
                if (d > 24.0d) {
                    c0303g0.A++;
                }
            }
            c0303g0.w = j;
            int i = c0303g0.x + 1;
            c0303g0.x = i;
            long j3 = j - c0303g0.v;
            if (j3 >= 500000000) {
                c0303g0.y = (((double) i) * 1.0E9d) / j3;
                c0303g0.x = 0;
                c0303g0.v = j;
                c0303g0.invalidate();
            }
            Choreographer.getInstance().postFrameCallback(this);
        }
    }
}
